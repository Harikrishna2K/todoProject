package com.project.todoManagement.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class TodoDto {
	
	
	private Long id;
	
	
	private String subject;
	
	
	private String description;
	
	
	private boolean isCompleted;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isCompleted() {
		return isCompleted;
	}


	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}


	public TodoDto(Long id, String subject, String description, boolean isCompleted) {
		super();
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.isCompleted = isCompleted;
	}


	public TodoDto() {
		super();
	}
	
	

}
