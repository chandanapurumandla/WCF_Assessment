package com.cellphone.usage.data;

public class CellPhoneUsage {

	private String employeeId;
	private String date;
	private int totalMinutes;
	private float totalData;

	public CellPhoneUsage(String employeeId, String date, int totalMinutes, float totalData) {
		this.employeeId = employeeId;
		this.date = date;
		this.totalMinutes = totalMinutes;
		this.totalData = totalData;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTotalMinutes() {
		return totalMinutes;
	}

	public void setTotalMinutes(int totalMinutes) {
		this.totalMinutes = totalMinutes;
	}

	public float getTotalData() {
		return totalData;
	}

	public void setTotalData(float totalData) {
		this.totalData = totalData;
	}
}
