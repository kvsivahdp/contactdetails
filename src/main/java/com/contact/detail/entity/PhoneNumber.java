/**
 * 
 */
package com.contact.detail.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 *
 */
@Embeddable
public class PhoneNumber {

	@ApiModelProperty(required = true, notes = "Area code (required)")
	@NotNull
	@Column(nullable = false)
	private String areaCode;

	@ApiModelProperty(required = true, notes = "Phone number (required)")
	@NotNull
	@Column(nullable = false)
	private String number;

	/**
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	

}
