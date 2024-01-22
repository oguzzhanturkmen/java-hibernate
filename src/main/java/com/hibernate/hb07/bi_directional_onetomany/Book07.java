package com.hibernate.hb07.bi_directional_onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book07 {
    @Id
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student07 student07;

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

    public Student07 getStudent07() {
        return student07;
    }

    public void setStudent07(Student07 student07) {
        this.student07 = student07;
    }

    @Override
    public String toString() {
        return "Book07{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
