package com.harman.ui;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harman.dto.Employee;
import com.harman.service.EmployeeService;
import com.harman.service.EmployeeServiceImpl;


public class UpdateEmployeeByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private EmployeeService employeeService;
	
	//On first request
	@Override
	public void init() throws ServletException {
		ServletContext application =  getServletContext();//applicationScope data
		//application --> for the entire duration of the application
		employeeService = new EmployeeServiceImpl(
													(String)application.getAttribute("driverClassName"), 
													(String)application.getAttribute("url"), 
													(String)application.getAttribute("username"), 
													(String)application.getAttribute("password")
												);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		String name = request.getParameter("name");
		int salary = Integer.parseInt(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		
		
		Employee employee = new Employee(empId, name, salary, age, email);
		try {
	
			int result = employeeService.update(employee);
			if(result == 1) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateEmployeeById.jsp");
				request.setAttribute("emp", result);//requestScope data
				//For that request --> deleted once response has been sent back to browser
				dispatcher.include(request, response);//clear out variable
				
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
