package com.example.stumangement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    private int rollno;
    private String name ;
    @OneToMany
    (mappedBy = "student" , cascade = CascadeType.ALL, fetch = FetchType.LAZY ,orphanRemoval = true)
    private List<Course> courses ;
   
    
   
    public Student() {
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public int getRollno() {
        return rollno;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", name=" + name +  "]";
    }
    public void addCourse(Course course) {
    courses.add(course);
    course.setStudent(this);
}

public void removeCourse(Course course) {
    courses.remove(course);
    course.setStudent(null);
}

   
    

    





}
