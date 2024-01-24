package com.hibernate.hb12.entity_life_cycle;

import com.hibernate.hb11.caching.Student11;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave12 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("John");
        employee.setSalary(1000.0);

        Employee employee2 = new Employee();
        employee2.setName("Jane");
        employee2.setSalary(2000.0);

        Employee employee3 = new Employee();
        employee3.setName("Jack");
        employee3.setSalary(3000.0);


        Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(employee);
        session.save(employee2);


        transaction.commit();

        session.close();

        sessionFactory.close();
    }
}
