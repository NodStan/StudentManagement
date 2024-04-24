package com.example.studentmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentTableController implements Initializable {
    @FXML
    TableView<StudentModel> studentsTable;
    ObservableList<StudentModel> studentsList;
    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            StudentDao dao =new StudentDao();
            studentsList = FXCollections.observableList(dao.getAllStudent());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

// Creation of table columns
        TableColumn<StudentModel, String> firstNameColumn = new TableColumn<>();
        TableColumn<StudentModel, String> lastNameColumn = new TableColumn<>();
        TableColumn<StudentModel, String> emailColumn = new TableColumn<>();
        TableColumn<StudentModel, String> courseColumn = new TableColumn<>();
        TableColumn<StudentModel, Integer> ageColumn = new TableColumn<>();
//        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());

// map our details from the list to the columns
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

// add all the columns to the table
        studentsTable.getColumns().addAll(firstNameColumn, lastNameColumn, emailColumn, courseColumn, ageColumn);
    }
}