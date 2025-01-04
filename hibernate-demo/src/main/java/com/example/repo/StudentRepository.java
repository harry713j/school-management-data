package com.example.repo;

import com.example.connection.DatabaseConnection;
import com.example.model.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentRepository {

    private final Session session;

    public StudentRepository(){
        this.session = DatabaseConnection.getSession();
    }

    public void create(Student student){
        this.session.beginTransaction();
        session.persist(student);
        this.session.getTransaction().commit();
        System.out.println("Student created successfully!");
        this.session.close();
    }

    public List<Student> findAll(){
        this.session.beginTransaction();
        Query<Student> query = this.session.createQuery("FROM Student", Student.class);
        List<Student> students = query.getResultList();
        this.session.close();
        return students;
    }

    public Student findById(int studentId){
        this.session.beginTransaction();

        Query<Student> query = this.session.createQuery("FROM Student WHERE id = :studentId")
                .setParameter("studentId", studentId);

        return query.getSingleResult();
    }
}
