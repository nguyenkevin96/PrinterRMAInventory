package com.printer.controller;

import com.printer.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

@Controller
public class AddPrinterController implements Initializable {

    public ArrayList<PrinterType> printerNames;

    @FXML
    private TextField RMA_TEXT, CUSTOMER_TEXT, CLOSED_TEXT, FAULTY_TEXT, REPLACEMENT_TEXT;
    @FXML
    private ComboBox<String> CLOSED_BOX, BULK_BOX, ISSUE_BOX, RESULT_BOX, APPROVED_BOX, PRINTER_BOX;
    @FXML
    private DatePicker ISSUE_DATE, RETURN_DATE;
    @FXML
    private TextArea NOTES_TEXTA, DIAGNOSIS_TEXTA;
    @FXML
    private Button saveButton, testButton;

    @Autowired
    private NeuraLabelRMARepository neuraLabelRMARepository;
    @Autowired
    private PrinterTypeRepository printerTypeRepository;
    @Autowired
    private StageRepository stageRepository;

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
                        "Marks, Error Code",
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
    }

    @FXML
    private void addPrinter(){
        Date date = Date.valueOf(ISSUE_DATE.getValue());
        Date returned = Date.valueOf(RETURN_DATE.getValue());
        Neuralabel neuralabel = new Neuralabel();
        neuralabel.setRmaId(Integer.parseInt(RMA_TEXT.getText()));
        neuralabel.setCompanyName(CUSTOMER_TEXT.getText());
        neuralabel.setClosed(CLOSED_BOX.getSelectionModel().getSelectedItem());
        neuralabel.setIssuedDate(date);
        neuralabel.setFaultySn(FAULTY_TEXT.getText());
        neuralabel.setReplacementSn(REPLACEMENT_TEXT.getText());
        neuralabel.setReturnedDate(returned);
        neuralabel.setNotes(NOTES_TEXTA.getText());
        neuralabel.setDiagnosis(DIAGNOSIS_TEXTA.getText());
        neuralabel.setBulkink(BULK_BOX.getSelectionModel().getSelectedItem().equals("Yes"));
        neuralabel.setIssueCategory(ISSUE_BOX.getSelectionModel().getSelectedItem());
        neuralabel.setResult(RESULT_BOX.getSelectionModel().getSelectedItem());
        neuralabel.setApproved(APPROVED_BOX.getSelectionModel().getSelectedItem().equals("Yes"));
        System.out.println(neuralabel);
    }

    public void testing(){
        System.out.println(stageRepository.findAllByStageId(2).getStageName());
    }
}
