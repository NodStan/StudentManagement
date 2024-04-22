package com.example.studentmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class StudentRegisteredController {
    @FXML
    public TextField firstName, lastName, email, age, course;

    public StudentRegisteredController() throws SQLException, ClassNotFoundException{
    }

    @FXML
    protected void onSubmit() throws  SQLException, ClassNotFoundException{
        String firstName = this.firstName.getText();
        String lastName = this.lastName.getText();
        String email = this.email.getText();
        String course = this.course.getText();
        int age = Integer.parseInt(this.age.getText());

        StudentModel studentModel = new StudentModel(firstName, lastName, email, course, age);
        StudentDao db = new StudentDao();
        db.saveStudent(studentModel);
        this.firstName.setText("");
        this.lastName.setText("");
        this.email.setText("");
        this.course.setText("");
        this.age.setText("");

        Stage stage = (Stage) this.firstName.getScene().getWindow();
        stage.close();
    }
}
