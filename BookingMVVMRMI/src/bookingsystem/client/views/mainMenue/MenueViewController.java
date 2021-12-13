package bookingsystem.client.views.mainMenue;

import bookingsystem.client.core.ViewHandler;
import bookingsystem.client.core.ViewModelFactory;
import bookingsystem.client.views.ViewController;
import bookingsystem.client.views.log.LogViewModel;
import javafx.event.ActionEvent;

public class MenueViewController implements ViewController
{
  private LogViewModel vm;
  private ViewHandler vh;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
  }

  public void onLogin(ActionEvent actionEvent)
  {
  }
}
