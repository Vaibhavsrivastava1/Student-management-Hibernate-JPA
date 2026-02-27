package com.example.stumangement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int courseId ; 
     private String courseName ; 
     private int duration ;
     @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + "]";
    }
     public int getCourse_id() {
        return courseId;
    }
     public void setCourse_id(int courseId) {
         this.courseId = courseId;
     }
     public String getCourse_name() {
         return courseName;
     }
     public void setCourse_name(String course_name) {
         this.courseName = course_name;
     }
     public int getDuration() {
         return duration;
     }
     public void setDuration(int duration) {
         this.duration = duration;
     }
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "student_rollno" , nullable =false)
      private Student student ;
     public Course() {
    }
     public Student getStudent() {
         return student;
     }
     public void setStudent(Student student) {
         this.student = student;
     }




}
