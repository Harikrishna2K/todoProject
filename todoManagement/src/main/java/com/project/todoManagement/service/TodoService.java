package com.project.todoManagement.service;

import java.util.List;

import com.project.todoManagement.dto.TodoDto;

public interface TodoService {
	
	TodoDto addTodo(TodoDto todoDto);
	
	TodoDto getTodo(Long id);
	
	List<TodoDto> getAllTodo();
	
	TodoDto updateTodo(TodoDto todoDto);
	
	void deleteTodo(Long id);
	
	TodoDto completeTodo(Long id);
	
	TodoDto incompleteTodo(Long id);

}
