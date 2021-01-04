package com.app.model.bank;

import java.util.Objects;

import com.app.model.Address;

public class BankBranch {
	
	private String branchId;
	private Address address;
	private String managerId;
	
	public BankBranch() {
		super();
	}
	
	public BankBranch(String branchId, Address address, String managerId) {
		super();
		this.branchId = branchId;
		this.address = address;
		this.managerId = managerId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	
	@Override
	public boolean equals(Object anObject) {
		if(anObject == this) {
			return true;
		}
		
		if (anObject == null) {
			return false;
		}
		
		if(!(anObject instanceof BankBranch)) {
			return false;
		}
		
		BankBranch aBankBranch = (BankBranch) anObject;
		if (aBankBranch.branchId != branchId || aBankBranch.address != address ||
				aBankBranch.managerId != managerId) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(branchId);
	}

	@Override
	public String toString() {
		return "BankBranch [branchId=" + branchId + ", address=" + address + ", managerId=" + managerId + "]";
	}
	
}
