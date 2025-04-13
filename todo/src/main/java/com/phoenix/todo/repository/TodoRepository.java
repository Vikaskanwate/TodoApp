package com.phoenix.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenix.todo.model.Task;

public interface TodoRepository extends JpaRepository<Task, Long>{

}
