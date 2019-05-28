package com.printer.controller;

import com.printer.classes.Printer;
import com.printer.repositories.NeuraLabelRMARepository;
import com.printer.repositories.PrinterTypeRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class MainController implements Initializable {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    public TableColumn<Printer, String>
            REPLACEMENTLABEL_RMA_COLUMN,
            REPLACEMENTLABEL_CUSTOMER_COLUMN,
            REPLACEMENTLABEL_CLOSED_COLUMN,
            REPLACEMENTLABEL_ISSUED_COLUMN,
            REPLACEMENTLABEL_FAULTY_COLUMN,
            REPLACEMENTLABEL_REPLACEMENT_COLUMN,
            REPLACEMENTLABEL_RETURNED_COLUMN,
            REPLACEMENTLABEL_NOTES_COLUMN,
            REPLACEMENTLABEL_DIAGNOSIS_COLUMN,
            REPLACEMENTLABEL_BULK_COLUMN,
            REPLACEMENTLABEL_ISSUE_COLUMN,
            REPLACEMENTLABEL_RESULT_COLUMN,
            REPLACEMENTLABEL_APPROVED_COLUMN,
            RMALABEL_RMA_COLUMN,
            RMALABEL_CUSTOMER_COLUMN,
            RMALABEL_CLOSED_COLUMN,
            RMALABEL_ISSUED_COLUMN,
            RMALABEL_FAULTY_COLUMN,
            RMALABEL_REPLACEMENT_COLUMN,
            RMALABEL_RETURNED_COLUMN,
            RMALABEL_NOTES_COLUMN,
            RMALABEL_DIAGNOSIS_COLUMN,
            RMALABEL_BULK_COLUMN,
            RMALABEL_ISSUE_COLUMN,
            RMALABEL_RESULT_COLUMN,
            RMALABEL_APPROVED_COLUMN,
            REPLACEMENTLOG_RMA_COLUMN,
            REPLACEMENTLOG_CUSTOMER_COLUMN,
            REPLACEMENTLOG_CLOSED_COLUMN,
            REPLACEMENTLOG_ISSUED_COLUMN,
            REPLACEMENTLOG_FAULTY_COLUMN,
            REPLACEMENTLOG_REPLACEMENT_COLUMN,
            REPLACEMENTLOG_RETURNED_COLUMN,
            REPLACEMENTLOG_NOTES_COLUMN,
            REPLACEMENTLOG_DIAGNOSIS_COLUMN,
            REPLACEMENTLOG_BULK_COLUMN,
            REPLACEMENTLOG_ISSUE_COLUMN,
            REPLACEMENTLOG_RESULT_COLUMN,
            REPLACEMENTLOG_APPROVED_COLUMN,
            RMALOG_RMA_COLUMN,
            RMALOG_CUSTOMER_COLUMN,
            RMALOG_CLOSED_COLUMN,
            RMALOG_ISSUED_COLUMN,
            RMALOG_FAULTY_COLUMN,
            RMALOG_REPLACEMENT_COLUMN,
            RMALOG_RETURNED_COLUMN,
            RMALOG_NOTES_COLUMN,
            RMALOG_DIAGNOSIS_COLUMN,
            RMALOG_BULK_COLUMN,
            RMALOG_ISSUE_COLUMN,
            RMALOG_RESULT_COLUMN,
            RMALOG_APPROVED_COLUMN;

    public TableView<Printer> RMALABEL_PRINTER, REPLACEMENTLABEL_PRINTER, REPLACEMENTLOG_PRINTER, RMALOG_PRINTER;

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
        wrappableCells();
        System.out.println("Called Main Controller");
    }

    //Sets the notes and diagnosis column into a wrappable text cell
    private void wrappableCells(){
        REPLACEMENTLABEL_NOTES_COLUMN.setCellFactory(tc -> {
            notesCell = new TableCell<>();
            text = new Text();
            notesCell.setGraphic(text);
            notesCell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(REPLACEMENTLABEL_NOTES_COLUMN.widthProperty());
            text.textProperty().bind(notesCell.itemProperty());
            return notesCell;
        });

        REPLACEMENTLABEL_DIAGNOSIS_COLUMN.setCellFactory(tc -> {
            diagnosisCell = new TableCell<>();
            text = new Text();
            diagnosisCell.setGraphic(text);
            diagnosisCell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(REPLACEMENTLABEL_DIAGNOSIS_COLUMN.widthProperty());
            text.textProperty().bind(diagnosisCell.itemProperty());
            return diagnosisCell ;
        });

        RMALABEL_NOTES_COLUMN.setCellFactory(tc -> {
            notesCell = new TableCell<>();
            text = new Text();
            notesCell.setGraphic(text);
            notesCell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(RMALABEL_NOTES_COLUMN.widthProperty());
            text.textProperty().bind(notesCell.itemProperty());
            return notesCell;
        });

        RMALABEL_DIAGNOSIS_COLUMN.setCellFactory(tc -> {
            diagnosisCell = new TableCell<>();
            text = new Text();
            diagnosisCell.setGraphic(text);
            diagnosisCell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(RMALABEL_DIAGNOSIS_COLUMN.widthProperty());
            text.textProperty().bind(diagnosisCell.itemProperty());
            return diagnosisCell ;
        });

        REPLACEMENTLOG_NOTES_COLUMN.setCellFactory(tc -> {
            notesCell = new TableCell<>();
            text = new Text();
            notesCell.setGraphic(text);
            notesCell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(REPLACEMENTLOG_NOTES_COLUMN.widthProperty());
            text.textProperty().bind(notesCell.itemProperty());
            return notesCell;
        });

        REPLACEMENTLOG_DIAGNOSIS_COLUMN.setCellFactory(tc -> {
            diagnosisCell = new TableCell<>();
            text = new Text();
            diagnosisCell.setGraphic(text);
            diagnosisCell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(REPLACEMENTLOG_DIAGNOSIS_COLUMN.widthProperty());
            text.textProperty().bind(diagnosisCell.itemProperty());
            return diagnosisCell ;
        });

        RMALOG_NOTES_COLUMN.setCellFactory(tc -> {
            notesCell = new TableCell<>();
            text = new Text();
            notesCell.setGraphic(text);
            notesCell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(RMALOG_NOTES_COLUMN.widthProperty());
            text.textProperty().bind(notesCell.itemProperty());
            return notesCell;
        });

        RMALOG_DIAGNOSIS_COLUMN.setCellFactory(tc -> {
            diagnosisCell = new TableCell<>();
            text = new Text();
            diagnosisCell.setGraphic(text);
            diagnosisCell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(RMALOG_DIAGNOSIS_COLUMN.widthProperty());
            text.textProperty().bind(diagnosisCell.itemProperty());
            return diagnosisCell ;
        });
    }

    private void loadCellData(){
        REPLACEMENTLABEL_RMA_COLUMN.setCellValueFactory(new PropertyValueFactory<>("rmaid"));
        REPLACEMENTLABEL_CUSTOMER_COLUMN.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        REPLACEMENTLABEL_CLOSED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("closed"));
        REPLACEMENTLABEL_ISSUED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        REPLACEMENTLABEL_FAULTY_COLUMN.setCellValueFactory(new PropertyValueFactory<>("faultySn"));
        REPLACEMENTLABEL_REPLACEMENT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("replacementSn"));
        REPLACEMENTLABEL_RETURNED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("returnedDate"));
        REPLACEMENTLABEL_NOTES_COLUMN.setCellValueFactory(new PropertyValueFactory<>("notes"));
        REPLACEMENTLABEL_DIAGNOSIS_COLUMN.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        REPLACEMENTLABEL_BULK_COLUMN.setCellValueFactory(new PropertyValueFactory<>("bulkink"));
        REPLACEMENTLABEL_ISSUE_COLUMN.setCellValueFactory(new PropertyValueFactory<>("issueCategory"));
        REPLACEMENTLABEL_RESULT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("result"));
        REPLACEMENTLABEL_APPROVED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("approved"));

        RMALABEL_RMA_COLUMN.setCellValueFactory(new PropertyValueFactory<>("rmaid"));
        RMALABEL_CUSTOMER_COLUMN.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        RMALABEL_CLOSED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("closed"));
        RMALABEL_ISSUED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        RMALABEL_FAULTY_COLUMN.setCellValueFactory(new PropertyValueFactory<>("faultySn"));
        RMALABEL_REPLACEMENT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("replacementSn"));
        RMALABEL_RETURNED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("returnedDate"));
        RMALABEL_NOTES_COLUMN.setCellValueFactory(new PropertyValueFactory<>("notes"));
        RMALABEL_DIAGNOSIS_COLUMN.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        RMALABEL_BULK_COLUMN.setCellValueFactory(new PropertyValueFactory<>("bulkink"));
        RMALABEL_ISSUE_COLUMN.setCellValueFactory(new PropertyValueFactory<>("issueCategory"));
        RMALABEL_RESULT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("result"));
        RMALABEL_APPROVED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("approved"));

        REPLACEMENTLOG_RMA_COLUMN.setCellValueFactory(new PropertyValueFactory<>("rmaid"));
        REPLACEMENTLOG_CUSTOMER_COLUMN.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        REPLACEMENTLOG_CLOSED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("closed"));
        REPLACEMENTLOG_ISSUED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        REPLACEMENTLOG_FAULTY_COLUMN.setCellValueFactory(new PropertyValueFactory<>("faultySn"));
        REPLACEMENTLOG_REPLACEMENT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("replacementSn"));
        REPLACEMENTLOG_RETURNED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("returnedDate"));
        REPLACEMENTLOG_NOTES_COLUMN.setCellValueFactory(new PropertyValueFactory<>("notes"));
        REPLACEMENTLOG_DIAGNOSIS_COLUMN.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        REPLACEMENTLOG_BULK_COLUMN.setCellValueFactory(new PropertyValueFactory<>("bulkink"));
        REPLACEMENTLOG_ISSUE_COLUMN.setCellValueFactory(new PropertyValueFactory<>("issueCategory"));
        REPLACEMENTLOG_RESULT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("result"));
        REPLACEMENTLOG_APPROVED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("approved"));

        RMALOG_RMA_COLUMN.setCellValueFactory(new PropertyValueFactory<>("rmaid"));
        RMALOG_CUSTOMER_COLUMN.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        RMALOG_CLOSED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("closed"));
        RMALOG_ISSUED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        RMALOG_FAULTY_COLUMN.setCellValueFactory(new PropertyValueFactory<>("faultySn"));
        RMALOG_REPLACEMENT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("replacementSn"));
        RMALOG_RETURNED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("returnedDate"));
        RMALOG_NOTES_COLUMN.setCellValueFactory(new PropertyValueFactory<>("notes"));
        RMALOG_DIAGNOSIS_COLUMN.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        RMALOG_BULK_COLUMN.setCellValueFactory(new PropertyValueFactory<>("bulkink"));
        RMALOG_ISSUE_COLUMN.setCellValueFactory(new PropertyValueFactory<>("issueCategory"));
        RMALOG_RESULT_COLUMN.setCellValueFactory(new PropertyValueFactory<>("result"));
        RMALOG_APPROVED_COLUMN.setCellValueFactory(new PropertyValueFactory<>("approved"));
    }

    public void loadData(){
        listOfRmaLabel.clear();
        listOfReplacedLabel.clear();
        listOfRmaLog.clear();
        listOfReplacedLog.clear();

        listOfRmaLabel.addAll(neuraLabelRMARepository.findAllRMANeuraLabel());
        listOfReplacedLabel.addAll(neuraLabelRMARepository.findAllReplacedNeuraLabel());
        listOfRmaLog.addAll(neuraLabelRMARepository.findAllRMANeuraLog());
        listOfReplacedLog.addAll(neuraLabelRMARepository.findAllReplacedNeuraLog());

        RMALABEL_PRINTER.setItems(listOfRmaLabel);
        REPLACEMENTLABEL_PRINTER.setItems(listOfReplacedLabel);
        RMALOG_PRINTER.setItems(listOfRmaLog);
        REPLACEMENTLOG_PRINTER.setItems(listOfReplacedLog);
    }

    @FXML
    private void handleEditPrinter(){
        Printer selectedPrinter = REPLACEMENTLABEL_PRINTER.getSelectionModel().getSelectedItem();
        System.out.println(selectedPrinter);
    }

    @FXML
    private void addPrinter(ActionEvent event) throws IOException {
        //This is the original code for switching to the AddPrinter Form
        Stage parent = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/AddPrinter.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        AddPrinterController controller = fxmlLoader.getController();
        controller.setReturnScene(addButton.getScene());
        parent.setScene(scene);
        parent.showAndWait();
        loadData();
    }
}
