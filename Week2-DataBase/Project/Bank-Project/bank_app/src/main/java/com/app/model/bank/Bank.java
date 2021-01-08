package com.app.model.bank;

import java.util.Objects;

import com.app.model.Address;

public class Bank {

	private int branchId;
	private Address address;
	private int managerId;
	
	public Bank() {
		super();
	}
	
	public Bank(int branchId, Address address, int managerId) {
		super();
		this.branchId = branchId;
		this.address = address;
		this.managerId = managerId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Bank [branchId=" + branchId + ", address=" + address + ", managerId=" + managerId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(branchId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Bank)) {
			return false;
		}
		Bank other = (Bank) obj;
		return branchId == other.branchId;
	}
	
}
