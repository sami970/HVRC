package bookingsystem.client.views.log;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import bookingsystem.client.core.ViewHandler;
import bookingsystem.client.core.ViewModelFactory;
import bookingsystem.shared.transferobjects.LogEntry;
import bookingsystem.client.views.ViewController;

public class LogViewController implements ViewController {


    @FXML
    private TableView<LogEntry> tableView;
    public TableColumn<String, LogEntry> inputColumn;
    public TableColumn<String,LogEntry> userIdColumn;

    private LogViewModel vm;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getLogViewModel();
        vm.loadLogs();
        tableView.setItems(vm.getLogs());
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        inputColumn.setCellValueFactory(new PropertyValueFactory<>("input"));
    }

    public void onBackButton() {
        vh.openLoginSystem();
    }
}
