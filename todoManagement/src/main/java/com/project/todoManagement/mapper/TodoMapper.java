package com.project.todoManagement.mapper;

import com.project.todoManagement.dto.TodoDto;
import com.project.todoManagement.entity.Todo;

public class TodoMapper {
	
	//convert the jpa to dto 
	public static TodoDto mapTodoToTodoDto(Todo todo) {
		TodoDto newTodoDto = new TodoDto(
				
				todo.getId(),
				todo.getSubject(),
				todo.getDescription(),
				todo.isCompleted()
				
				);
		
		return newTodoDto;
	}
	
	//convert the dto to jpa
	public static Todo mapTodoToDtoTodo(TodoDto todoDto) {
		Todo newTodo = new Todo(
				
				todoDto.getId(),
				todoDto.getSubject(),
				todoDto.getDescription(),
				todoDto.isCompleted()
				
				);
		
		return newTodo;
	}

}
