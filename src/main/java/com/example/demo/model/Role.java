package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Role")
public class Role {
		@Id
	    private String roleName;
	    private String roleDescription;
	
}
