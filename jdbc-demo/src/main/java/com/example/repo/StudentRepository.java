package com.example.repo;

import com.example.connection.DatabaseConnection;
import com.example.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private final Connection connection;

    public StudentRepository(){
        this.connection = DatabaseConnection.getConnection();

    }

    public void create(Student student){

        String query = "INSERT INTO student(student_id, first_name, last_name, date_of_birth) VALUES(?, ?, ?, ?)";

        try(PreparedStatement statement = this.connection.prepareStatement(query)) {
            statement.setString(1, student.getStudentId().toString());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
            statement.setDate(4, Date.valueOf(student.getDataOfBirth()));

            int row = statement.executeUpdate();
            System.out.println(row + " rows effected!");

        }catch (SQLException e){
            System.err.println("Failed to create student: " + e.getMessage());
        }finally {
            DatabaseConnection.closeConnection();
        }
    }

    public List<Student> findAll(){
        List<Student> students = new ArrayList<>();
       String query = "SELECT * FROM student";

       try(PreparedStatement statement = this.connection.prepareStatement(query)){
           ResultSet resultSet = statement.executeQuery();

           while (resultSet.next()){
               Student student = new Student();

               student.setStudentId(resultSet.getInt("student_id"));
               student.setFirstName(resultSet.getString("first_name"));
               student.setLastName(resultSet.getString("last_name"));
               student.setDataOfBirth(resultSet.getDate("date_of_birth").toLocalDate());

               students.add(student);
           }

       }catch (SQLException e){
           System.err.println("Failed to get the students: " + e.getMessage());
       }finally {
           DatabaseConnection.closeConnection();
       }

       return students;
    }

    public Student findById(int studentId){
        Student student = new Student();

        String query = "SELECT * FROM student WHERE student_id=?";

        try(PreparedStatement statement = this.connection.prepareStatement(query)) {
            statement.setInt(1, studentId);

            ResultSet result = statement.executeQuery();

            if (result.next()){
                student.setStudentId(result.getInt("student_id"));
                student.setFirstName(result.getString("first_name"));
                student.setLastName(result.getString("last_name"));
                student.setDataOfBirth(result.getDate("date_of_birth").toLocalDate());
            }

        }catch (SQLException e){
            System.err.println("Failed to get the student: " + e.getMessage());
        }finally {
            DatabaseConnection.closeConnection();
        }

        return student;
    }
}
