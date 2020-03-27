package com.contact.detail.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@DiscriminatorColumn(name = "userType")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long id;

	@ApiModelProperty(required = true, notes = "Customer number")
	@NotNull
	@Column(nullable = false)
	private String custNum;

	@ApiModelProperty(required = true, notes = "Last order date")
	@NotNull
	@Column(nullable = false)
	private Date lastOrderDate;

	@Embedded
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
