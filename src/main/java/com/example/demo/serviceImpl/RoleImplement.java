package com.example.demo.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.demo.Service.RoleInterface;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepo;

@Service
public class RoleImplement implements RoleInterface {
	
	private RoleRepo roleRepo;
	public RoleImplement(RoleRepo roleRepo) {
		super();
		this.roleRepo=roleRepo;
	}

	@Override
	public Role saveRole(Role role) {
		
		return roleRepo.save(role);
	}
	

}
