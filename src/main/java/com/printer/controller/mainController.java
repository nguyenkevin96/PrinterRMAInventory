package com.printer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class mainController implements Initializable {

    @FXML
    private TableColumn RMA_COLUMN, CUSTOMER_COLUMN, CLOSED_COLUMN, ISSUED_COLUMN, FAULTY_COLUMN, REPLACEMENT_COLUMN,
            RETURNED_COLUMN, NOTES_COLUMN, DIAGNOSIS_COLUMN, BULK_COLUMN, ISSUE_COLUMN, RESULT_COLUMN, APPROVED_COLUMN;

    public TableView RMALABEL_PRINTER;

    @FXML
    private Button addButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    private void loadData(){

    }

    @FXML
    private void addPrinter(ActionEvent event) throws IOException {
        Stage parent = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Pane pane = FXMLLoader.load(getClass().getResource("/fxml/AddPrinter.fxml"));
        Scene scene = new Scene(pane);
        parent.setScene(scene);
    }
}
