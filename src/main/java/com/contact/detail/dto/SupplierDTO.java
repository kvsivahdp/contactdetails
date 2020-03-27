/**
 * 
 */
package com.contact.detail.dto;

import com.contact.detail.entity.Company;
import com.contact.detail.entity.Person;
import com.contact.detail.entity.PhoneNumber;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 */
public class SupplierDTO {

	@JsonIgnore
	private long id;
	private String taxNum;
	private Integer orderLeadTime;
	private Company company;
	private Person person;
	private PhoneNumber phoneNumber;

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
	 * @return the taxNum
	 */
	public String getTaxNum() {
		return taxNum;
	}

	/**
	 * @param taxNum the taxNum to set
	 */
	public void setTaxNum(String taxNum) {
		this.taxNum = taxNum;
	}

	/**
	 * @return the orderLeadTime
	 */
	public Integer getOrderLeadTime() {
		return orderLeadTime;
	}

	/**
	 * @param orderLeadTime the orderLeadTime to set
	 */
	public void setOrderLeadTime(Integer orderLeadTime) {
		this.orderLeadTime = orderLeadTime;
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
