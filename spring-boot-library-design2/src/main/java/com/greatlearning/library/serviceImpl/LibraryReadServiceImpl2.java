package com.greatlearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;

@Service
public class LibraryReadServiceImpl2 {

	@Autowired
	LibraryRepository readRepository;

	public List<Library> getAllLibrary() {
		return readRepository.findAll();
	}

	public List<Library> getAllLibrariesWtihNoBooks() {
		Library libraryWithNoBooks = new Library();
		libraryWithNoBooks.setCommaSeperatedBooknames("");
		// exampleMatcher will make sure that only commaSepretedBook is considered and
		// Id and name are ignored
		ExampleMatcher ecampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("Id", "name");
		Example<Library> example = Example.of(libraryWithNoBooks, ecampleMatcher);
		return readRepository.findAll(example);

	}

	public Page<Library> getLibrariesPaged() {
		Pageable first3records = PageRequest.of(1, 3);
		return readRepository.findAll(first3records);
	}

	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage) {
		Pageable first3records = PageRequest.of(pageNumber, numberOfRecordsOnAPage);
		return readRepository.findAll(first3records);
	}

	// Fetching data in latest added order we want to fetch all the orders
	// but we want to sorted by id and the sorting should be in descending order
	public List<Library> getLibrariesWithLatestAddedOrder() {

		return readRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	// Fetching data according to pass direction weather ascending or descending
	// order based on id
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "id"));
	}
	

	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "name"));
	}
	
	//Fetching the number of records and on the page based on given total number of records on number of page and whose 
	//Book name is as same as given below in parameter
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {
		
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBooknames(commaSeperatedBookNames);
		 		ExampleMatcher ecampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("Id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, ecampleMatcher);
		Pageable first3records = PageRequest.of(0,2,Sort.by("name"));
		return readRepository.findAll(example, first3records);
	}
	
	//Fetching the records based on ascending or descending order of name and represents it on number of page and 
	//number of records as per given below
	public Page<Library> getLibrariesPagedAndSortedByName() {

		Pageable pageable = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(pageable);
	}

	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(String commaSepratedBookNames,
			int pageNumber, int nunberOfRecordsOnAPage) {

		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBooknames(commaSepratedBookNames);
		 		ExampleMatcher ecampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("Id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, ecampleMatcher);
		Pageable customPage = PageRequest.of(pageNumber,nunberOfRecordsOnAPage,Sort.by("name"));
		return readRepository.findAll(example, customPage);
	}
	
	public List<Library> getSortedByNameAndWithTheseBooks(String commandSepratedBookName) {
		
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBooknames(commandSepratedBookName);
		 		ExampleMatcher ecampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("Id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, ecampleMatcher);
		return readRepository.findAll(example,Sort.by("name"));
		
	}
}
