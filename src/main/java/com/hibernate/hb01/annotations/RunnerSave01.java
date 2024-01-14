package com.hibernate.hb01.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {
    public static void main(String[] args) {

        Student01 student01 = new Student01();
        student01.setId(1);
        student01.setName("John");
        student01.setGrade(100);

        // Creating a Configuration object and loading the configuration file
        // If you don't specify the configuration file name, hibernate will use the default configuration file name "hibernate.cfg.xml"
        // If you don't specify the configuration file path, hibernate will use the default configuration file path "src/main/resources"
        //addAnnotatedClass(Student01.class) is used to add the entity class
        //If you have multiple entity classes, you can add multiple addAnnotatedClass
        //This way hibernate knows which entity class to use
        //A question may arise here, why do we need to add the entity class?
        //Because we need to tell hibernate which entity class to use, so that hibernate can create a table for us
        //If you don't add the entity class, hibernate will not know which entity class to use, so it will not create a table for us
        //We are telling hibernate that, in this main method we are using Student01 entity class
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student01.class);

        // Creating a SessionFactory object
        //A SessionFactory object is used to create a Session object
        // A SessionFactory object is used to create a Session object
        // A Session object is used to perform CRUD operations
        // You can think of it like creating different users for the same computer
        // Different users can use the same computer to perform different operations
        // Different Session objects can be used to perform different operations
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Creating a Session object
        // A Session object is used to perform CRUD operations
        Session session = sessionFactory.openSession();

        // Starting the transaction
        // A transaction is a logical unit of work
        // For example, if you want to transfer money from one account to another, you need to perform two operations
        // 1. Subtract the money from the first account
        // 2. Add the money to the second account
        // These two operations must be performed together, if one operation fails, the other operation must also fail
        // In this case, we need to use a transaction
        // If you don't use a transaction, the first operation may succeed, but the second operation may fail
        // In this case, the money will be deducted from the first account, but the money will not be added to the second account
        // This is not what we want, so we need to use a transaction
        // If you use a transaction, the first operation will fail, and the second operation will also fail
        // In this case, the money will not be deducted from the first account, and the money will not be added to the second account
        Transaction transaction = session.beginTransaction();

        // Saving the Student01 object to the database
        // The save method is used to save the object to the database
        // The save method returns the primary key of the object
        // In this case, the primary key is the id variable
        // If the save method is successful, the transaction will be committed
        // If the save method fails, the transaction will be rolled back
        // In this case, the transaction will be committed
        //If we didn't use hibernate and use JDBC for this action we would have to write SQL --> INSERT INTO student01 (id, name, grade) VALUES (1, 'John', 100);
        session.save(student01);

        // Committing the transaction
        // If the save method is successful, the transaction will be committed
        // If the save method fails, the transaction will be rolled back
        //commit method is used to commit the transaction
        //If you don't commit the transaction, it might not be saved to the database
        transaction.commit();

        // Closing the session object
        // You need to close the session object after you are done using it
        // If you don't close the session object, the program will keep running
        session.close();

        // Closing the sessionFactory object
        // You need to close the sessionFactory object after you are done using it
        // If you don't close the sessionFactory object, the program will keep running
        sessionFactory.close();

    }
}
