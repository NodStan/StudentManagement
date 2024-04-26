package com.example.studentmanagement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    Connection connection;
    public void studentDao (StudentModel model) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Stanleyobi123!");
    }

    public void saveStudent(StudentModel student) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into niit-students(firstname,lastname,email,course,age)values(?,?,?,?,?)");

        statement.setString(1, student.getFirstName());
        statement.setString(1, student.getLastName());
        statement.setString(1, student.getEmail());
        statement.setString(2, student.getCourse());
        statement.setInt(3, student.getAge());
        statement.execute();
    }

    public List<StudentModel> getAllStudent() throws SQLException{
        PreparedStatement statement = connection.prepareStatement("select * from niit_students;");
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        ArrayList<StudentModel> studentsList = new ArrayList<>();
        while (resultSet.next()){
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String email = resultSet.getString("email");
            String course = resultSet.getString("course");
            int age = resultSet.getInt("age");
        }
        return studentsList;
    }
}