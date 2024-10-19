package com.Initializer.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Initializer.Model.DAKRSolutions;
import com.Initializer.Repository.DAKRSolutionsRepository;
import com.Initializer.Service.DAKRSolutionsService;

@Controller
public class DAKRSolutionsController {
	@Autowired
	private DAKRSolutionsService service;
	@Autowired
	private DAKRSolutionsRepository repo;
	
	private static final Logger logger = LogManager.getLogger(DAKRSolutionsController.class);

	@GetMapping("/")
	public String landingPage() {
		logger.info("Landing-Page Executed Correctly.");
		logger.atTrace();
		return "landingPage";
	}

	@GetMapping("/form")
	public String showForm(Model model) {
		logger.info("Form-URL Executed/Working Correctly.");
		model.addAttribute("dakrSolutions", new DAKRSolutions());
		logger.atTrace();
		return "dakrsForm";
	}

	@PostMapping("/saveForm")
	public String submitForm(@RequestParam("id") Long id,@RequestParam("name") String name, @RequestParam("goal") String goal,
			@RequestParam("fiveYearRoadmap") String fiveYearRoadmap) {
		DAKRSolutions dakrSolutions = new DAKRSolutions(id, name, goal, fiveYearRoadmap);
		DAKRSolutions dakrSolutions2 = repo.save(dakrSolutions);
		return "success";
	}

	@GetMapping("/all-solutions")
	public String getAllSolutions(Model model) {
		List<DAKRSolutions> solutions = service.getAllSolutions();
		model.addAttribute("solutions", solutions);
		logger.info("Fetched all solutions.");
		return "dakrsForm";
	}

}
