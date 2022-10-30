package com.greatlearning.library.model;

import com.greatlearning.library.model.FullName.FullNameBuilder;

import lombok.*;

@Data
@NoArgsConstructor // For creating default constructor
@AllArgsConstructor // For creating parameterized constructor
@Builder
public class GreatLearning {

	private String courseName;
	private String courseType;
	//private String instrutorName;
	private FullName instructorName;
	
	public GreatLearning(String courseName) {
		this.courseName=courseName;
	}
	
	public GreatLearning(String courseName,String courseType) {
		this.courseName=courseName;
		this.courseType=courseType;
	}

//	public GreatLearning(String courseName, String courseType, String instrutorName) {
//		super();
//		this.courseName = courseName;
//		this.courseType = courseType;
//		this.instrutorName = instrutorName;
//	}

//	@Override
//	public String toString() {
//		return "GreatLearning [courseName=" + courseName + ", courseType=" + courseType + ", instrutorName="
//				+ instrutorName + "]";
//	}

}
