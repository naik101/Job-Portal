package com.jobportal.entities;

public class Jobs {

private	int job_id;
private	String title;
private	String company;
private	String location;
private	double salary;

public Jobs()
{
	
}

public Jobs(int job_id, String title, String company, String location, double salary) {
	super();
	this.job_id = job_id;
	this.title = title;
	this.company = company;
	this.location = location;
	this.salary = salary;
}

public int getJob_id() {
	return job_id;
}

public void setJob_id(int job_id) {
	this.job_id = job_id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public double getSalary() {
	return salary;
}

public void setSalary(double salary) {
	this.salary = salary;
}
	

}
