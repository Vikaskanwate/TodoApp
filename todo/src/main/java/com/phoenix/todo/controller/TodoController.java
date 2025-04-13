package com.phoenix.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phoenix.todo.model.Task;
import com.phoenix.todo.service.TodoService;

@Controller
@RequestMapping("/tasks")
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/")
	public String getAll(Model model) {
		List<Task> tList = todoService.getAlltasks();
		model.addAttribute("tList",tList);
		return "tasks";
	}
	
	@PostMapping("/add")
	public String createTodo(@RequestParam String title,Task task) {
		todoService.createTodo(title,task);
		return "redirect:/tasks/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTodo(@PathVariable Long id) {
		todoService.deleteTodo(id);
		return "redirect:/tasks/";
	}
	
	@GetMapping("/toggle/{id}")
	public String toggleTodo(@PathVariable Long id) {
		todoService.toggleTodo(id);
		return "redirect:/tasks/";
	}
	
}
