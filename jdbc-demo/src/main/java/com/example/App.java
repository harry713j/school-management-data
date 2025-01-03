package com.example;

import com.example.entity.Student;
import com.example.service.StudentService;

import java.time.LocalDate;

public class App
{
    public static void main( String[] args )
    {
        // for this app we are creating database and defining schema manually not programmatically.
        StudentService service = new StudentService();

        Student student1 = new Student(4, "Narendra", "Patil",
                LocalDate.of(1992, 6, 5));

        service.registerStudent(student1);


        System.out.println(service.getAllStudents());

        System.out.println(service.getStudent(3));
    }
}
