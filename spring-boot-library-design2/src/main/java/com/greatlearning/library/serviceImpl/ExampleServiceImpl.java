package com.greatlearning.library.serviceImpl;

import org.springframework.stereotype.Service;

import com.greatlearning.library.model.FullName;
import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.service.ExampleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService{
	
	@Override
	public GreatLearning get() {
		log.info("Inside get() metod");
		GreatLearning greatlearning = new GreatLearning();
		greatlearning.setCourseName("Learn Controllers in Spring Boot");
		greatlearning.setCourseType("Information Technology");
		greatlearning.setInstructorName(FullName.builder().firstName("Vikas").lastName("jaiswal").build());
		//greatlearning.setInstrutorName("vikas jaiswal");
		return greatlearning;
	}
	
	@Override
	public GreatLearning custominfo(String courseName, String courseType, String firstName, String lastName) {
		log.info("Inside customInfo() method");
		GreatLearning greatlearning = new GreatLearning();
		greatlearning.setCourseName(courseName);
		greatlearning.setCourseType(courseType);
		greatlearning.setInstructorName(FullName.builder().firstName("Vikas").lastName("Jaiswal").build());
		//greatlearning.setInstrutorName(instructorName);
		return greatlearning;
	}
}
