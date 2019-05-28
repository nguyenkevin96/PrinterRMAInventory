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

    public ArrayList<Printertype> printerNames;

    public ArrayList<Stage> stageList;

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
        Printer neuralabel = new Printer(Integer.parseInt(RMA_TEXT.getText()), CUSTOMER_TEXT.getText(), CLOSED_BOX.getSelectionModel().getSelectedItem(), date,
                FAULTY_TEXT.getText(), REPLACEMENT_TEXT.getText(), returned, NOTES_TEXTA.getText(), DIAGNOSIS_TEXTA.getText(), BULK_BOX.getSelectionModel().getSelectedItem().equals("Yes"),
                ISSUE_BOX.getSelectionModel().getSelectedItem(), RESULT_BOX.getSelectionModel().getSelectedItem(), APPROVED_BOX.getSelectionModel().getSelectedItem().equals("Yes"),
                PRINTER_BOX.getSelectionModel().getSelectedItem(), STAGE_BOX.getSelectionModel().getSelectedItem());
        neuraLabelRMARepository.saveAndFlush(neuralabel);
        previousWindow(event);
    }

    private void previousWindow(ActionEvent event) throws IOException {
        javafx.stage.Stage parent = (javafx.stage.Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        parent.close();
    }
}
