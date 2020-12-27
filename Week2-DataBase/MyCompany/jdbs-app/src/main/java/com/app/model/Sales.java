package com.app.model;


import java.math.BigDecimal;
import java.util.Date;

public class Sales {
	
	private int salesId;
	private int employeeId;
	private int clientId;
	private Date dateOfSale;
	private BigDecimal amount;
	
	public Sales() {
		super();
	}
	
	public Sales(int salesId, int employeeId, int clientId, Date dateOfSale, BigDecimal amount) {
		super();
		this.salesId = salesId;
		this.employeeId = employeeId;
		this.clientId = clientId;
		this.dateOfSale = dateOfSale;
		this.amount = amount;
	}

	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
	public Date getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Sales [salesId=" + salesId + ", employeeId=" + employeeId + ", clientId=" + clientId + ", dateOfSale="
				+ dateOfSale + ", amount=" + amount + "]";
	}

}
