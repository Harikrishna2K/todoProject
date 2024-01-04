package com.project.todoManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todoManagement.dto.TodoDto;
import com.project.todoManagement.entity.Todo;
import com.project.todoManagement.exception.ResourceNotFoundException;
import com.project.todoManagement.repository.TodoRepository;


@Service
public class TodoServiceImpl implements TodoService{
	
	
	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TodoDto addTodo(TodoDto todoDto) {
		//Convert the dto to jpa entity
//		Todo todo = modelMapper.map(todoDto, Todo.class);
//		todo.setSubject(todoDto.getSubject());
//		todo.setDescription(todoDto.getDescription());
//		todo.setCompleted(todo.isCompleted());
		
		
		
//		Todo savedTodo = todoRepository.save(todo);
		
		//convert the jpa to dto 
//		TodoDto savedToTodoDto = modelMapper.map(savedTodo, TodoDto.class);
//		savedToTodoDto.setId(savedTodo.getId());
//		savedToTodoDto.setSubject(savedTodo.getSubject());
//		savedToTodoDto.setDescription(savedTodo.getDescription());
//		savedToTodoDto.setCompleted(savedTodo.isCompleted());
		
		
		
		   Todo todo = modelMapper.map(todoDto, Todo.class);

	        // Todo Jpa entity
	        Todo savedTodo = todoRepository.save(todo);

	        // Convert saved Todo Jpa entity object into TodoDto object

	        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);

	        return savedTodoDto;
		
		
	}

	@Override
	public TodoDto getTodo(Long id) {
		// TODO Auto-generated method stub
		
		Todo todo = todoRepository.findById(id).orElseThrow(
				()->  new ResourceNotFoundException("Todo", "id", id)
				);
		
		
		return modelMapper.map(todo, TodoDto.class);
	}

	@Override
	public List<TodoDto> getAllTodo() {
		// TODO Auto-generated method stub
		
		List<Todo> todos = todoRepository.findAll();
		
		return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public TodoDto updateTodo(TodoDto todoDto) {
		
		
		
		
		
		Todo existingTodo = todoRepository.findById(todoDto.getId()).
				orElseThrow(() -> new ResourceNotFoundException("Todo", "id ", todoDto.getId()));
				
				
				
		existingTodo.setSubject(todoDto.getSubject());
		existingTodo.setDescription(todoDto.getDescription());
		existingTodo.setCompleted(todoDto.isCompleted());
		
	
		return modelMapper.map(existingTodo, todoDto.getClass());
	}

	@Override
	public void deleteTodo(Long id) {
		
		Todo deleteTodo = todoRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Todo", "id", id)
				);
		
		
		
	}

	@Override
	public TodoDto completeTodo(Long id) {
		
		Todo todo = todoRepository.findById(id).orElseThrow(
				
				() -> new ResourceNotFoundException("Todo", "id", id)
				
				);
				
				
				
		todo.setCompleted(true);
		
		
		Todo updatedTodo = todoRepository.save(todo);
		
		
		return modelMapper.map(updatedTodo, TodoDto.class);
	}

	@Override
	public TodoDto incompleteTodo(Long id) {
		
		Todo todo = todoRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Todo", "id", id)
				
				);
		todo.setCompleted(Boolean.FALSE);
		
		Todo updateTodo = todoRepository.save(todo);
		
		return modelMapper.map(updateTodo, TodoDto.class);
	}

	

	
}
