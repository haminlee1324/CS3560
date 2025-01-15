package com.example.main;

import com.example.entities.Order;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainDeleteOrder {
    public static void main(String[] args) {
        Long orderIdToDelete = 1L; // example ID to delete

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Retrieve the order
            Order order = session.get(Order.class, orderIdToDelete);
            if (order != null) {
                // Delete the order
                session.delete(order);
                System.out.println("Deleted Order with ID = " + orderIdToDelete);
            } else {
                System.out.println("Order with ID = " + orderIdToDelete + " not found.");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}
