package com.hibernate.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Student05 {

    @Id
    private int id;

    @Column(name="student_name", nullable = false)
    private String name;

    private int grade;

    private LocalDateTime createdOn;

    @ManyToOne
@JoinColumn(name="university_id")
    private University university;

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

 /*   public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }*/

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createdOn=" + createdOn +
                ", university=" + university +
                '}';
    }
}
