package com.hibernate.hb04.bi_directional_onetoone;

import com.hibernate.hb03.uni_onetoone.Diary;
import com.hibernate.hb03.uni_onetoone.Student03;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {

    public static void main(String[] args) {

        Student04 student1 = new Student04();
        student1.setId(1);
        student1.setName("Name 1");
        student1.setGrade(100);

        Student04 student2 = new Student04();
        student2.setId(2);
        student2.setName("Name 2");
        student2.setGrade(100);

        Student04 student3 = new Student04();
        student3.setId(3);
        student3.setName("Name 3");
        student3.setGrade(100);


        Diary04 diary1 = new Diary04();
        diary1.setName("Diary 1");
        diary1.setStudent(student1);
        diary1.setId(1);
        diary1.setStudent(student1);

        Diary04 diary2 = new Diary04();
        diary2.setName("Diary 2");
        diary2.setStudent(student2);
        diary2.setId(2);
        diary2.setStudent(student2);

           Diary04 diary3 = new Diary04();
        diary3.setName("Diary 3");
        diary3.setId(3);





        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        org.hibernate.SessionFactory sessionFactory = cfg.buildSessionFactory();

        org.hibernate.Session session = sessionFactory.openSession();

        org.hibernate.Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(diary1);
        session.save(diary2);
        session.save(diary3);




        transaction.commit();

        session.close();

        sessionFactory.close();

    }




}
