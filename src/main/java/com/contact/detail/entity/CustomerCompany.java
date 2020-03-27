package com.contact.detail.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("C")
public class CustomerCompany extends Customer{

	@OneToOne(cascade = CascadeType.ALL)
	private Company company;
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
}
