package com.abes.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private Integer orderID;
	
	@Column(name="order_date")
	private LocalDate orderDate;
	
	@Column(name="order_amount",nullable=false)
	private Double orderAmount;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderDate=" + orderDate + ", orderAmount=" + orderAmount + ", customer="
				+ customer + "]";
	}
	
	
	

}
