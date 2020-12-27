package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dao.ClientCrudDAO;
import com.app.dao.dbutil.PostgresSqlConnection;
import com.app.exception.CompanyException;
import com.app.model.Client;

public class ClientCrudDAOImpl implements ClientCrudDAO{

	
	@Override
	public int createClient(Client client) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			
			String sql = "INSERT INTO my_company.client_info\r\n"
					+ "(client_id, client_company_name, client_first_name, client_last_name, "
					+ "client_gender, client_email, client_phone_number)"
					+ "VALUES(?,?,?,?,?,?,?); ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,client.getClientId());
			preparedStatement.setString(2,client.getCompanyName());
			preparedStatement.setString(3,client.getFirstName());
			preparedStatement.setString(4,client.getLastName());
			preparedStatement.setString(5,client.getGender());
			preparedStatement.setString(6,client.getEmail());
			preparedStatement.setString(7,client.getPhoneNumber());
			
			result = preparedStatement.executeUpdate();
		}catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return result;
	}

	
	@Override
	public void deleteClient(int id) throws CompanyException {
		String sql = "DELETE FROM my_company.client_info WHERE client_id = ?;";
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
	public int updateClientPhoneNumber(int id, String newPhoneNumber) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.client_info "
					+ "SET client_phone_number = ? "
					+ "WHERE client_id = ?";
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
	public int updateClienteEmail(int id, String newEmail) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.client_info "
					+ "SET client_email = ? "
					+ "WHERE client_id = ?";
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
	public int updateClientCompany(int id, String newCompany) throws CompanyException {
		int result = 0;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "UPDATE my_company.client_info "
					+ "SET client_company_name = ? "
					+ "WHERE client_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newCompany);
			preparedStatement.setInt(2, id);
			
			result = preparedStatement.executeUpdate();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
	}

	
	@Override
	public Client getClientById(int id) throws CompanyException {
		Client client = null;
		try(Connection connection = PostgresSqlConnection.getConnection()) {
			String sql = "SELECT client_id, client_company_name, client_first_name, client_last_name, "
					+ "client_gender, client_email, client_phone_number "
					+ "FROM my_company.client_info "
					+  "WHERE client_id = ?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				client = new Client();
				client.setClientId(id);
				client.setCompanyName(resultSet.getString("client_company_name"));
				client.setFirstName(resultSet.getString("client_first_name"));
				client.setLastName(resultSet.getString("client_last_name"));
				client.setGender(resultSet.getString("client_gender"));
				client.setEmail(resultSet.getString("client_email"));
				client.setPhoneNumber(resultSet.getString("client_phone_number"));
				
			}else {
				throw new CompanyException("No Client is found with ID: " + id);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return client;
	}

	
	@Override
	public List<Client> getAllClient() throws CompanyException {
		List<Client> clientList = new ArrayList<Client>();
		try(Connection connection = PostgresSqlConnection.getConnection()){
			String sql = "SELECT client_id, client_company_name, client_first_name, client_last_name, "
					+ "client_gender, client_email, client_phone_number "
					+ "FROM my_company.client_info";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Client temp = new Client();
				temp.setClientId(resultSet.getInt("client_id"));
				temp.setCompanyName(resultSet.getString("client_company_name"));
				temp.setFirstName(resultSet.getString("client_first_name"));
				temp.setLastName(resultSet.getString("client_last_name"));
				temp.setEmail(resultSet.getString("client_email"));
				temp.setGender(resultSet.getString("client_gender"));
				temp.setPhoneNumber(resultSet.getString("client_phone_number"));
				clientList.add(temp);
			}
			
			if(clientList.size()==0) {
				throw new CompanyException("No Client in the DB so far");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			throw new CompanyException("Internal Error Occured. Contact to System Admin");
		}
		return clientList;
	}

}
