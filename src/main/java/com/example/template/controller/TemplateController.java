package com.example.template.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.template.model.Template;
import com.example.template.repo.TemplateRepository;

@Controller
public class TemplateController {
	@Autowired
	private TemplateRepository repository;
	
	@GetMapping("/templates")
	public ResponseEntity<List<Template>> getAllTemplates() {
		try {
			List<Template> templates = new ArrayList<Template>();
			repository.findAll().forEach(templates::add);
			if(templates.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(templates, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/templates")
	public ResponseEntity<Template> createTemplate(@RequestBody Template template){
		try {
			Template _template = repository.save(new Template(template.getId(), template.getName(), template.getDescription()));
			return new ResponseEntity<>(_template, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
