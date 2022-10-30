package com.greatlearning.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // For creating default constructor
@AllArgsConstructor // For creating parameterized constructor
@Builder
public class FullName {
	
	private String firstName;
	private String lastName;

}
