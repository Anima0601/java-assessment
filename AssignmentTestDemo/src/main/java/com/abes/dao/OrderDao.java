package com.abes.dao;

import java.util.List;

import com.abes.entity.Order;

public interface OrderDao {
	
	public boolean addOrder(Order orders, int customerId);
	public Order getOrder(int orderId);
	public List<Order> getOrders(String customerName);

}
