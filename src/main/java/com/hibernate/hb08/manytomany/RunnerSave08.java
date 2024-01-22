package com.hibernate.hb08.manytomany;

import com.hibernate.hb06.uni_onetomany.Book;
import com.hibernate.hb06.uni_onetomany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave08 {
    public static void main(String[] args) {

        Student08 student = new Student08();
        student.setId(1001);
        student.setName("John");
        student.setGrade(50);

        Student08 student2 = new Student08();
        student2.setId(1002);
        student2.setName("Jane");
        student2.setGrade(80);

        Student08 student3 = new Student08();
        student3.setId(1003);
        student3.setName("Jack");
        student3.setGrade(90);

        Book08 book1 = new Book08();
        book1.setId(101);
        book1.setName("Java");

        Book08 book2 = new Book08();
        book2.setId(102);
        book2.setName("Python");

        List<Book08> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);

        student.setBooks(list);

        List<Book08> list2 = new ArrayList<>();
        list2.add(book1);

        student2.setBooks(list2);

        List<Book08> list3 = new ArrayList<>();
        list3.add(book2);

        student3.setBooks(list3);



        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(book1);
        session.save(book2);

        session.save(student);
        session.save(student2);
        session.save(student3);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
