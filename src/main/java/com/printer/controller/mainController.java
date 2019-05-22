package com.printer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class mainController implements Initializable {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @FXML
    private TableColumn RMA_COLUMN, CUSTOMER_COLUMN, CLOSED_COLUMN, ISSUED_COLUMN, FAULTY_COLUMN, REPLACEMENT_COLUMN,
            RETURNED_COLUMN, NOTES_COLUMN, DIAGNOSIS_COLUMN, BULK_COLUMN, ISSUE_COLUMN, RESULT_COLUMN, APPROVED_COLUMN;

    public TableView RMALABEL_PRINTER;

    @FXML
    private Button addButton;

//    @Autowired
//    private StageRepository stageRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    private void loadData(){

    }

    @FXML
    private void addPrinter(ActionEvent event) throws IOException {
        Stage parent = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/AddPrinter.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        parent.setScene(scene);
    }
}
