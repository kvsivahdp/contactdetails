package com.contact.detail.dto;

import java.sql.Date;

import com.contact.detail.entity.Company;
import com.contact.detail.entity.Person;
import com.contact.detail.entity.PhoneNumber;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomerDTO {
	
	@JsonIgnore
	private long id;
	private String custNum;
	private Date lastOrderDate;
	private Company company;
	private Person person;
	private PhoneNumber phoneNumber;
	
	
	/**
	 * 
	 */
	public CustomerDTO() {
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the custNum
	 */
	public String getCustNum() {
		return custNum;
	}


	/**
	 * @param custNum the custNum to set
	 */
	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}


	/**
	 * @return the lastOrderDate
	 */
	public Date getLastOrderDate() {
		return lastOrderDate;
	}


	/**
	 * @param lastOrderDate the lastOrderDate to set
	 */
	public void setLastOrderDate(Date lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}


	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}


	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}


	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}


	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}


	/**
	 * @return the phoneNumber
	 */
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}


	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
		
	
}
