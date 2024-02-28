package com.example.demo.serviceImpl;


import java.util.HashSet;
import java.util.List;
//import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.ServiceE;
import com.example.demo.model.Role;
import com.example.demo.model.model;
import com.example.demo.repository.Repository;
import com.example.demo.repository.RoleRepo;



@Service
public class ServiceImpl implements ServiceE {
 
	 @Autowired
	private Repository repository;
	 
	 @Autowired
	 private RoleRepo roleRepo;

	 
	
//	public ServiceImpl(Repository repository){
//		super();
//		this.repository=repository;
//	}
	
	@Override
	public model saveE(model model) {
	   Role role = roleRepo.findById("User").get();
	   Set<Role> userRoles = new HashSet<>();
	   userRoles.add(role);
	   model.setRole(userRoles);
		return repository.save(model);
	}

	@Override
	public List<model>getemployee(){
		
		return repository.findAll();
	}

	@Override
	public void deleteEm(String id) {
		 repository.deleteById(id);
	}

	@Override
	public model updateE(model model, String id) {
		model existemployee = repository.findById(id).orElseThrow();
//		System.out.println(existemployee);
		existemployee.setUsername(model.getUsername());
		existemployee.setFirstname(model.getFirstname());
		existemployee.setLastname(model.getLastname());
		existemployee.setEmail(model.getEmail());
		existemployee.setPassword(model.getPassword());
		repository.save(existemployee);
		return existemployee;
	}

	@Override
	public void initRoleAdmin() {
		 Role adminRole = roleRepo.findById("Admin").get();
		 model adminUser = new model();
	        adminUser.setUsername("admin123");
	        adminUser.setPassword("admin@pass");
	        adminUser.setFirstname("admin");
	        adminUser.setLastname("admin");
	        adminUser.setEmail("admin@gmail.com");
	        Set<Role> adminRoles = new HashSet<>();
	        adminRoles.add(adminRole);
	        adminUser.setRole(adminRoles);
	        repository.save(adminUser);
		
	}



	
	
	
	


}
