package com.hibernate.hb01.annotations;

import javax.persistence.*;

@Entity
@Table(name="t_student01") //If you want to use a different table name, you can use this annotation
public class Student01 { //If there is no special naming, hibernate will use the class name as the table name, it will be "student01

    @Id // This annotation is used to mark the primary key
    //@Column(name="student_id") // If you want to use a different column name, you can use this annotation
    private int id;
    //@Column is not necessary, if you don't use it, hibernate will use the variable name as the column name
    //You can use this annotation to change the column name, length, nullable, unique, etc.
    @Column(length = 100 , nullable = false, unique = false)
    private String name;

    /* @Transient This annotation is used to mark the variable that is not stored in the database
    Wyh we need this annotation? Because we need to calculate the grade based on the score, but we don't want to store the grade in the database
    Lets say we have a student with two grades, and we want to calculate the average but don't store it in the database, in this case we can use @Transient
    So it means that for logic we can easily use the average variable but we don't need to store it in the database*/
    //@Transient
    private int grade;

    /* @Lob This annotation is used to mark the variable that is stored in the database as a large object
    For example, we want to store a picture in the database, we can use @Lob to mark the variable that stores the picture
    Large objects are stored in the database in a special way, so we need to mark it with @Lob
    Large objects are for stored in the database as a byte array, so we need to use byte[] to store the picture
     */
    //@Lob
    //private byte[] image;


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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
