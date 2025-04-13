package com.phoenix.todo.service;

import java.util.List;

import com.phoenix.todo.model.Task;

public interface TodoService {
	List<Task> getAlltasks();

	void createTodo(String title,Task task);

	void deleteTodo(Long id);

	void toggleTodo(Long id);
}
