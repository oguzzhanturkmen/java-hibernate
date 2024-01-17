package com.hibernate.hb04.bi_directional_onetoone;

import com.hibernate.hb03.uni_onetoone.Diary;
import com.hibernate.hb03.uni_onetoone.Student03;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        org.hibernate.SessionFactory sessionFactory = cfg.buildSessionFactory();

        org.hibernate.Session session = sessionFactory.openSession();

        org.hibernate.Transaction transaction = session.beginTransaction();

        // With get method, we can fetch the data from the database.
        Diary04 diary1 = session.get(Diary04.class, 1);
        System.out.println(diary1);

        Diary04 diary2 = session.get(Diary04.class, 2);
        System.out.println(diary2);

        //With HQL, we can fetch the data from the database.
        System.out.println("With HQL");
        System.out.println("Inner Join Fetch");
        String hql = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Diary04 d ON s.id = d.student.id";

        List<Object[]> list = session.createQuery(hql).getResultList();
        list.forEach(arr -> System.out.println(Arrays.toString(arr)));

        System.out.println("Left Join Fetch");
        String hql2= "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Diary04 d ON s.id = d.student.id";

        List<Object[]> list2 = session.createQuery(hql2).getResultList();
        list2.forEach(arr -> System.out.println(Arrays.toString(arr)));

        System.out.println("Right Join Fetch");
        String hql3= "SELECT s.name, d.name FROM Student04 s RIGHT JOIN FETCH Diary04 d ON s.id = d.student.id";

        List<Object[]> list3 = session.createQuery(hql2).getResultList();
        list3.forEach(arr -> System.out.println(Arrays.toString(arr)));

        System.out.println("Full Join Fetch");
        String hql4= "SELECT s.name, d.name FROM Student04 s FULL JOIN FETCH Diary04 d ON s.id = d.student.id";

        List<Object[]> list4 = session.createQuery(hql2).getResultList();
        list4.forEach(arr -> System.out.println(Arrays.toString(arr)));


        transaction.commit();

        session.close();

        sessionFactory.close();
    }
}
