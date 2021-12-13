package bookingsystem.server.networking;

import bookingsystem.shared.networking.DBConnectorInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector implements DBConnectorInterface
{
  private final static DBConnector instance = new DBConnector();

  private Connection conn = null;

  @Override public Connection getConnection()
  {
    return conn;
  }

  @Override public Connection connect(String url, String user, String password,   String database)
  {
    Connection ret = null;
    if (conn !=null)
    {
      ret = this.conn;
    }
    try {
      // db parameters
      Class.forName("org.sqlite.JDBC");

      // create a connection to the database
      conn = DriverManager.getConnection(url);
      ret = conn;
      System.out.println("Connection to SQLite has been established.");

    } catch (SQLException | ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return ret;
  }


}
