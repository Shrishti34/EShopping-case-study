package eshopping.userservice.entity;


import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection ="customer")

public class User {
	
	@Id
	private String id;
	private String FName;
	private String MName;
	private String LName;
	private int CustomerNo;
	@Field(value = "CustmEmail")
	private String CustmEmail;
	private String Street;
	private String City;
	private String State;
	private int Pincode;
	private int CustomDOB;
	private int Password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getMName() {
		return MName;
	}
	public void setMName(String mName) {
		MName = mName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public int getCustomerNo() {
		return CustomerNo;
	}
	public void setCustomerNo(int customerNo) {
		CustomerNo = customerNo;
	}
	public String getCustmEmail() {
		return CustmEmail;
	}
	public void setCustmEmail(String custmEmail) {
		CustmEmail = custmEmail;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getPincode() {
		return Pincode;
	}
	public void setPincode(int pincode) {
		Pincode = pincode;
	}
	public int getCustomDOB() {
		return CustomDOB;
	}
	public void setCustomDOB(int customDOB) {
		CustomDOB = customDOB;
	}
	public int getPassword() {
		return Password;
	}
	public void setPassword(int password) {
		Password = password;
	}
	

}
