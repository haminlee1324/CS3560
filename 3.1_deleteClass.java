package com.example.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entities.Customer;
import com.example.util.HibernateUtil;

public class MainDelete {
    public static void main(String[] args) {

        // 1. Open a Hibernate Session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Suppose we want to delete a Customer with id=1
            Long customerId = 1L;

            // 2. Retrieve the customer from the DB
            Customer customer = session.get(Customer.class, customerId);
            if (customer != null) {
                // 3. Delete the customer (cascading will delete the associated Professor as well)
                session.delete(customer);
                System.out.println("Deleted Customer with id=" + customerId
                                   + " and its associated Professor.");
            } else {
                System.out.println("Customer with id=" + customerId + " not found.");
            }

            // 4. Commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // 5. Close session
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}
