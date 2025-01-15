package com.example.main;

import com.example.entities.Order;
import com.example.entities.Product;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class MainCreateOrder {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Create some products
            Product p1 = new Product("Laptop");
            Product p2 = new Product("Keyboard");

            // Save products first (no cascade for persist)
            session.save(p1);
            session.save(p2);

            // Create an Order
            Order order = new Order(new Date(), "Alice");
            // Associate the products
            order.getProducts().add(p1);
            order.getProducts().add(p2);

            // Persist the order
            session.save(order);

            transaction.commit();
            System.out.println("Order and Products created successfully!");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}
