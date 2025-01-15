package com.example.main;

import com.example.entities.Product;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainDeleteProduct {
    public static void main(String[] args) {
        Long productIdToDelete = 1L; // example ID to delete

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Product product = session.get(Product.class, productIdToDelete);
            if (product != null) {
                session.delete(product);
                System.out.println("Deleted Product with ID = " + productIdToDelete);
            } else {
                System.out.println("Product with ID = " + productIdToDelete + " not found.");
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
