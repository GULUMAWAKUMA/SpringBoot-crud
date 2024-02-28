package com.example.demo.model;

import lombok.Data;

@Data
public class JwtResponse {

	
	 private model user;
	 private String jwtToken;

    public JwtResponse(model user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }
}
