package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.RoleInterface;
import com.example.demo.Service.ServiceE;
import com.example.demo.model.Role;
import com.example.demo.model.model;

import jakarta.annotation.PostConstruct;



@RestController
@RequestMapping("/api/acess")
public class Controller {
	
	@Autowired
	private ServiceE service;
	@Autowired
	private RoleInterface roleInt;
	
//	Controller(ServiceE service, RoleInterface roleInt ){
//		super();
//		this.service = service;
//		this.roleInt = roleInt;
//	}
//	
	@PostConstruct
	public void initRoleAdmin() {
		service.initRoleAdmin();
	}
	@PostMapping()
public ResponseEntity<model> saveEmployee(@RequestBody model model) {
	return new ResponseEntity<model>(service.saveE(model), HttpStatus.CREATED);
		
	}
@GetMapping()
	public List<model> getEmploye() {
		return service.getemployee();
	
}
	@PutMapping("{id}")
	public ResponseEntity<model> updateEmployee(@RequestBody model model, @PathVariable("id") String id) {
		return new ResponseEntity<model>(service.updateE(model,id), HttpStatus.OK);
		
		}
	@DeleteMapping("{id}")
		public ResponseEntity<String> deleteE(@PathVariable("id") String id) {
		service.deleteEm(id);
		
			return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
		}
	@PostMapping("/createRole")
public ResponseEntity<Role> saveRole(@RequestBody Role role) {
	return new ResponseEntity<Role>(roleInt.saveRole(role), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/forAdmin")
	public String forAdmin() {
		return "ths is allow for admin only";
	}
	
	@GetMapping("/forUser")
	public String forUser() {
		return "ths is allow for user only";
	}



}