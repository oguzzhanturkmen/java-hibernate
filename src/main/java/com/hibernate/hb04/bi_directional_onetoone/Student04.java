package com.hibernate.hb04.bi_directional_onetoone;

import com.hibernate.hb03.uni_onetoone.Diary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student04 {

    @Id
    private int id;

    @Column(name="std_name")
    private String name;

    private int grade;

    /*
    @OneToOne is used to mark the variable that is related to another class
    In this case, the Diary04 class is related to the Student04 class
    It creates a bi-directional relationship between the two classes
    MappedBy is used to mark the variable that is the foreign key
    In this case, the student variable is the foreign key
    It will create a foreign key in the Diary04 table
    It will set the foreign key to the Diary04 table which has the student variable
    If you don't use mappedBy, it will create a foreign key in both tables which is default behavior

     */
    @OneToOne(mappedBy = "student")
    private Diary04 diary;

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", diary=" + diary +
                '}';
    }

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

    public Diary04 getDiary() {
        return diary;
    }

    public void setDiary(Diary04 diary) {
        this.diary = diary;
    }
}
