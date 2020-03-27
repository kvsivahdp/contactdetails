package com.contact.detail.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long id;

	@ApiModelProperty(required = true, notes = "Company Name")
	@NotNull
	@Column(nullable = false)
	private String companyName;

	@ApiModelProperty(required = true, notes = "Registration Number")
	@NotNull
	@Column(nullable = false)
	private String regNum;

	@OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
	private CustomerCompany customercompany;
	
	@OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
	private SupplierCompany suppliercompany;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}		
}
