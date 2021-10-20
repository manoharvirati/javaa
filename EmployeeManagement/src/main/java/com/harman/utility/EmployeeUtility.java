package com.harman.utility;

import com.harman.dto.Employee;

public class EmployeeUtility {

	public static Employee convertStringToEmployee(String data) {
		String[] elements = data.split(",");
		int id = Integer.parseInt(elements[0]);
		String name = elements[1];
		int salary = Integer.parseInt(elements[2]);
		int age = Integer.parseInt(elements[3]);
		String email = elements[4];
		Employee employee=new Employee(id, name, salary, age, email);
		return employee;
	}
	
}
