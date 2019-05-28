package com.printer;

import com.printer.controller.MainController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application {

    private ConfigurableApplicationContext springContext;
    private Parent root;
    private int count = 0;

    private MainController mainController;
    private FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(Main.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml/main.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        root = fxmlLoader.load();
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        incrementCount();
                        mainController = fxmlLoader.getController();
                        mainController.loadData();
                    }
                };

                while(true){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException ex){
                    }
                    Platform.runLater(runnable);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
*/
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void runTask(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                updateTable();
            }
        };

        Thread background = new Thread();
        background.setDaemon(true);
        background.start();
    }

    public void updateTable(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                mainController = fxmlLoader.getController();
                mainController.loadData();
            }
        });
    }

    private void incrementCount(){
        count++;
        System.out.println("Count number: " + count);
    }
}
