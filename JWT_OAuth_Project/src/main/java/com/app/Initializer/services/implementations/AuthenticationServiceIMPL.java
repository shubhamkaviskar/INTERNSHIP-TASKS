package com.app.Initializer.services.implementations;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.app.Initializer.DTO.JWTAuthenticationResponse;
import com.app.Initializer.DTO.RefreshTokenRequest;
import com.app.Initializer.DTO.SignInRequest;
import com.app.Initializer.DTO.SignUpRequest;
import com.app.Initializer.Repository.UserRepository;
import com.app.Initializer.entities.Role;
import com.app.Initializer.entities.User;
import com.app.Initializer.services.AuthenticationService;
import com.app.Initializer.services.JWTService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTService jwtService;

	public User signup(SignUpRequest signUpRequest) {
		User user = new User();
		user.setEmail(signUpRequest.getEmail());
		user.setName(signUpRequest.getName());
		user.setSecondname(signUpRequest.getSecondname());
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		return userRepository.save(user);
	}

	public JWTAuthenticationResponse signin(SignInRequest signInRequest) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));

		var user = userRepository.findByEmail(signInRequest.getEmail())
				.orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

		var jwt = jwtService.generateToken(user);

		var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

		JWTAuthenticationResponse jwtAuthenticationResponse = new JWTAuthenticationResponse();

		jwtAuthenticationResponse.setToken(jwt);

		jwtAuthenticationResponse.setRefreshToken(refreshToken);

		return jwtAuthenticationResponse;
	}

	public JWTAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
		String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
		User user = userRepository.findByEmail(userEmail).orElseThrow();
		if (jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
			var jwt = jwtService.generateToken(user);
			JWTAuthenticationResponse jwtAuthenticationResponse = new JWTAuthenticationResponse();

			jwtAuthenticationResponse.setToken(jwt);

			jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());

			return jwtAuthenticationResponse;
		}
		return null;
	}

}
