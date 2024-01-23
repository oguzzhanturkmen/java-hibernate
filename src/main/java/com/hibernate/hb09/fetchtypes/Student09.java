package com.hibernate.hb09.fetchtypes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student09 {

    @Id
    private int id;
    @Column(nullable = false, name = "student_name")
    private String name;

    private int grade;

    @OneToMany(mappedBy = "student" , cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book09> books = new ArrayList<>();

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

    public List<Book09> getBooks() {
        return books;
    }

    public void setBooks(List<Book09> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Student09{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", books=" + books +
                '}';
    }
}
