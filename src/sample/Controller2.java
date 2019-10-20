package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller2 {
    public MenuItem mnuswitch;


    public void switchWindow(ActionEvent actionEvent) throws IOException {
        MenuItem m = (MenuItem) actionEvent.getSource();
        while (m.getParentPopup() == null) {
            m = m.getParentMenu();
        }

        Scene s = m.getParentPopup().getOwnerWindow().getScene();
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("main_window.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) s.getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
}
