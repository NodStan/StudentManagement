package com.example.studentmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentTableController implements Initializable {
    @FXML
    TableView<StudentModel> studentsTable;
    @Override
    public void initialize(URL location, ResourceBundle resources){
        ObservableList<StudentModel> studentsList;
        try {
            StudentDao dao =new StudentDao();
            studentsList = (ObservableList<StudentModel>) dao.getAllStudent();

        } catch (ClassNotFoundException e) {
            throw  new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        TableColumn<StudentModel, String> firstNameColumn = new TableColumn<>();
//        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    }
}