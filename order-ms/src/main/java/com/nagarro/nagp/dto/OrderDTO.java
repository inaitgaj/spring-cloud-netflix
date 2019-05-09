package com.nagarro.nagp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {
	private Map<String, Long> productQuantities;
	private String address;
	private String user;

	public Map<String, Long> getProductQuantities() {
		return productQuantities;
	}

	public void setProductQuantities(Map<String, Long> productQuantities) {
		this.productQuantities = productQuantities;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public OrderDTO(Map<String, Long> productQuantities, String address, String user) {
		this.productQuantities = productQuantities;
		this.address = address;
		this.user = user;
	}

	@Override public String toString() {
		return "OrderDTO{" + "productQuantities=" + productQuantities + ", address='" + address + '\'' + ", user='" + user + '\'' + '}';
	}
}
