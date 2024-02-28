package com.example.demo.Service;


import java.util.List;

import com.example.demo.model.model;

public interface ServiceE {
	model saveE(model model);
	List<model> getemployee();
	void initRoleAdmin();
	void deleteEm(String id);
	model updateE(model model, String id);

	
}
