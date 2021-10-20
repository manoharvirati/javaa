package com.harman.ui;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harman.dto.Employee;
import com.harman.service.EmployeeService;
import com.harman.service.EmployeeServiceImpl;

public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService;
	
	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		String driverClassName = config.getInitParameter("driverClassName"); 
		String url = config.getInitParameter("url"); 
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		
		ServletContext application =  getServletContext();
		application.setAttribute("driverClassName", driverClassName);
		application.setAttribute("url", url);
		application.setAttribute("username", username);
		application.setAttribute("password", password);
		
		employeeService = new EmployeeServiceImpl(driverClassName, url, username, password);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int empId = Integer.parseInt(request.getParameter("empId"));
		String name = request.getParameter("name");
		int salary = Integer.parseInt(request.getParameter("salary"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		
		
		Employee employee = new Employee(empId, name, salary, age, email);
		
		try {
			int result = employeeService.add(employee);
			request.setAttribute("result", result);
			request.getRequestDispatcher("DisplayAddEmployee.jsp").forward(request, response);//forward
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}

}