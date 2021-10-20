package com.harman.ui;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harman.service.EmployeeService;
import com.harman.service.EmployeeServiceImpl;


public class DeleteEmployeeByIdServlet extends HttpServlet {
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
		
		try {
			int empy = employeeService.delete(empId);
			if(empy == 1) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayDeleteEmployeeById.jsp");
				request.setAttribute("emp", empy);//requestScope data
				//For that request --> deleted once response has been sent back to browser
				dispatcher.include(request, response);//clear out variable
				
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
