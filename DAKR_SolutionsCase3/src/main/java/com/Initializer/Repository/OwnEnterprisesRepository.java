package com.Initializer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Initializer.Model.OwnEnterprises;

@Repository
public interface OwnEnterprisesRepository extends JpaRepository<OwnEnterprises, Long> {

}
