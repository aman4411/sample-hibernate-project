package com.OneToOneMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@Column(name="address_id")
	private int addressId;
	private String street;
	private String city;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String street, String city) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + "]";
	}
	
	
}
