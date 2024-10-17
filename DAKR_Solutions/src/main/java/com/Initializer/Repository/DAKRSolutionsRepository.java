package com.Initializer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Initializer.Model.DAKRSolutions;

@Repository
public interface DAKRSolutionsRepository extends JpaRepository<DAKRSolutions, Long> {

}
