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
    /*
    @OneToOne: This annotation indicates a one-to-one association between two entities. In this context,
    it's used to declare that the entity where this annotation is placed has a one-to-one relationship with the Student03 entity.
    This means for every instance of the entity that contains this annotation,
    there is exactly one associated instance of Student03.

    @JoinColumn(name="std_id"): This annotation specifies the column that will be used as a foreign key in the database table.
    The name="std_id" indicates that the foreign key column in the database table is named std_id.
    This column std_id will store the primary key of the associated Student03 entity,
    thus establishing the link between the two entities in the database.
     */
    @OneToOne
    @JoinColumn(name="std_id")
    private Student03 student;

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
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
}
