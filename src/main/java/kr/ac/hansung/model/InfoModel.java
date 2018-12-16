package kr.ac.hansung.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InfoModel {

	private int year;
	private int semester;
	private int grade;
	
	@Size(min=4, max=10, message="subjectCode must be 8Size")
	@NotEmpty(message="The subjectCode cannot be empty.")
	private String subjectCode;
	
	@NotEmpty(message="The subjectName cannot be empty.")
	private String subjectName;
	private String division;
	
}
