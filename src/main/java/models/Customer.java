package models;

import java.util.Date;

public class Customer {
	// Fields
	private long id;
	private String name;
	private String address;
	private String website;
	private Date createdAt;
	private Date updatedAt;
	
	
	// Properties
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	// Constructors
	public Customer () {}
	
	
	// Public Methods
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", website=" + website
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	
	
}