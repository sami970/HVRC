package bookingsystem.client.model;

import bookingsystem.shared.transferobjects.LogEntry;
import bookingsystem.shared.util.Subject;

import java.util.List;

public interface BookingClientArea extends Subject {

    String toServer(String text,String userId);
    Boolean loginToDB(String url, String user, String password, String database);
    List<LogEntry> getLogs();
    void setServerUserId(String str);

}


