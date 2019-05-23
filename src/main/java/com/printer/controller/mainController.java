package com.printer.controller;

import com.printer.classes.Printer;
import com.printer.classes.Printertype;
import com.printer.repositories.NeuraLabelRMARepository;
import com.printer.repositories.PrinterTypeRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
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

    public TableColumn<Printer, String> RMA_COLUMN, CUSTOMER_COLUMN, CLOSED_COLUMN, ISSUED_COLUMN, FAULTY_COLUMN, REPLACEMENT_COLUMN,
            RETURNED_COLUMN, NOTES_COLUMN, DIAGNOSIS_COLUMN, BULK_COLUMN, ISSUE_COLUMN, RESULT_COLUMN, APPROVED_COLUMN;

    public TableView<Printer> RMALABEL_PRINTER;

    private TableCell<Printer, String> notesCell, diagnosisCell;
    private Text text;

    @FXML
    private Button addButton;

    private ObservableList<Printer> listOfRmaLabel, listOfReplacedLabel, listOfRmaLog, listOfReplacedLog, listOfSerialDoors;

    @Autowired
    private NeuraLabelRMARepository neuraLabelRMARepository;

    @Autowired
    private PrinterTypeRepository printerTypeRepository;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listOfRmaLabel = FXCollections.observableArrayList();
        listOfReplacedLabel = FXCollections.observableArrayList();
        listOfRmaLog = FXCollections.observableArrayList();
        listOfReplacedLog = FXCollections.observableArrayList();
        loadCellData();
        loadData();
        wrappableCells();
        System.out.println("Called Main Controller");
    }

    private void wrappableCells(){
        //Sets the notes and diagnosis column into a wrappable text cell
        NOTES_COLUMN.setCellFactory(tc -> {
            notesCell = new TableCell<>();
            text = new Text();
            notesCell.setGraphic(text);
            notesCell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(NOTES_COLUMN.widthProperty());
            text.textProperty().bind(notesCell.itemProperty());
            return notesCell;
        });

        DIAGNOSIS_COLUMN.setCellFactory(tc -> {
            diagnosisCell = new TableCell<>();
            text = new Text();
            diagnosisCell.setGraphic(text);
            diagnosisCell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(DIAGNOSIS_COLUMN.widthProperty());
            text.textProperty().bind(diagnosisCell.itemProperty());
            return diagnosisCell ;
        });
    }

    private void loadCellData(){
        RMA_COLUMN.setCellValueFactory(new PropertyValueFactory<>("rmaId"));
        CUSTOMER_COLUMN.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        CLOSED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("closed"));
        ISSUED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        FAULTY_COLUMN.setCellValueFactory(new PropertyValueFactory<>("faultySn"));
        REPLACEMENT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("replacementSn"));
        RETURNED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("returnedDate"));
        NOTES_COLUMN.setCellValueFactory(new PropertyValueFactory<>("notes"));
        DIAGNOSIS_COLUMN.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        BULK_COLUMN.setCellValueFactory(new PropertyValueFactory<>("bulkink"));
        ISSUE_COLUMN.setCellValueFactory(new PropertyValueFactory<>("issueCategory"));
        RESULT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("result"));
        APPROVED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("approved"));

    }

    private void loadData(){
        listOfRmaLabel.clear();
        listOfReplacedLabel.clear();
        listOfRmaLog.clear();
        listOfReplacedLog.clear();
        listOfRmaLabel.addAll(neuraLabelRMARepository.findAllNeuraLabel());
//        listOfReplacedLabel.addAll(neuraLabelRMARepository.findAllByPrintertypeContains("NeuraLabel"));
//        listOfRmaLog.addAll(neuraLabelRMARepository.findAllByPrintertypeContains("NeuraLog"));
//        listOfReplacedLog.addAll(neuraLabelRMARepository.findAllByPrintertypeContains("Neura"));
        RMALABEL_PRINTER.setItems(listOfRmaLabel);
    }

    public void refresh(){
        listOfRmaLabel.clear();
        listOfRmaLabel.addAll(neuraLabelRMARepository.findAllNeuraLabel());
    }

    @FXML
    private void addPrinter(ActionEvent event) throws IOException {
        Stage parent = new Stage(); /*(Stage) ((Node)event.getSource()).getScene().getWindow();*/
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/AddPrinter.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        AddPrinterController controller = fxmlLoader.getController();
        controller.setReturnScene(addButton.getScene());
        parent.setScene(scene);
        parent.show();
    }
}
