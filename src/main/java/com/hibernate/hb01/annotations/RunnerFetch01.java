package com.hibernate.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch01 {
    public static void main(String[] args) {


        Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        //There are 3 ways to get the data from the database
        //1. Using the get method
        //2. Using the SQL
        //3. Using the HQL (Hibernate Query Language)


        //1. Using the get method
        //The get method is used to get the data from the database
        //The get method returns the object
        //In this case, the object is the Student01 object
        //The get method takes two parameters
        //The first parameter is the entity class
        //The second parameter is the primary key
        //In this case, the primary key is the id variable
        Student01 student01 = session.get(Student01.class, 1);
        System.out.println(student01);


        //2. Using the SQL
        //The createSQLQuery method is used to create a SQL query
        //The createSQLQuery method takes one parameter
        //The parameter is the SQL query
        //In this case, the SQL query is "select * from t_student01"
        //The createSQLQuery method returns a SQLQuery object
        //The SQLQuery object is used to execute the SQL query
        //The SQLQuery object has a list method
        //The list method is used to get the data from the database
        //The list method returns a list
        //In this case, the list is a list of Student01 objects
        String sql = "select * from t_student01";
        List<Object[]> resultList1 = session.createSQLQuery(sql).getResultList();

        System.out.println("Running the SQL query");
        resultList1.forEach(result -> {
            System.out.println(Arrays.toString(result));
        });


        transaction.commit();

        session.close();

        sessionFactory.close();

    }
}
