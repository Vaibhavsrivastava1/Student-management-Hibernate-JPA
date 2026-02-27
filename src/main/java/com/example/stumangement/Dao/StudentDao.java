package com.example.stumangement.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.stumangement.HibernateUtil;
import com.example.stumangement.entity.Student;

public class StudentDao {

    public void saveStudent(Student student){

         Session session = null;
    Transaction transaction = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        session.persist(student);  
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
    }
    }

   public Student fetch( int rollNo){
       Session session = null;
    Transaction transaction = null;
    Student s = null ;
    try{
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        s = session.get(Student.class, rollNo);
        transaction.commit();
    }catch(Exception e){
        if(transaction!=null){
            transaction.rollback();
        }
        e.printStackTrace();
    }finally{
        if(session!=null){
            session.close();
        }
    }

     return s;

   }
   
   public List<Student> getStudents(){

     Session session = null;
    Transaction transaction = null;
    List<Student>  students = new  ArrayList<>();
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Query<Student> q = session.createQuery("from Student",Student.class);
        students = q.list();
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

    return students;
    


    

   }
   public void deleteStudent(int rollNo){
     Session session = null;
    Transaction transaction = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
         Student s = session.get(Student.class, rollNo);
         session.delete(s);
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
