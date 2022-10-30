package com.greatlearning.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.service.ExampleService;
import com.greatlearning.library.serviceImpl.ExampleServiceImpl;

//@Controller
@RestController
public class ExampleController implements ExampleService {

	@Autowired
	ExampleServiceImpl exampleService;// injecting the object of ExampleService using injection 
	
	@Override
	@GetMapping("/info")
	// @ResponseBody
	public GreatLearning get() {
//		GreatLearning greatlearning = new GreatLearning();
//		greatlearning.setCourseName("Learn Controllers in Spring Boot");
//		greatlearning.setCourseType("Information Technology");
//	// greatlearning.setInstrutorName("vikas jaiswal");
		
		return exampleService.get();//abstracting logic form ExampleService Class
	}

	@Override
	@PostMapping("customInfo")
	public GreatLearning custominfo(String courseName, String courseType, String firstName, String lastName) {
//		GreatLearning greatlearning = new GreatLearning();
//		greatlearning.setCourseName(courseName);
//		greatlearning.setCourseType(courseType);
		//greatlearning.setInstrutorName(instructorName);
		
		
		return exampleService.custominfo(courseName, courseType, firstName, lastName);
	}

}
