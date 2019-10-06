package sample;

import constants.Constants;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller {
    public TextField txtFieldUserName;
    public Label lblUserName;
    public Label lblPassword;
    public PasswordField pwdField;

    public Button btnLogin;
    public MenuItem mnuItemLogin;
    public TabPane tabPane;
    public Tab tabMain;
    public Tab tabLogin;
    public MenuItem mnuItemLogout;
    public BorderPane borderPane;
    public Label lblInfoToAdd;
    public TextField txtFieldWord;
    public TextArea txtAreaCollection;
    public VBox hBoxWithItems;
    public ComboBox cmbBoxItems;
    public Button btnAdd;

    public void initialize() {
//        tabPane.getTabs().clear();

        cmbBoxItems.getItems().add("one");
        cmbBoxItems.getItems().add("two");
        cmbBoxItems.getItems().add("three");
    }

    public void loginUser(ActionEvent actionEvent) {
        if(txtFieldUserName.getText().equals(Constants.USERNAME)) {
            lblUserName.setTextFill(Color.BLACK);
            System.out.println(txtFieldUserName.getText());
        }
        else {
            lblUserName.setTextFill(Color.RED);
        }

        if(pwdField.getText().equals(Constants.PASSWORD)) {
            lblPassword.setTextFill(Color.BLACK);
            System.out.println(pwdField.getText());
        }
        else {
            lblPassword.setTextFill(Color.RED);
        }

        if(lblPassword.getTextFill().equals(Color.BLACK) && lblUserName.getTextFill().equals(Color.BLACK)) {
            tabPane.getTabs().remove(tabLogin);
            tabPane.getTabs().add(tabMain);
        }
    }

    public void openLoginWindow(ActionEvent actionEvent) {
        showClosingDialog();
        tabPane.getTabs().add(tabLogin);
//        for (Node node:borderPane.getChildren()) {
//            if(node instanceof TabPane ) {
//                for (Tab tab: ((TabPane) node).getTabs()
//                     ) {
//                    if(tab.getStyleClass().equals("tabCss")) {
//                        System.out.println(tab.getText());
//                    }
//                }
//            }
//            System.out.println(node);
//        }
    }

    public void logoutUser(ActionEvent actionEvent) {
        tabPane.getTabs().clear();
    }

    public void addToList(KeyEvent keyEvent) {

        if(keyEvent.getCode().equals(KeyCode.ENTER)) {
            txtAreaCollection.appendText(txtFieldWord.getText() + "\n");
            CheckBox checkBox = new CheckBox(txtFieldWord.getText());
            hBoxWithItems.getChildren().add(checkBox);
            txtFieldWord.clear();
        }
    }

    public void passwordFilledIn(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)) {
            loginUser(null);
        }
    }

    public void addComboItemToField(ActionEvent actionEvent) {
        txtAreaCollection.appendText(cmbBoxItems.getSelectionModel().getSelectedItem() + "\n");
        cmbBoxItems.getSelectionModel().select(-1);
    }

    public void showClosingDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Are you sure you want to exit?");
        alert.setHeaderText("Really, really?");
        alert.setContentText("Ok, as you wish");

        ButtonType buttonTypeYes = new ButtonType("YES");
        ButtonType buttonTypeNo = new ButtonType("NO");

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == buttonTypeYes) {
            System.out.println("Exiting!");
        }
        else {
            // do nothing
        }
    }
}
