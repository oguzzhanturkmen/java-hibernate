package com.hibernate.hb07.bi_directional_onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student07 {

    @Id
    private int id;
    private String name;

    private int grade;

    @OneToMany(mappedBy = "student07")
    private List<Book07> books = new ArrayList<>();

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

    public List<Book07> getBooks() {
        return books;
    }

    public void setBooks(List<Book07> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Student07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", books=" + books +
                '}';
    }
}
