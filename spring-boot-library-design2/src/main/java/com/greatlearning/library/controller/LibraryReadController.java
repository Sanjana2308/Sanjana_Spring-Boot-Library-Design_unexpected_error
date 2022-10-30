package com.greatlearning.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.service.LibraryReadService;

@RestController
@RequestMapping("/readService")
public class LibraryReadController {

	@Autowired
	LibraryReadService readService;

	@GetMapping("/getAllLibrary")
	public List<Library> getAllLibrary() {
		return readService.getAllLibrary();
	}

	@GetMapping("/getAllLibrariesWithNoBooks")
	public List<Library> getAllLibrariesWithNoBooks() {
		return readService.getAllLibrariesWithNoBooks();
	}

	@GetMapping("/getLibrariesPaged")
	public Page<Library> getLibrariesPaged() {
		return readService.getLibrariesPaged();
	}

	@GetMapping("/getLibrariesCustomPaged")
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage) {
		return readService.getLibrariesCustomPaged(pageNumber, numberOfRecordsOnAPage);
	}

	@GetMapping("/getLibrariesWithLatestAddedOrder")
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readService.getLibrariesWithLatestAddedOrder();

	}

	@GetMapping("/getLibrariesCustomSortedById")
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readService.getLibrariesCustomSortedById(direction);
	}

	@GetMapping("/getLibrariesCustomSortedByName")
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readService.getLibrariesCustomSortedByName(direction);
	}

	@GetMapping("/getLibrariesPagedAndSortedByNameAndWithTheseBooks")
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {
		return readService.getLibrariesPagedAndSortedByNameAndWithTheseBooks(commaSeperatedBookNames);
	}

	@GetMapping("/getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks")
	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
			String commaSeperatedBookNames, int pageNumber, int numberOfRecordsOnAPage) {
		return readService.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(
				commaSeperatedBookNames, pageNumber, numberOfRecordsOnAPage);
	}

	@GetMapping("/getSortedByNameAndWithTheseBooks")
	public List<Library> getSortedByNameAndWithTheseBooks(String commaSeperatedBookNames) {
		return readService.getSortedByNameAndWithTheseBooks(commaSeperatedBookNames);
	}

	@PostMapping("/getLibrariesByIds")
	public List<Library> getLibrariesByIds(@RequestBody List<Long> ids) {
		return readService.getLibrariesByIds(ids);
	}

	@GetMapping("/getALibraryById")
	public Optional<Library> getALibraryById(Long id) {
		return readService.getALibraryById(id);
	}
	
	@GetMapping("/getALibraryWithTheseBooks")
	public Optional<Library> getALibraryWithTheseBooks(String commaSeperatedBookNames) {
		return readService.getALibraryWithTheseBooks(commaSeperatedBookNames);
	}
	
	@GetMapping("/getLibrariesPagedAndSortedByName")
	public Page<Library> getLibrariesPagedAndSortedByName() {
		return readService.getLibrariesPagedAndSortedByName();
	}
	
}


