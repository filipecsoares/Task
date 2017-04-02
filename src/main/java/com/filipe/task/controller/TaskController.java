package com.filipe.task.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.filipe.task.model.Task;
import com.filipe.task.repository.TaskRepository;

@Controller
public class TaskController {

	@Autowired
	private TaskRepository repository;

	@GetMapping("/edit/{id}")
	public ModelAndView findOne(@PathVariable("id") Long id) {
		return add(repository.findOne(id));
	}

	@GetMapping("/")
	public ModelAndView find() {
		ModelAndView modelAndView = new ModelAndView("/taskList");
		modelAndView.addObject("tasks", repository.findAll());
		return modelAndView;
	}

	@GetMapping("/add")
	public ModelAndView add(Task task) {

		ModelAndView modelAndView = new ModelAndView("/taskEdit");
		modelAndView.addObject("task", task);

		return modelAndView;
	}

	@GetMapping("/{title}")
	public ModelAndView findByTitle(@PathVariable("title") String title) {
		ModelAndView modelAndView = new ModelAndView("taskList");
		modelAndView.addObject("tasks", repository.findByTitle(title));
		return modelAndView;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		this.repository.delete(id);
		return find();
	}

	@PostMapping
	public ModelAndView save(@Valid Task task, BindingResult result) {
		if (task != null && task.getId() == null)
			task.setRegistered(new Date());

		if (task != null && task.getConclude() && task.getConcluded() == null)
			task.setConcluded(new Date());

		task.setEdited(new Date());

		if (result.hasErrors()) {
			return add(task);
		}

		this.repository.save(task);

		return find();
	}
}
