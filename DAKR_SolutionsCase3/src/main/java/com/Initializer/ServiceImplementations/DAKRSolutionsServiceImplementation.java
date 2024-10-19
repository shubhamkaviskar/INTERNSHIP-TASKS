package com.Initializer.ServiceImplementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Initializer.Model.DAKRSolutions;
import com.Initializer.Repository.DAKRSolutionsRepository;
import com.Initializer.Service.DAKRSolutionsService;

@Service
public class DAKRSolutionsServiceImplementation implements DAKRSolutionsService {

	@Autowired
	private DAKRSolutionsRepository repository;

	public List<DAKRSolutions> getAllSolutions() {
		return repository.findAll();
	}
}
