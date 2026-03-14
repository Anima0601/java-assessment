package com.abes.dao;

import java.util.List;

import com.abes.entity.Customer;
import com.abes.entity.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class OrderDaoImpl implements OrderDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("assessment");

	@Override
	public boolean addOrder(Order orders, int customerId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Customer customer = em.find(Customer.class, customerId);
		orders.setCustomer(customer);
		em.merge(orders);
		tx.commit();
		em.close();
		return true;
	}

	@Override
	public Order getOrder(int orderId) {
		EntityManager em = emf.createEntityManager();
		Order order = em.find(Order.class, orderId);
		em.close();
		return order;
	}

	@Override
	public List<Order> getOrders(String customerName) {
		EntityManager em=emf.createEntityManager();
		String jpql="from Order o inner join fetch o.customer c where c.customerName= ?1";
		TypedQuery<Order> cq=em.createQuery(jpql,Order.class);
		cq.setParameter(1, customerName);
		List<Order> lst=cq.getResultList();
		em.close();
		return lst;
	}
	
	
}
