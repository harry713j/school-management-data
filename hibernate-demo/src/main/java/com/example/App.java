package com.example;

import com.example.model.Course;
import com.example.model.Student;
import com.example.model.Subject;
import com.example.model.Teacher;
import com.example.service.CourseService;
import com.example.service.StudentService;
import com.example.service.SubjectService;
import com.example.service.TeacherService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        /*
        * 1. Create SessionFactory
        * 2. Create Session
        * 3. Begin Transaction
        * 4. Start database operation
        * */

        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();
        SubjectService subjectService = new SubjectService();
        CourseService courseService = new CourseService();

        Student s1 = new Student();
        s1.setFirstName("Tobi");
        s1.setLastName("Slack");
        s1.setDateOfBirth(LocalDate.of(2006, 11, 25));
        s1.setPhoneNumber("8433823844");

        Student s2 = new Student();
        s2.setFirstName("Vini");
        s2.setLastName("Jr");
        s2.setDateOfBirth(LocalDate.of(1998, 2, 19));
        s2.setPhoneNumber("7984565463");

        Subject subject = new Subject();
        subject.setSubjectName("Cloud");

        Course course = new Course();
        course.setCourseName("DCC");
        course.setStudents(new ArrayList<>(Arrays.asList(s1, s2)));
        course.setSubject(subject);


//        Teacher teacher = new Teacher();
//        teacher.setFirstName("Nathan");
//        teacher.setLastName("Lyon");
//        teacher.setSubject(subject);

        studentService.registerStudent(s1);
        studentService.registerStudent(s2);

        courseService.registerCourse(course);
//        subjectService.registerSubject(subject);

//        teacherService.registerTeacher(teacher);

    }
}
