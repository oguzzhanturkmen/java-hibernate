package com.hibernate.hb03.uni_onetoone;

import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {

        Student03 student1 = new Student03();
        student1.setId(1);
        student1.setName("Name 1");
        student1.setGrade(100);

        Student03 student2 = new Student03();
        student2.setId(2);
        student2.setName("Name 2");
        student2.setGrade(100);

        Diary diary1 = new Diary();
        diary1.setName("Diary 1");
        diary1.setStudent(student1);
        diary1.setId(1);

        Diary diary2 = new Diary();
        diary2.setName("Diary 2");
        diary2.setStudent(student2);
        diary2.setId(2);


        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);

        org.hibernate.SessionFactory sessionFactory = cfg.buildSessionFactory();

        org.hibernate.Session session = sessionFactory.openSession();

        org.hibernate.Transaction transaction = session.beginTransaction();

        session.save(student1);

        session.save(student2);

        session.save(diary1);

        session.save(diary2);

        transaction.commit();

        session.close();

        sessionFactory.close();



    }
}
