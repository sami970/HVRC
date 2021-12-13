package bookingsystem.client.views.login;

import bookingsystem.client.core.ViewHandler;
import bookingsystem.client.core.ViewModelFactory;
import bookingsystem.client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LoginViewController implements ViewController {
    @FXML
    private Label errorLabel;
    @FXML
    private TextField requestField;
    @FXML
    private TextField connectedText;
    @FXML
    private TextField userId;
    @FXML
    private Button loginButton;
    @FXML
    private Button SubmitButton;
    @FXML
    private Button LoginListButton;


    private LoginViewModel viewModel;
    private ViewHandler vh;

    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        this.viewModel = vmf.getLoginViewModel();
        errorLabel.textProperty().bind(viewModel.errorProperty());
        requestField.textProperty().bindBidirectional(viewModel.requestProperty());
       // replyTextArea.textProperty().bind(viewModel.replyChatProperty());
        userId.textProperty().bindBidirectional(viewModel.replyUserIdProperty());
        loginButton.textProperty().bindBidirectional(viewModel.connectedProperty());
        loginButton.textProperty().setValue("Login");
        requestField.setEditable(false);
        LoginListButton.setDisable(true);
        SubmitButton.setDisable(true);
    }

    @FXML
    private void onSubmitButton() {
        viewModel.submitToserver();
        requestField.setText("");
    }
    @FXML
    private void onLoginButton()
    {
        viewModel.loginToserver();
        userId.setDisable(true);
        loginButton.setDisable(true);
        requestField.setEditable(true);
        LoginListButton.setDisable(false);
        SubmitButton.setDisable(false);
    }

    @FXML
    private void onLoginToDBButton()
    {
        Boolean ret = viewModel.LoginToDatabase("jdbc:sqlite:test.db");
        if (ret)
        {
            connectedText.setText("Connected to Database");
        } else
        {
            connectedText.setText("Connection error to Database");
        }
    }
    public void onLoginListButton() {
        vh.openLog();
    }


}

