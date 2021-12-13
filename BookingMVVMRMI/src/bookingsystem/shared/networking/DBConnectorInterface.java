package bookingsystem.shared.networking;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnectorInterface
{
  static DBConnectorInterface getInstance()
  {
    return null;
  }
  public Connection getConnection();
  public Connection connect(String url, String user, String password, String database);

}
