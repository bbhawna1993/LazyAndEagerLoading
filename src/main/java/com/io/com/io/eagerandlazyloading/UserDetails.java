package com.io.com.io.eagerandlazyloading;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;


@Entity(name="USER_DETAILS")
public class UserDetails {

	@Id @GeneratedValue
	private int userId;
	private String userName;

	/*when you make the fetch type as eager,all objects of the entities will be loaded at one time only and 
	even after closing the session,if you try to access the object,it doesnt throws any error and you get the complete
	log of elements.*/

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS",joinColumns=@JoinColumn(name="USER_ID"))
	private Collection<Address> userAddress=new ArrayList<Address>();
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Collection<Address> getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Collection<Address> userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
