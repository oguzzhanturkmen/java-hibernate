package com.hibernate.hb10.idgeneration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student10 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    // @GeneratedValue(strategy = GenerationType.SEQUENCE )
    // @GeneratedValue(strategy = GenerationType.TABLE )
    // @GeneratedValue(strategy = GenerationType.AUTO )
    // @GeneratedValue annotation is used to specify the generation strategy for the primary key values.
        private int id;
        private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student10{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
