package com.hibernate.hb03.uni_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary {

    @Id
    private int id;

    private String name;


    /*
    @OneToOne is used to mark the variable that is related to another class
    In this case, the Student03 class is related to the Diary class
    The Student03 class is marked with @Entity

    @JoinColumn is used to mark the variable that is the foreign key
    In this case, the std_id variable is the foreign key

     */
    @OneToOne
    @JoinColumn(name="std_id")
    private Student03 student;
}
