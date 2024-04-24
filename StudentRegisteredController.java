package com.example.studentmanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class StudentRegisteredController {
    @FXML
    public TextField firstName, lastName, email, age, course;

    public StudentRegisteredController() throws SQLException, ClassNotFoundException{
    }

    @FXML
    protected void onSubmit() throws SQLException, ClassNotFoundException, IOException {
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

        FXMLLoader tableView = new FXMLLoader(this.getClass().getResource("studentTable.fxml"));
        Stage stage = (Stage) this.firstName.getScene().getWindow();
        stage.setScene(new Scene(tableView.load()));
        stage.show();
//        stage.close();
    }
}nmn