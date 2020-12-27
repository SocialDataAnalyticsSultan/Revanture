package com.app.main;

import java.util.List;

import com.app.dao.ClientCrudDAO;
import com.app.dao.impl.ClientCrudDAOImpl;
import com.app.exception.CompanyException;
import com.app.model.Client;

public class ClientMain {

	public static void main(String[] args) {
		ClientCrudDAO dao = new ClientCrudDAOImpl();
		Client client = new Client("Sultan", "Anbar","Female", "704-000-1111","sanbar@com", 161, "Asya Inc");
		
		try {
			if(dao.createClient(client) != 0) {
				System.out.println("Client information created succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.deleteClient(161);
			System.out.println("Client information deleted succesfully...");
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateClientPhoneNumber(160, "704-482-0000") != 0) {
				System.out.println("Client phone number updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateClienteEmail(160, "lniesegen1@ameblo.jp") != 0) {
				System.out.println("Client email updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			if(dao.updateClientCompany(160, "TransMontaigne Partners L.P.") != 0) {
				System.out.println("Client company updated succesfully...");
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			client = dao.getClientById(160);
			if (client != null) {
				System.out.println("Details of client information: ");
				System.out.println(client.toString());
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			List<Client> clientList=dao.getAllClient();
			if(clientList!=null && clientList.size()!=0) {
				System.out.println("\n\nFound "+clientList.size()+" no of client in DB.... Printing them all");
				for(Client cli:clientList) {
					System.out.println(cli);
				}
			}
		} catch (CompanyException e) {
			System.out.println(e.getMessage());
		}

	}

}
