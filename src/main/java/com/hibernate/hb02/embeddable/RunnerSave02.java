package com.hibernate.hb02.embeddable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave02 {
    public static void main(String[] args) {

        Address address = new Address();
        address.setStreet("Street 1");
        address.setCity("City 1");
        address.setCountry("Country 1");
        address.setZipCode("Zip Code 1");

        Address address2 = new Address();
        address2.setStreet("Street 2");
        address2.setCity("City 2");
        address2.setCountry("Country 2");
        address2.setZipCode("Zip Code 2");


        Student02 student02 = new Student02();
        student02.setId(1);
        student02.setName("Name 1");
        student02.setGrade(100);
        student02.setAddress(address);

        Student02 student03 = new Student02();
        student03.setId(2);
        student03.setName("Name 2");
        student03.setGrade(100);
        student03.setAddress(address2);


        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student02.class).addAnnotatedClass(Address.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(student02);
        session.save(student03);


        transaction.commit();

        session.close();

        sessionFactory.close();
    }
}
