package bookingsystem.client.network;

import bookingsystem.shared.transferobjects.LogEntry;
import bookingsystem.shared.util.Subject;

import java.util.List;

public interface Client extends Subject {

    String netClientToServer(String str,String userId);
    Boolean loginToDB(String url, String user, String password, String database);
    List<LogEntry> getLog();

    void startClient();
    void setUserId(String str);
}
