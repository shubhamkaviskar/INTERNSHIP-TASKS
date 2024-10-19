package com.app.Initializer.services;

import com.app.Initializer.DTO.JWTAuthenticationResponse;
import com.app.Initializer.DTO.RefreshTokenRequest;
import com.app.Initializer.DTO.SignInRequest;
import com.app.Initializer.DTO.SignUpRequest;
import com.app.Initializer.entities.User;

public interface AuthenticationService {
	
	User signup(SignUpRequest signUpRequest);
	
	JWTAuthenticationResponse signin(SignInRequest signInRequest);
	
	JWTAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
