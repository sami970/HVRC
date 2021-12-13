package bookingsystem.shared.transferobjects;

import java.io.Serializable;

public class LogEntry implements Serializable {

    private String input, output,userId;
//Todo to be corrected
    public LogEntry(String input,String userId) {
        this.input = input;

        this.userId=userId;
    }

    public String getInput() {
        return input;
    }

    public String getUserId() { return userId; }
}
