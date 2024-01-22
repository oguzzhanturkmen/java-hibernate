package com.hibernate.hb07.bi_directional_onetomany;

import com.hibernate.hb06.uni_onetomany.Book;
import com.hibernate.hb06.uni_onetomany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {
    public static void main(String[] args) {

        Student07 student = new Student07();
        student.setId(1001);
        student.setName("John");
        student.setGrade(50);

        Student07 student2 = new Student07();
        student2.setId(1002);
        student2.setName("Jane");
        student2.setGrade(80);

        Student07 student3 = new Student07();
        student3.setId(1003);
        student3.setName("Jack");
        student3.setGrade(90);

        Book07 book1 = new Book07();
        book1.setId(101);
        book1.setName("Java");


        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        transaction.commit();

        session.close();
        sessionFactory.close();


    }
}
