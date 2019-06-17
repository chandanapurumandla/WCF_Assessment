package com.cellphone.usage.data;

public class CellPhone{
	
	private String employeeId;
	private String employeeName;
	private String purchaseDate;
	private String model;

	public CellPhone(String employeeId, String employeeName, String purchaseDate, String model) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.purchaseDate = purchaseDate;
		this.model = model;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	} 
}