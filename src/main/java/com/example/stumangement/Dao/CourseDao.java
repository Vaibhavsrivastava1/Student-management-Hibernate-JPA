package com.example.stumangement.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.stumangement.HibernateUtil;
import com.example.stumangement.entity.Course;
import com.example.stumangement.entity.Student;

class CourseDao{
     Session session = null;
    Transaction transaction = null;
    public void saveCourse(Course course){

     Session session = null;
     Transaction transaction = null;
     try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.persist(course);
        transaction.commit();

        
     } catch (Exception e) {
        if(transaction!=null){
            transaction.rollback();
        }
        e.printStackTrace();
     }finally{
        if (session!=null) {
            session.close();   
        }
     }

    }
    public Course getCourse(int id){
         Session session = null;
     Transaction transaction = null;
     Course c = null;
     try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        c =  session.get(Course.class, id);
        transaction.commit();

        
     } catch (Exception e) {
        if(transaction!=null){
            transaction.rollback();
        }
        e.printStackTrace();
     }finally{
        if (session!=null) {
            session.close();   
        }
     }
     return c ;


    }
    public List<Course> getCourses(){

     Session session = null;
    Transaction transaction = null;
    List<Course>  courses = new  ArrayList<>();
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Query<Course> q = session.createQuery("from Course",Course.class);
        courses = q.list();
        transaction.commit();
        
    } catch (Exception e) {
        if(transaction!=null){
            transaction.rollback();
        }
        e.printStackTrace();
        
    }finally{
        if(session!=null){
            session.close();
        }
    }

    return courses;
   }
    public void deleteCourse(int id){
     Session session = null;
    Transaction transaction = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
         Course c = session.get(Course.class, id);
         session.delete(c);
         System.out.println("Successful ");
     
        
        transaction.commit();
        
    } catch (Exception e) {
        if(transaction!=null){
            transaction.rollback();
        }
        e.printStackTrace();
        
    }finally{
        if(session!=null){
            session.close();
        }
    }
   }

}