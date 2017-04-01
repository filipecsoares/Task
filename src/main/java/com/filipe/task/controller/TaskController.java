package com.filipe.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.filipe.task.model.Task;
import com.filipe.task.repository.TaskRepository;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskRepository repository;

	@GetMapping
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("taskList");
		modelAndView.addObject("tasks", repository.findAll());

		modelAndView.addObject(new Task());
		return modelAndView;
	}

	@PostMapping
	public String save(Task task) {
		this.repository.save(task);
		return "redirect:/tasks";
	}
}
