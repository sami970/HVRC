package bookingsystem.client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import bookingsystem.client.views.ViewController;

import java.io.IOException;

public class ViewHandler {

    //Screens
    private Scene loginScene;
    private Stage stage;
    private Scene logScene;

    private ViewModelFactory vmf;

    public ViewHandler(ViewModelFactory vmf) {
        this.vmf = vmf;
    }

    public void start() {
        stage = new Stage();
        openLoginSystem();
    }

    public void openLoginSystem() {
        if (loginScene == null) {
            try {
                Parent root = loadFXML("../views/login/LoginView.fxml");
                loginScene = new Scene(root);
                stage.setTitle("Booking System");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(loginScene);
        stage.show();

    }

    public void openLog() {
        // no reusing a logScene, because I want the log to reload the latest every time.
        if (logScene == null) {
            try {
                Parent root = loadFXML("../views/log/Log.fxml");

                logScene = new Scene(root);
                //stage.setTitle("Log..");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        stage.setScene(logScene);
        stage.show();
    }

    private Parent loadFXML(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        ViewController ctrl = loader.getController();
        ctrl.init(this, vmf);
        return root;
    }
}
