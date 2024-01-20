package com.hibernate.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {

    public static void main(String[] args) {
        Student05 student = new Student05();
        student.setId(1001);
        student.setName("John");
        student.setGrade(0);

        Student05 student2 = new Student05();
        student2.setId(1002);
        student2.setName("Jane");
        student2.setGrade(0);

        Student05 student3 = new Student05();
        student3.setId(1003);
        student3.setName("Jack");
        student3.setGrade(0);

        University university = new University();
        university.setId(1);
        university.setName("X University");

        student.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(university);

        session.save(student);
        session.save(student2);
        session.save(student3);

        transaction.commit();
        session.close();
        sessionFactory.close();



    }

}
