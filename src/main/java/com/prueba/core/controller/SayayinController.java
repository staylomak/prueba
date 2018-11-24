package com.prueba.core.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.core.model.Sayayin;
import com.prueba.core.repository.SayayinRepo;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class SayayinController 
{
	@Autowired
	SayayinRepo repo;
	
	@DeleteMapping("/sayayins/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSayayin(@PathVariable int id)
	{
		Sayayin s = repo.getOne(id);
		repo.delete(s);

	}
	
	@PostMapping("/sayayins")
	public Sayayin addSayayin(@RequestBody Sayayin sayayin)
	{

		repo.save(sayayin);
		return sayayin;
		
	}
	
	@PutMapping(path="/sayayins", consumes= {"application/json"})
	public Sayayin saveOrUpdatesayayin(@RequestBody Sayayin sayayin)
	{
		repo.save(sayayin);
		return sayayin;
		
	}
	

	@GetMapping("/sayayins")
	public List<Sayayin> getSayayins()
	{
		
		return repo.findAll();
	}
	
	@RequestMapping("/sayayins/{id}")
	public Optional<Sayayin> getSayayin(@PathVariable("id") int id)
	{
		
		return repo.findById(id);
	}
	
	
	
	
}
