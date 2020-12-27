package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.model.Employee;
import com.app.dao.EmployeeCrudDAO;
import com.app.dao.dbutil.PostgresSqlConnection;
import com.app.exception.CompanyException;


public class EmployeeCrudDAOImpl implements EmployeeCrudDAO{

	@Override
	public int createEmployee(Employee employee) throws CompanyException {
		
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			
			String sql = "INSERT INTO my_company.employee_info\r\n"
					+ "(employee_id, first_name, last_name, email, gender, date_of_birth, country, "
					+ "state, city, street, cellphone, department_id) \r\n"
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?); ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,employee.getEmployeeId());
			preparedStatement.setString(2,employee.getFirstName());
			preparedStatement.setString(3,employee.getLastName());
			preparedStatement.setString(4,employee.getEmail());
			preparedStatement.setString(5,employee.getGender());
			preparedStatement.setDate(6, new java.sql.Date(employee.getDateOfBirth().getTime())); // util.Date to sql.Date
			preparedStatement.setString(7,employee.getCountry());
			preparedStatement.setString(8,employee.getState());
			preparedStatement.setString(9,employee.getCity());
			preparedStatement.setString(10,employee.getStreet());
			preparedStatement.setString(11,employee.getPhoneNumber());
			preparedStatement.setInt(12,employee.getDepartmentId());
			
			result = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return result;
	}

	
	@Override
	public void deleteEmployee(int id) throws CompanyException {
		
		String sql = "DELETE FROM my_company.employee_info WHERE employee_id = ?;";
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public int updateEmployeePhoneNumber(int id, String newPhoneNumber) throws CompanyException{

		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.employee_info "
					+ "SET cellphone = ? "
					+ "WHERE employee_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newPhoneNumber);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public int updateEmployeeEmail(int id, String newEmail) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.employee_info "
					+ "SET email = ? "
					+ "WHERE employee_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newEmail);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public int updateEmployeeStreet(int id, String newStreet) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.employee_info "
					+ "SET street = ? "
					+ "WHERE employee_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newStreet);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public int updateEmployeeCity(int id, String newCity) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.employee_info "
					+ "SET city = ? "
					+ "WHERE employee_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newCity);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public int updateEmployeeState(int id, String newState) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.employee_info "
					+ "SET state = ? "
					+ "WHERE employee_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newState);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public int updateEmployeeCountry(int id, String newCountry) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.employee_info "
					+ "SET country = ? "
					+ "WHERE employee_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newCountry);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public Employee getEmployeeById(int id) throws CompanyException {
		Employee employee = null;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "SELECT first_name, last_name, email, gender, date_of_birth, country, \r\n"
					+ "state, city, street, cellphone, department_id \r\n"
					+ "FROM my_company.employee_info\r\n"
					+  "WHERE employee_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				employee = new Employee();
				employee.setEmployeeId(id);
				employee.setFirstName(resultSet.getString("first_name"));
				employee.setLastName(resultSet.getString("last_name"));
				employee.setEmail(resultSet.getString("email"));
				employee.setGender(resultSet.getString("gender"));
				employee.setDateOfBirth(resultSet.getDate("date_of_birth"));
				employee.setCountry(resultSet.getString("country"));
				employee.setState(resultSet.getString("state"));
				employee.setCity(resultSet.getString("city"));
				employee.setStreet(resultSet.getString("street"));
				employee.setPhoneNumber(resultSet.getString("cellphone"));
				employee.setDepartmentId(resultSet.getInt("department_id"));
			}else {
				throw new CompanyException("No Employee is found with ID: " + id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return employee;
	}

	
	@Override
	public List<Employee> getAllEmployee() throws CompanyException{
		List<Employee> employeeList = new ArrayList<Employee>();
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = "SELECT employee_id, first_name, last_name, email, gender, date_of_birth, country, \r\n"
					+ "state, city, street, cellphone, department_id \r\n"
					+ "FROM my_company.employee_info";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Employee temp = new Employee();
				temp.setEmployeeId(resultSet.getInt("employee_id"));
				temp.setFirstName(resultSet.getString("first_name"));
				temp.setLastName(resultSet.getString("last_name"));
				temp.setEmail(resultSet.getString("email"));
				temp.setGender(resultSet.getString("gender"));
				temp.setDateOfBirth(resultSet.getDate("date_of_birth"));
				temp.setCountry(resultSet.getString("country"));
				temp.setState(resultSet.getString("state"));
				temp.setCity(resultSet.getString("city"));
				temp.setStreet(resultSet.getString("street"));
				temp.setPhoneNumber(resultSet.getString("cellphone"));
				temp.setDepartmentId(resultSet.getInt("department_id"));
				employeeList.add(temp);
			}
			
			if(employeeList.size()==0) {
				throw new CompanyException("No Employee in the DB so far");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return employeeList;
	}

}
