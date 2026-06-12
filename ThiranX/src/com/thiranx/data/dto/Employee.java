package com.thiranx.data.dto;

public class Employee {
    private String employeeId;
    private String name;
    private String password;
    private Long dob;
    private String emailId;
    private String mobileNo;
    private String reportingTo;

    public Employee() {}

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Long getDob() { return dob; }
    public void setDob(Long dob) { this.dob = dob; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public String getMobileNo() { return mobileNo; }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public String getReportingTo() { return reportingTo; }
    public void setReportingTo(String reportingTo) { this.reportingTo = reportingTo; }
}