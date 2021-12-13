package bookingsystem.client;

import javafx.application.Application;
import javafx.stage.Stage;
import bookingsystem.client.core.ClientFactory;
import bookingsystem.client.core.ModelFactory;
import bookingsystem.client.core.ViewHandler;
import bookingsystem.client.core.ViewModelFactory;

public class ClientApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory cf = new ClientFactory();
        ModelFactory mf = new ModelFactory(cf);
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(vmf);
        vh.start();
    }
}
