package bookingsystem.server.model;

import bookingsystem.server.networking.DBConnector;
import bookingsystem.shared.networking.DBConnectorInterface;
import bookingsystem.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServerBookingManagerImpl implements ServerBookingManager

{

    private PropertyChangeSupport support;
    private List<LogEntry> logEntries;
    private String userId;
    private Connection conn;

    public ServerBookingManagerImpl() {
        support = new PropertyChangeSupport(this);
        logEntries = new ArrayList<>();
    }

    @Override
    public String serverData(String str,String userId) {
        String result = str;
        LogEntry logEntry = new LogEntry(result,userId);
        logEntries.add(logEntry);
        support.firePropertyChange("NewLogEntry", null, logEntry);
        return result;
    }

    @Override public Boolean serverLoginToDb(String url, String user,
        String password, String database)
    {
        Boolean result = false;
        DBConnectorInterface dbConnect = new DBConnector();

        conn = dbConnect.connect( url,  user,  password,  database);

        if (conn != null){
            result = true;
        }
        return result;
    }

    @Override
    public List<LogEntry> getLog() {
        return new ArrayList<>(logEntries);
    }

    @Override public void setUserId(String userId)
    {
        this.userId =userId;
    }

    @Override public String getUserId()
    {
        return this.userId;
    }



    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }


}
