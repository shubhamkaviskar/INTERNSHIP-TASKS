package com.Initializer.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Initializer.Entities.Admin;

public interface RoleRepository extends JpaRepository<Admin, Long> {
	Optional<Admin> findByName(String name);
}
