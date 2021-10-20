package com.harman.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.harman.dao.EmployeeDao;
import com.harman.dao.JDBCEmployeeDaoImpl;
import com.harman.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() throws Exception{
		this.employeeDao = new JDBCEmployeeDaoImpl();
	}
	
	
	public EmployeeServiceImpl(String driverClassName, String url, String username, String password) {
		this.employeeDao = new JDBCEmployeeDaoImpl(driverClassName, url, username, password);
	}
	

	//@Override
	public int add(Employee employee) throws SQLException {
		if(!(employee.getEmpId() > 0 && 
			employee.getName() != null && 
			employee.getSalary() > 35000 && 
			employee.getAge() > 18 && 
			employee.getEmail() != null)) {
			System.err.println("Invalid data in employee from EmployeeServiceImpl.add(Employee)");
			return 0;
		}else {
			int result = employeeDao.add(employee);
			return result;
		}
		
	}

	//@Override
	public Employee get(int empId) throws SQLException {
		
		return employeeDao.get(empId);
	}

	//@Override
	public ArrayList<Employee> getAll() {
		
		return employeeDao.getAll();
	}

	//@Override
	public int update(Employee employee) throws SQLException {
		
		return employeeDao.update(employee);
	}

	//@Override
	public int delete(int empId) throws SQLException {
		
		return employeeDao.delete(empId);
	}

	//@Override
	public int delete(String name) throws SQLException {
		
		return employeeDao.delete(name);
	}

	//@Override
	public int deleteAll() throws SQLException {
		
		return employeeDao.deleteAll();
	}

}
