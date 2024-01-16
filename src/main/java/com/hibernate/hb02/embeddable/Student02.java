package com.hibernate.hb02.embeddable;

import javax.persistence.*;

@Entity
@Table(name="t_student02")
public class Student02 {

    @Id
    private int id;

    @Column(name="student_name", length = 100, nullable = false, unique = false)
    private String name;

    private int grade;

    /*
    @Embedded is used to mark the variable that is embedded in another class
    In this case, the Address class is embedded in the Student02 class
    The Address class is marked with @Embeddable
    ** You don't have to use @Embedded, but it is recommended to use it
     */
    @Embedded
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address=" + address +
                '}';
    }
}
