package com.phoenix.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenix.todo.model.Task;
import com.phoenix.todo.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoRepository todoRepository;
	@Override
	public List<Task> getAlltasks() {
		// TODO Auto-generated method stub
		return todoRepository.findAll();
	}
	@Override
	public void createTodo(String title,Task task) {
		task.setTitle(title);
		task.setCompleted(false);
		todoRepository.save(task);
	}
	@Override
	public void deleteTodo(Long id) {
		// TODO Auto-generated method stub
		todoRepository.deleteById(id);
	}
	@Override
	public void toggleTodo(Long id) {
		// TODO Auto-generated method stub
		Task t = todoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid task id"));
		t.setCompleted(!t.isCompleted());
		todoRepository.save(t);
	}

}
