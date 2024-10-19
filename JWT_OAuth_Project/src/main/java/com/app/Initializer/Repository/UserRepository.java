package com.app.Initializer.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.Initializer.entities.Role;
import com.app.Initializer.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	User findByRole(Role role);
}
