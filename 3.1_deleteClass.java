package com.example.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entities.Customer;
import com.example.util.HibernateUtil;

public class MainDelete {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Long customerId = 1L;

            Customer customer = session.get(Customer.class, customerId);
            if (customer != null) {
                session.delete(customer);
                System.out.println("Deleted Customer with id=" + customerId
                                   + " and its associated Professor.");
            } else {
                System.out.println("Customer with id=" + customerId + " not found.");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}
