package com.harman.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.harman.dto.Employee;

public interface EmployeeService {

	public int add(Employee employee) throws SQLException;
	public Employee get(int empId) throws SQLException;
	public ArrayList<Employee> getAll();
	public int update(Employee employee) throws SQLException;
	public int delete(int empId) throws SQLException;
	public int delete(String name) throws SQLException;
	public int deleteAll() throws SQLException;
	
}