
package com.example.stumangement.Service;

import java.util.List;

import com.example.stumangement.Dao.StudentDao;
import com.example.stumangement.entity.Student;

public class StudentService {

    private StudentDao dao = new StudentDao();

    public void registerStudent(Student student){
        dao.saveStudent(student);
    }
    public Student StudentWithCourse(int rollNo){
    return  dao.fetch(rollNo);
    }
    public List<Student> GetallStudents(){
     return dao.getStudents();
    }
    public void deleteStudent(int rollNo){
        dao.deleteStudent(rollNo);
    }
}