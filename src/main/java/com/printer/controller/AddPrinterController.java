package com.printer.controller;

import com.printer.Main;
import com.printer.classes.Printer;
import com.printer.classes.Printertype;
import com.printer.classes.Stage;
import com.printer.repositories.NeuraLabelRMARepository;
import com.printer.repositories.PrinterTypeRepository;
import com.printer.repositories.StageRepository;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

@Component
public class AddPrinterController implements Initializable{

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    private ArrayList<Printertype> printerNames;

    private ArrayList<Stage> stageList;

    public String DATE_ERRORMESSAGE = "Your issue date should be before the return date",
            RMA_ERRORMESSAGE = "Your RMA should be 4 digits",
            RMAFORMAT_ERRORMESSAGE = "Your RMA should be a number";

    @FXML
    private TextField RMA_TEXT, CUSTOMER_TEXT, FAULTY_TEXT, REPLACEMENT_TEXT, ERROR_TEXT;
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
    private Label TYPE1_TEXT, TYPE2_TEXT, TYPE3_TEXT, ERROR_LABEL;

    @FXML
    private TableView<Printer> RMALABEL_PRINTER;

    private Scene returnScene;

    public Main main;
    public FXMLLoader fxmlLoader;

    @Autowired
    private PrinterTypeRepository printerTypeRepository;
    @Autowired
    private StageRepository stageRepository;
    @Autowired
    private NeuraLabelRMARepository neuraLabelRMARepository;

    public void setReturnScene(Scene returnScene) {
        this.returnScene = returnScene;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setComboBoxData();

        PRINTER_BOX.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            TYPE1_TEXT.setText(newValue.getPrinterrmatype());
            TYPE2_TEXT.setText(newValue.getPrintername());
            TYPE3_TEXT.setText(newValue.getPrintervariant());
        });

        ISSUE_BOX.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if("Error Code".equals(newValue)){
                ERROR_LABEL.setVisible(true);
                ERROR_TEXT.setVisible(true);
            } else{
                ERROR_LABEL.setVisible(false);
                ERROR_TEXT.setVisible(false);
            }
        });
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
        try {
            Printer printer = new Printer(Integer.parseInt(RMA_TEXT.getText()), CUSTOMER_TEXT.getText(), CLOSED_BOX.getSelectionModel().getSelectedItem(), date,
                    FAULTY_TEXT.getText(), REPLACEMENT_TEXT.getText(), returned, NOTES_TEXTA.getText(), DIAGNOSIS_TEXTA.getText(), BULK_BOX.getSelectionModel().getSelectedItem().equals("Yes"),
                    ISSUE_BOX.getSelectionModel().getSelectedItem(), RESULT_BOX.getSelectionModel().getSelectedItem(), APPROVED_BOX.getSelectionModel().getSelectedItem().equals("Yes"),
                    PRINTER_BOX.getSelectionModel().getSelectedItem(), STAGE_BOX.getSelectionModel().getSelectedItem());

            if(printerIsValid(printer)){
                neuraLabelRMARepository.save(printer);
                previousWindow(event);
            }
        } catch (NumberFormatException numF){
            alert(RMAFORMAT_ERRORMESSAGE);
        }
    }

    private void previousWindow(ActionEvent event) throws IOException {
        javafx.stage.Stage parent = (javafx.stage.Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        parent.close();
    }

    private boolean printerIsValid(Printer printer){
        boolean isPrinterValid = false;
        if(printer.getRmaid() > 1000 && printer.getRmaid() < 9999) {
            if (printer.getIssueDate().before(printer.getReturnedDate()))
                isPrinterValid = true;
            else {
                alert(DATE_ERRORMESSAGE);
            }
        } else {
            alert(RMA_ERRORMESSAGE);
        }
        return isPrinterValid;
    }

    private void alert(String alertMessage){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Error");
        alert.setContentText(alertMessage);
        alert.showAndWait();
    }

    public void editPrinter(Printer printer){
        RMA_TEXT.setText(String.valueOf(printer.getRmaid()));
        CUSTOMER_TEXT.setText(printer.getCompanyName());
        CLOSED_BOX.setValue(printer.getClosed());
        ISSUE_DATE.setValue(printer.getIssueDate().toLocalDate());
        FAULTY_TEXT.setText(printer.getFaultySn());
        REPLACEMENT_TEXT.setText(printer.getReplacementSn());
        RETURN_DATE.setValue(printer.getReturnedDate().toLocalDate());
        NOTES_TEXTA.setText(printer.getNotes());
        DIAGNOSIS_TEXTA.setText(printer.getDiagnosis());
        BULK_BOX.setValue(printer.getBulkink() ? "Yes" : "No");
        ISSUE_BOX.setValue(printer.getIssueDate().toString());
        RESULT_BOX.setValue(printer.getResult());
        APPROVED_BOX.setValue(printer.getApproved()? "Yes" : "No");
        PRINTER_BOX.setValue(printer.getPrintertid());
        STAGE_BOX.setValue(printer.getPrinter_stageid());
    }
}
