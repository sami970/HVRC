package bookingsystem.client.core;

import bookingsystem.client.views.log.LogViewModel;
import bookingsystem.client.views.login.LoginViewModel;

public class ViewModelFactory {

    private final ModelFactory mf;
    private LoginViewModel loginViewModel;
    private LogViewModel logViewModel;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
    }

    public LoginViewModel getLoginViewModel() {
        if (loginViewModel == null)
            loginViewModel = new LoginViewModel(mf.getBookingClientArea());
        return loginViewModel;
    }

    public LogViewModel getLogViewModel() {
        return (logViewModel = logViewModel == null ?
                new LogViewModel(mf.getBookingClientArea()) :
                logViewModel);
    }
}
