package com.greatlearning.library;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.library.controller.LibraryExistController;
import com.greatlearning.library.entity.Library;
import com.greatlearning.library.model.FullName;
import com.greatlearning.library.model.GreatLearning;
import com.greatlearning.library.service.LibraryReadService;
import com.greatlearning.library.serviceImpl.LibraryReadServiceImpl;
import com.greatlearning.library.serviceImpl.LibraryReadServiceImpl2;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j // It's a class level annotation and it's a logger with lombok annotation
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("Hello Spring Boot");
		System.out.println("Hello Dev-Tools");
	}

	@Autowired
	LibraryReadServiceImpl2 libraryReadService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("Fetch all libraries -> {}", libraryReadService.getAllLibrary());
		log.info("Fetch libraries with no books ->{}", libraryReadService.getAllLibrariesWtihNoBooks());
		log.info("Fetch Libraries in Page format -> {}",
				libraryReadService.getLibrariesPaged().get().collect(Collectors.toList()));
		log.info("Fetc Libraries in custom page format -> {}",
				libraryReadService.getLibrariesCustomPaged(2, 2).get().collect(Collectors.toList()));
		log.info("Fetch libraries with latest added order in descenging order -> {}",
				libraryReadService.getLibrariesWithLatestAddedOrder());
		log.info("Fetch libraries custom sorted by id -> {}",
				libraryReadService.getLibrariesCustomSortedById(Direction.DESC));
		log.info("Fetch Libraries custom sorted by name -> {}",
				libraryReadService.getLibrariesCustomSortedByName(Direction.DESC));
		log.info("Fetch Libraries default paged, sorted and with these books -> {}", libraryReadService
				.getLibrariesPagedAndSortedByNameAndWithTheseBooks("xyz, abc, efg").get().collect(Collectors.toList()));
		log.info("Fetching Libraries default paged and default sorted -> {}",
				libraryReadService.getLibrariesPagedAndSortedByName().get().collect(Collectors.toList()));
		log.info("Fetch Libraries custom paged and default sorted by name and with these books -> {}",
				libraryReadService
						.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks("xyz, abc, efg", 0, 2)
						.get().collect(Collectors.toList()));
		log.info("Fetch Libraries with default sorted by name ->{}",
				libraryReadService.getSortedByNameAndWithTheseBooks("xyz, abc, efg"));

//		GreatLearning greatlearning = new GreatLearning();
//		greatlearning.setCourseName("Designing microserverces");
//		greatlearning.setCourseType("Information Technologyt");
//		//greatlearning.setInstrutorName("Vikas Jaisewal");
//		System.out.println("Great learning Objects :" + greatlearning);
//		// greatlearning.setCourseName("Designing Microvervisec with Spring boot");
//		// greatlearning.setCourseType("Information Technology");
//		// greatlearning.setInstrutorName("Vikas Jaiswal");
//		// System.out.println("Great Learning :"+greatlearning);
//
////		GreatLearning greatlearningUsisngAllArgaConstructor = new GreatLearning("Designing microserverces",
////				"Information Technologyt", "Vikas Jaisewal");
//		//System.out.println("Great Learning with all args constructor:" + greatlearningUsisngAllArgaConstructor);
//
//		// Design pattern
//		GreatLearning greatLearningTeleDesignPattern = new GreatLearning("Learn Creational Design",
//				"Information Technology");
//		System.out.println("GreatLearningTeleDesignPattern :" + greatLearningTeleDesignPattern);
//		// Design Builder pattern
//		GreatLearning greatLearningWithBuilderPattern = GreatLearning.builder().courseName("Lear Builder Pattern")
//				.courseType("Information Technology").build();
//		System.out.println("Implimentation with Builder pattern :" + greatLearningWithBuilderPattern);
//
//		GreatLearning greatLearningOnlyCourseName = GreatLearning.builder().courseName("Lear Bulder pattern").build();
//		System.out.println("GreatLearning Only courseName with Builder Pattern :" + greatLearningOnlyCourseName);

//		GreatLearning greatLearningComplexObject = GreatLearning.builder()
//				.courseName("Complex object creation with builder pattern").courseType("Information Technology")
//				.instructorName(FullName.builder().firstName("Vikas").lastName("Jaiswal").build()).build();
//	//	System.out.println("Complex Object Creation with builder pattern " + greatLearningComplexObject);
//		
//		log.info("Complex Object Creation with builder pattern -> {}",greatLearningComplexObject);
	}

}
