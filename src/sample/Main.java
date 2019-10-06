package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
    Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResourceAsStream("main_window.fxml"));

        primaryStage.setTitle("Demo Java FX"); // title of window
        primaryStage.setScene(new Scene(root, 600, 800));
        primaryStage.setMinHeight(800);
        primaryStage.setMinWidth(600);

        controller = fxmlLoader.getController();

        //without lambda
//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//                                           @Override
//                                           public void handle(WindowEvent event) {
//
//                                           }
//                                       });
        primaryStage.setOnCloseRequest(event -> {
            controller.showClosingDialog();
        });

        primaryStage.show(); // show the actual window
    }


    public static void main(String[] args) {
        launch(args);
    }
}
