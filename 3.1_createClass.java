package com.example.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entities.Customer;
import com.example.entities.Professor;
import com.example.util.HibernateUtil;

public class MainCreate {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Customer customer = new Customer("Alice Smith", "123 Main Street");

            Professor professor = new Professor("Office 101", "Computer Science");

            customer.setProfessor(professor);
            professor.setCustomer(customer);

            session.save(customer);

            transaction.commit();
            System.out.println("Customer and associated Professor created successfully.");
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
