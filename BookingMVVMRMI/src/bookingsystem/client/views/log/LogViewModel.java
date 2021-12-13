package bookingsystem.client.views.log;

import bookingsystem.client.model.BookingClientArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import bookingsystem.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class LogViewModel {

    private ObservableList<LogEntry> logs;

    private BookingClientArea bookingClientArea;

    public LogViewModel(BookingClientArea textConverter) {
        this.bookingClientArea = textConverter;
        textConverter.addListener("NewLogEntry", this::onNewLogEntry);
    }

    private void onNewLogEntry(PropertyChangeEvent evt) {
        logs.add((LogEntry)evt.getNewValue());
    }

    void loadLogs() {
        List<LogEntry> logList = bookingClientArea.getLogs();
        logs = FXCollections.observableArrayList(logList);
    }

    ObservableList<LogEntry> getLogs() {
        return logs;
    }
}
