package com.printer.controller;

import com.printer.classes.Printer;
import com.printer.classes.Printertype;
import com.printer.classes.Stage;
import com.printer.repositories.NeuraLabelRMARepository;
import com.printer.repositories.PrinterTypeRepository;
import com.printer.repositories.StageRepository;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

@Component
public class AddPrinterController implements Initializable {

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    public ArrayList<Printertype> printerNames;

    public ArrayList<Stage> stageList;

    @FXML
    private TextField RMA_TEXT, CUSTOMER_TEXT, FAULTY_TEXT, REPLACEMENT_TEXT;
    @FXML
    private ComboBox<String> CLOSED_BOX, BULK_BOX, ISSUE_BOX, RESULT_BOX, APPROVED_BOX;
    @FXML
    private ComboBox<Printertype> PRINTER_BOX;
    @FXML
    private ComboBox<Stage> STAGE_BOX;
    @FXML
    private DatePicker ISSUE_DATE, RETURN_DATE;
    @FXML
    private TextArea NOTES_TEXTA, DIAGNOSIS_TEXTA;
    @FXML
    private Button saveButton, testButton;

    @FXML
    private TableView<Printer> RMALABEL_PRINTER;

    private Scene returnScene;

    public MainController mainController;

    @Autowired
    private PrinterTypeRepository printerTypeRepository;
    @Autowired
    private StageRepository stageRepository;
    @Autowired
    private NeuraLabelRMARepository neuraLabelRMARepository;

    public AddPrinterController() {
    }

    public void setReturnScene(Scene returnScene) {
        this.returnScene = returnScene;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setComboBoxData();
    }

    private void setComboBoxData(){
        CLOSED_BOX.getItems().addAll(
                "Issued",
                "Closed"
        );

        BULK_BOX.getItems().addAll("Yes", "No");

        ISSUE_BOX.getItems().addAll(
                "Hardware",
                        "Media Jam",
                        "Print Quality",
                        "Marks",
                        "Error Code",
                        "Dead",
                        "Network Board",
                        "Freeze",
                        "Other"
        );

        RESULT_BOX.getItems().addAll(
                "Fixed",
                "Scrap",
                "Disassemble",
                "Keep",
                "Unprocessed"
        );

        APPROVED_BOX.getItems().addAll("Yes", "No");

        printerNames = new ArrayList<>();
        printerTypeRepository.findAll().forEach(e -> printerNames.add(e));
        PRINTER_BOX.setItems(FXCollections.observableArrayList(printerNames));

        stageList = new ArrayList<>();
        stageRepository.findAll().forEach(e -> stageList.add(e));
        STAGE_BOX.setItems(FXCollections.observableArrayList(stageList));
    }

    @FXML
    private void addPrinter(ActionEvent event) throws IOException{
        Date date = Date.valueOf(ISSUE_DATE.getValue());
        Date returned = Date.valueOf(RETURN_DATE.getValue());
        Printer neuralabel = new Printer();
        neuralabel.setRmaId(Integer.parseInt(RMA_TEXT.getText()));
        neuralabel.setCompanyName(CUSTOMER_TEXT.getText());
        neuralabel.setClosed(CLOSED_BOX.getSelectionModel().getSelectedItem());
        neuralabel.setIssueDate(date);
        neuralabel.setFaultySn(FAULTY_TEXT.getText());
        neuralabel.setReplacementSn(REPLACEMENT_TEXT.getText());
        neuralabel.setReturnedDate(returned);
        neuralabel.setNotes(NOTES_TEXTA.getText());
        neuralabel.setDiagnosis(DIAGNOSIS_TEXTA.getText());
        neuralabel.setBulkink(BULK_BOX.getSelectionModel().getSelectedItem().equals("Yes"));
        neuralabel.setIssueCategory(ISSUE_BOX.getSelectionModel().getSelectedItem());
        neuralabel.setResult(RESULT_BOX.getSelectionModel().getSelectedItem());
        neuralabel.setApproved(APPROVED_BOX.getSelectionModel().getSelectedItem().equals("Yes"));
        neuralabel.setPrintertype(PRINTER_BOX.getSelectionModel().getSelectedItem());
        neuralabel.setStageId(STAGE_BOX.getSelectionModel().getSelectedItem());
        neuraLabelRMARepository.saveAndFlush(neuralabel);
        previousWindow(event);
    }

    private void previousWindow(ActionEvent event) throws IOException {
        javafx.stage.Stage parent = (javafx.stage.Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        parent.close();
    }

    public void testing(){
        System.out.println("Printer Types: " + printerTypeRepository.findAll() + "\n==========================\n" +
        stageRepository.findAll());
    }
}
