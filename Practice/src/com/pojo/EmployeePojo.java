package com.pojo;

public class EmployeePojo {
	private int empId;
	private String empName;
	private String empPassword;
	private String empDept;
	private int empStatus;

	public EmployeePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeePojo(int empId, String empName, String empPassword, String empDept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPassword = empPassword;
		this.empDept = empDept;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public int getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(int empStatus) {
		this.empStatus = empStatus;
	}

	@Override
	public String toString() {
		return "EmployeePojo [empId=" + empId + ", empName=" + empName + ", empPassword=" + empPassword + ", empDept="
				+ empDept + ", empStatus=" + empStatus + "]";
	}

}
