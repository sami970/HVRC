package bookingsystem.server.model;


import bookingsystem.shared.transferobjects.LogEntry;
import bookingsystem.shared.util.Subject;

import java.util.List;

public interface ServerBookingManager extends Subject {

    String serverData(String str,String userId);
    List<LogEntry> getLog();
    void setUserId(String userId);
    String getUserId();
    Boolean serverLoginToDb(String url, String user, String password, String database);
}
