package com.contact.detail.entity;

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
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long id;

	@ApiModelProperty(required = true, notes = "Tax number")
	@NotNull
	@Column(nullable = false)
	private String taxNum;

	@ApiModelProperty(required = true, notes = "Order lead time in days")
	@NotNull
	@Column(nullable = false)
	private Integer orderLeadTime;

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
