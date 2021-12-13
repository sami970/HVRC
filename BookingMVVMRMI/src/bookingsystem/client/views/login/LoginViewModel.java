package bookingsystem.client.views.login;

import bookingsystem.client.model.BookingClientArea;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
    private StringProperty request, error,replyChat,userId,loginButton,SubmitButton,ChatListButton;

    private BookingClientArea bookingClientArea;

    public LoginViewModel(BookingClientArea bookingClientArea) {
        this.bookingClientArea = bookingClientArea;
        request = new SimpleStringProperty();
        error = new SimpleStringProperty();
        replyChat = new SimpleStringProperty();
        userId=new SimpleStringProperty();
        loginButton=new SimpleStringProperty();
        SubmitButton=new SimpleStringProperty();
        ChatListButton=new SimpleStringProperty();

    }

    void loginToserver()
    {
        String login = userId.getValue();
        bookingClientArea.setServerUserId(login);
        loginButton.set("Connected");

    }
    Boolean  LoginToDatabase(String url)
    {
        Boolean ret = bookingClientArea.loginToDB(url,"","","");
        return ret;
    }
    void submitToserver() {

        String input = request.get();
        String userIdInput=userId.getValue();

        String textResult = bookingClientArea.toServer(input,userIdInput);
    }

    StringProperty requestProperty() {
        return request;
    }

    StringProperty errorProperty() {
        return error;
    }



    StringProperty replyUserIdProperty()
    {
        return userId;
    }

    StringProperty connectedProperty() {return loginButton;}

    StringProperty SubmitProperty() {return SubmitButton;}

    StringProperty ChatListProperty() {return ChatListButton;}

}
