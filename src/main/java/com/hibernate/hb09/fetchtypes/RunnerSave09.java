package com.hibernate.hb09.fetchtypes;

import com.hibernate.hb08.manytomany.Book08;
import com.hibernate.hb08.manytomany.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave09 {

    public static void main(String[] args) {

        Student09 student = new Student09();
        student.setId(1);
        student.setName("John");
        student.setGrade(50);

        Student09 student2 = new Student09();
        student2.setId(2);
        student2.setName("Jane");
        student2.setGrade(80);

        Student09 student3 = new Student09();
        student3.setId(3);
        student3.setName("Jack");
        student3.setGrade(90);



        Book09 book1 = new Book09();
        book1.setId(101);
        book1.setName("Java");

        Book09 book2 = new Book09();
        book2.setId(102);
        book2.setName("Python");

        Book09 book3 = new Book09();
        book3.setId(103);
        book3.setName("C++");

        Book09 book4 = new Book09();
        book4.setId(104);
        book4.setName("C#");

        Book09 book5 = new Book09();
        book5.setId(105);
        book5.setName("Ruby");


       book1.setStudent(student);
         book2.setStudent(student);
            book3.setStudent(student2);
                book4.setStudent(student3);
                    book5.setStudent(student3);
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(student);
        session.save(student2);
        session.save(student3);


        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);

        transaction.commit();

        session.close();
        sessionFactory.close();


    }

}
