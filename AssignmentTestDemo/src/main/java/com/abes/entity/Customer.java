package com.abes.entity;

import java.util.Set;

import jakarta.persistence.*;


@Entity
@Table(name="customer")
public class Customer {
	@Id
	@Column(name="customer_id")
	private Integer customerId;
	@Column(name="customer_name" , nullable=false, length=45) 
	private String customerName;
	@OneToMany(mappedBy="customer")
	private Set<Order> orderSet;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Set<Order> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", orderSet=" + orderSet + "]";
	}

	
}
