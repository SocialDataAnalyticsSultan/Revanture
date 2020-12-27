package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.DepartmentCrudDAO;
import com.app.dao.dbutil.PostgresSqlConnection;
import com.app.exception.CompanyException;
import com.app.model.Department;

public class DepartmentCrudDAOImpl implements DepartmentCrudDAO {

	@Override
	public int createDepartment(Department department) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			
			String sql = "INSERT INTO my_company.department_info "
					+ "(department_id, department_name, country, state, city, manager_id) "
					+ "VALUES(?,?,?,?,?,?); ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,department.getDepartmentId());
			preparedStatement.setString(2,department.getDepartmentName());
			preparedStatement.setString(3,department.getCountry());
			preparedStatement.setString(4,department.getState());
			preparedStatement.setString(5,department.getCity());
			preparedStatement.setInt(6,department.getManagerId());
			
			result = preparedStatement.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return result;
	}

	
	@Override
	public void deleteDepartment(int id) throws CompanyException {
		String sql = "DELETE FROM my_company.department_info WHERE department_id = ?;";
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
	public int updateDepartmentName(int id, String newDepartmentName) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.department_info "
					+ "SET department_name = ? "
					+ "WHERE department_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newDepartmentName);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public int updateDepartmentCity(int id, String newCity) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.department_info "
					+ "SET city = ? "
					+ "WHERE department_id = ?";
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
	public int updateDepartmentState(int id, String newState) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.department_info "
					+ "SET state = ? "
					+ "WHERE department_id = ?";
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
	public int updateDepartmentCountry(int id, String newCountry) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.department_info "
					+ "SET country = ? "
					+ "WHERE department_id = ?";
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
	public int updateManagerId(int id, int newManagerId) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.department_info "
					+ "SET manager_id = ? "
					+ "WHERE department_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, newManagerId);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public Department getDepartmentById(int id) throws CompanyException {
		Department department = null;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "SELECT department_id, department_name, country, state, city, manager_id "
					+ "FROM my_company.department_info "
					+  "WHERE department_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				department = new Department();
				department.setDepartmentId(id);
				department.setDepartmentName(resultSet.getString("department_name"));
				department.setCountry(resultSet.getString("country"));
				department.setState(resultSet.getString("state"));
				department.setCity(resultSet.getString("city"));
				department.setManagerId(resultSet.getInt("manager_id"));
			}else {
				throw new CompanyException("No Department is found with ID: " + id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return department;
	}

	
	@Override
	public List<Department> getAllDepartment() throws CompanyException {
		List<Department> departmentList = new ArrayList<Department>();
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = "SELECT department_id, department_name, country, state, city, manager_id "
					+ "FROM my_company.department_info ";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Department temp = new Department();
				temp.setDepartmentId(resultSet.getInt("department_id"));
				temp.setDepartmentName(resultSet.getString("department_name"));
				temp.setCountry(resultSet.getString("country"));
				temp.setState(resultSet.getString("state"));
				temp.setCity(resultSet.getString("city"));
				temp.setManagerId(resultSet.getInt("manager_id"));
				departmentList.add(temp);
			}
			
			if(departmentList.size()==0) {
				throw new CompanyException("No Department in the DB so far");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return departmentList;
	}

}
