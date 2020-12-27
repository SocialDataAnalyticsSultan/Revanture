package com.app.dao;

import java.util.List;

import com.app.exception.CompanyException;
import com.app.model.Client;

public interface ClientCrudDAO {
	
	public int createClient (Client client) throws CompanyException;
	public void deleteClient(int id) throws CompanyException;
	
	public int updateClientPhoneNumber(int id, String newPhoneNumber) throws CompanyException;
	public int updateClienteEmail(int id, String newEmail) throws CompanyException;
	public int updateClientCompany(int id, String newCompany) throws CompanyException;
	
	public Client getClientById (int id) throws CompanyException;
	public List<Client> getAllClient() throws CompanyException;

}
