package bookingsystem.client.network;

import bookingsystem.shared.networking.ClientCallback;
import bookingsystem.shared.networking.RMIServer;
import bookingsystem.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements  Client, ClientCallback
{
  private RMIServer server;
  private PropertyChangeSupport support;

  public RMIClient()
  {
     support = new PropertyChangeSupport(this);
  }

  @Override public void startClient()
  {
    try
    {
      UnicastRemoteObject.exportObject(this,0);
      Registry registry= LocateRegistry.getRegistry("localhost",1099);
      server =(RMIServer)registry.lookup("ChatServer");
      server.registerClient(this);
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }

  }

  @Override public String netClientToServer(String str,String userId)
  {
    try {
      return server.loginToServer(str,userId);
    } catch (RemoteException e) {
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public Boolean loginToDB(String url, String user, String password,
      String database)
  {
    Boolean ret =false;
    try
    {
      ret = server.loginToDatabase( url,  user,  password, database);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return ret;
  }

  @Override public List<LogEntry> getLog()
  {
    try
    {
      return server.getLog();
    } catch (RemoteException e) {
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public void setUserId(String str)
  {
    try
    {
      server.setUserId(str);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void update(LogEntry log)
  {
     support.firePropertyChange("NewLogEntry",null,log);
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
     support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
     support.removePropertyChangeListener(eventName, listener);
  }
}
