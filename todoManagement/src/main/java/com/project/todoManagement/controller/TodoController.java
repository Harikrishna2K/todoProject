package com.project.todoManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.todoManagement.dto.TodoDto;

import com.project.todoManagement.service.TodoService;

/*
 * Handled the security by implementing the role based authentication 
 * with the method level security approach
 * 
 *  
 * 
 * 
 * */

@RestController
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addTodo")
	private ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
		TodoDto savedTodo = todoService.addTodo(todoDto);
		return new ResponseEntity<TodoDto>(savedTodo, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/{id}")
	private ResponseEntity<TodoDto> getTodoById(@PathVariable("id") Long id){
		
		TodoDto getTodo = todoService.getTodo(id);
		return new ResponseEntity<>(getTodo, HttpStatus.CREATED);
				
	}
	
	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping("/todoAll")
	private ResponseEntity<List<TodoDto>> getAll(){
		List<TodoDto> getAll = todoService.getAllTodo();
		return new ResponseEntity<List<TodoDto>>(getAll, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	private ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long id, @RequestBody TodoDto todoDto){
		TodoDto updateTodo = todoService.updateTodo(todoDto);
		return new ResponseEntity<TodoDto>(updateTodo, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	private ResponseEntity<String> deleteTodo(@PathVariable("id") Long id){
	   todoService.deleteTodo(id);
		
	   return ResponseEntity.ok("Todo deleted successfully!.");
		
	}
	
	@PatchMapping("/{id}/complete")
	private ResponseEntity<TodoDto> completeTodo(@PathVariable("id")Long todoid){
		TodoDto todo = todoService.completeTodo(todoid);
		
		return ResponseEntity.ok(todo);
	}
	
	@PatchMapping("/{id}/incomplete")
	private ResponseEntity<TodoDto> incompleteTodo(@PathVariable("id")Long todoid){
		TodoDto todo = todoService.incompleteTodo(todoid);
		
		return ResponseEntity.ok(todo);
	}

}
