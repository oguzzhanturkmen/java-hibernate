package com.hibernate.hb12.entity_life_cycle;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="employee_id")
    private int id;
    @Column(name="employee_name")
    private String name;
    @Column(name="employee_salary")
    private Double salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    @PrePersist
    // @PrePersist annotation is used to specify callback methods for the corresponding entity.
    // The method annotated with @PrePersist will be called before persisting the entity.
    public void onPrePersist() {
        System.out.println("onPrePersist");
    }

    @PostPersist
    // @PostPersist annotation is used to specify callback methods for the corresponding entity.
    // The method annotated with @PostPersist will be called after persisting the entity.
    public void onPostPersist() {
        System.out.println("onPostPersist");
    }
    @PostLoad
    // @PostLoad annotation is used to specify callback methods for the corresponding entity.
    // The method annotated with @PostLoad will be called after loading the entity.
    public void onPostLoad() {
        System.out.println("onPostLoad");
    }
    @PreRemove
    // @PreRemove annotation is used to specify callback methods for the corresponding entity.
    // The method annotated with @PreRemove will be called before removing the entity.
    public void onPreRemove() {
        System.out.println("onPreRemove");
    }
    @PostRemove
    // @PostRemove annotation is used to specify callback methods for the corresponding entity.
    // The method annotated with @PostRemove will be called after removing the entity.
    public void onPostRemove() {
        System.out.println("onPostRemove");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
