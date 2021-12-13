package bookingsystem.client.model;

import bookingsystem.client.network.Client;
import bookingsystem.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class BookinClientAreaManager implements BookingClientArea
{

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;


    public BookinClientAreaManager(Client client) {
        this.client = client;
        client.startClient();
        client.addListener("NewLogEntry", this::onNewLogEntry);
    }

    private void onNewLogEntry(PropertyChangeEvent evt) {
        support.firePropertyChange(evt);
    }

    @Override
    public String toServer(String text,String userId) {
        return client.netClientToServer(text,userId);
    }

    @Override public Boolean loginToDB(String url, String user, String password,
        String database)
    {
        return client.loginToDB(url,  user,  password,  database);
    }

    @Override
    public List<LogEntry> getLogs() {
        return client.getLog();
    }

    @Override public void setServerUserId(String str)
    {
        client.setUserId(str);
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


