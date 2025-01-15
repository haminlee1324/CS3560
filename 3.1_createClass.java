package com.example.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entities.Customer;
import com.example.entities.Professor;
import com.example.util.HibernateUtil;

public class MainCreate {
    public static void main(String[] args) {

        // 1. Open a Hibernate Session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // 2. Create a new Customer
            Customer customer = new Customer("Alice Smith", "123 Main Street");

            // 3. Create a new Professor
            Professor professor = new Professor("Office 101", "Computer Science");

            // 4. Set bidirectional references
            //    If you’re using the mappedBy in Customer, set the relationship both ways
            customer.setProfessor(professor);
            professor.setCustomer(customer);

            // 5. Persist (save) the Customer (Professor will also be saved by cascade)
            session.save(customer);

            // 6. Commit transaction
            transaction.commit();
            System.out.println("Customer and associated Professor created successfully.");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // 7. Close session
            session.close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}
