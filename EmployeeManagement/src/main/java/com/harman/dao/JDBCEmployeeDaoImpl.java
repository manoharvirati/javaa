package com.harman.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.harman.dto.Employee;

public class JDBCEmployeeDaoImpl implements EmployeeDao{
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	
	public JDBCEmployeeDaoImpl() throws Exception {
		Properties p=new Properties();
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
			p.load(new InputStreamReader(is));
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.driverClassName = p.getProperty("driver.class.name");
		this.url = p.getProperty("db.url");
		this.username = p.getProperty("db.username");
		this.password = p.getProperty("db.password");
	}
	
	public JDBCEmployeeDaoImpl(String driverClassName, String url, String username, String password) {
		super();
		this.driverClassName = driverClassName;
		this.url = url;
		this.username = username;
		this.password = password;
	}

	//@Override
	public int add(Employee employee) throws SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = 
					connection.prepareStatement("insert into Employee(empId,name,salary,age,email) values(?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getEmpId());
		preparedStatement.setString(2, employee.getName());// */ \delete from t_employee /*
		preparedStatement.setInt(3, employee.getSalary());
		preparedStatement.setInt(4, employee.getAge());
		preparedStatement.setString(5, employee.getEmail());
		
		int result =preparedStatement.executeUpdate();
		
		preparedStatement.close();
		close(connection);
		return result;
	}

	//@Override
	public Employee get(int empId) throws SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = 
					connection.prepareStatement("select * from Employee where empId = ?");
		preparedStatement.setInt(1, empId);
	
		ResultSet resultSet =preparedStatement.executeQuery();
		if(resultSet.next()) {
			Employee employee=new Employee();
			employee.setEmpId(resultSet.getInt("empId"));
			employee.setName(resultSet.getString("name"));
			employee.setSalary(resultSet.getInt("salary"));
			employee.setAge(resultSet.getInt("age"));
			employee.setEmail(resultSet.getString("email"));
			return employee;
		}
		
		resultSet.close();
		preparedStatement.close();
		close(connection);
		return null;
	}

	//@Override
	public ArrayList<Employee> getAll() {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = 
						connection.prepareStatement("select * from Employee");
		
			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()) {
				Employee employee=new Employee();
				employee.setEmpId(resultSet.getInt("empId"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getInt("salary"));
				employee.setAge(resultSet.getInt("age"));
				employee.setEmail(resultSet.getString("email"));
				employees.add(employee);
			}
			resultSet.close();
			preparedStatement.close();
			close(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	//@Override
	public int update(Employee employee) throws SQLException {
		System.out.println("helooooooooooooooooooooo");
		Connection connection = getConnection();
		PreparedStatement preparedStatement = 
					connection.prepareStatement("update Employee set name = ?, salary = ?, age = ?, email = ? where empId = ?");
		preparedStatement.setInt(5, employee.getEmpId());
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setInt(2, employee.getSalary());
		preparedStatement.setInt(3, employee.getAge());
		preparedStatement.setString(4, employee.getEmail());
	
		int result = preparedStatement.executeUpdate();
		System.out.println("helooooooooooooooooooooo");
		
		preparedStatement.close();
		close(connection);
		return result;
	}

	//@Override
	public int delete(int empId) throws SQLException {
				Connection connection = getConnection();
		PreparedStatement preparedStatement =
					connection.prepareStatement("delete from Employee where empId = ?");
		preparedStatement.setInt(1, empId);
	
		int resultSet =preparedStatement.executeUpdate();
		
		//resultSet.close();
		preparedStatement.close();
		close(connection);
		return 1;
	}

	//@Override
	public int delete(String name) throws SQLException {
		// delete from t_employees where name = ?
		return 0;
	}

	//@Override
	public int deleteAll() throws SQLException {
		// delete from t_employees
		return 0;
	}
	
	private Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	private boolean close(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;	
	}
	
}
