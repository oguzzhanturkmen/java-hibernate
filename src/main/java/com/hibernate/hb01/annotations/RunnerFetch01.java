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

        String sqlQuery1 = "select * from t_student01 where id = 1";
        Object[] result1 = (Object[]) session.createSQLQuery(sqlQuery1).uniqueResult();
        System.out.println("Running the SQL query 2");
        System.out.println(Arrays.toString(result1));

        String sqlQuery2 = "select * from t_student01 where id = 1";
        Object[] result2 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
        System.out.println("Running the SQL query 3");
        System.out.println(Arrays.toString(result2));



        //3. Using the HQL (Hibernate Query Language)
        //The createQuery method is used to create a HQL query
        //The createQuery method takes one parameter
        //The parameter is the HQL query
        //In this case, the HQL query is "from Student01"
        //The createQuery method returns a Query object
        //The Query object is used to execute the HQL query
        //The Query object has a list method
        //The list method is used to get the data from the database
        //The list method returns a list
        //In this case, the list is a list of Student01 objects
        String hqlQuery1 = "FROM Student01";
        List<Student01> resultList2 = session.createQuery(hqlQuery1 , Student01.class).getResultList();
        System.out.println("Running the HQL query");
        resultList2.forEach(result -> {
            System.out.println(result);
        });


        //The uniqueResult method is used to get the data from the database
        //The uniqueResult method returns an object
        //In this case, the object is the Student01 object
        //The uniqueResult method takes one parameter
        //The parameter is the HQL query
        //In this case, the HQL query is "from Student01 where name = 'John'"
        //If only one object is returned, you can use the uniqueResult method********
        String hqlQuery2 = "FROM Student01 WHERE name = 'John'";
        Student01 result3 = session.createQuery(hqlQuery2, Student01.class).uniqueResult();
        System.out.println("Running the HQL query 2");
        System.out.println(result3);

        //Alias is used to give a name to the entity class
        //In this case, the alias is "s"
        //The alias is used to refer to the entity class
        //In this case, the alias is used to refer to the Student01 entity class
        //The alias is used to refer to the variable

        String hqlQuery3 = "FROM Student01 s WHERE s.name = 'John'";
        Student01 result4 = session.createQuery(hqlQuery3, Student01.class).uniqueResult();
        System.out.println("Running the HQL query 3");
        System.out.println(result4);

        String hqlQuery4 = "SELECT s.id, s.name FROM Student01 s WHERE s.name = 'Oguz'";
        List<Object[]> resultList4 = session.createQuery(hqlQuery4).getResultList();
        System.out.println("Running the HQL query 4");
        resultList4.forEach(result -> {
            System.out.println(Arrays.toString(result));
        });

        String hqlQuery5 = "FROM Student01 s ORDER BY s.id DESC";
        List<Student01> resultList5 = session.createQuery(hqlQuery5, Student01.class).getResultList();
        System.out.println("Running the HQL query 5");
        resultList5.forEach(result -> {
            System.out.println(result);
        });

        transaction.commit();

        session.close();

        sessionFactory.close();

    }
}
