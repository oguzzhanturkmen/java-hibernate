package com.hibernate.hb06.uni_onetomany;

import com.hibernate.hb05.manytoone.Student05;
import com.hibernate.hb05.manytoone.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {

    public static void main(String[] args) {

        Student06 student = new Student06();
        student.setId(1001);
        student.setName("John");
        student.setGrade(50);

        Student06 student2 = new Student06();
        student2.setId(1002);
        student2.setName("Jane");
        student2.setGrade(80);

        Student06 student3 = new Student06();
        student3.setId(1003);
        student3.setName("Jack");
        student3.setGrade(90);

        Book book1 = new Book();
        book1.setId(101);
        book1.setName("Java");

        Book book2 = new Book();
        book2.setId(102);
        book2.setName("Python");

        Book book3 = new Book();
        book3.setId(103);
        book3.setName("C++");


        student.getBooks().add(book1);
        student.getBooks().add(book2);
        student2.getBooks().add(book3);

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);

        session.save(student);
        session.save(student2);
        session.save(student3);


        session.save(student);
        session.save(student2);
        session.save(student3);

        transaction.commit();

        session.close();
        sessionFactory.close();





    }
}
