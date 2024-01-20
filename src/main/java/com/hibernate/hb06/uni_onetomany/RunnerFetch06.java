package com.hibernate.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        /* Student06 student = session.get(Student06.class, 1001);
        System.out.println(student);*/

        String hql = "FROM Book b WHERE b.id = 101";
        Book book = (Book) session.createQuery(hql).getSingleResult();
        System.out.println(book);

        System.out.println("*******************************");
        String hql2 = "SELECT s.books FROM Student06 s WHERE s.id = 1001";
        System.out.println(session.createQuery(hql2).getResultList());

        List<Book> list = session.get(Student06.class, 1001).getBooks();
        list.forEach(System.out::println);
        transaction.commit();

        session.close();
        sessionFactory.close();


    }
}
