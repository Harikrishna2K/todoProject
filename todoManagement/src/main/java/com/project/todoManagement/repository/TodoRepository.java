package com.project.todoManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.todoManagement.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}
