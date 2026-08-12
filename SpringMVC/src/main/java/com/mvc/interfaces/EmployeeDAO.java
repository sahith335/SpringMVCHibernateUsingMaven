package com.mvc.interfaces;

import java.util.ArrayList;

import com.mvc.entity.Employee;



public interface EmployeeDAO {

	void insertEmployee(Employee e);
	ArrayList<Employee> fetchAll();
	Employee fetchSpecific(int id);
	Employee update(Employee e);
	void delete(int id);
}
