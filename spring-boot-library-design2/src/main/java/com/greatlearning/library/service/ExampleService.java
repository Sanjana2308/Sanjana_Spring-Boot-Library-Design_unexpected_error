package com.greatlearning.library.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.library.model.GreatLearning;

@Component
public interface ExampleService {

	// @ResponseBody
	GreatLearning get();

	GreatLearning custominfo(String courseName, String courseType, String firstName, String lastName);

}