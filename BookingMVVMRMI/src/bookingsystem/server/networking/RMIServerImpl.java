package bookingsystem.server.networking;

import bookingsystem.server.model.ServerBookingManager;
import bookingsystem.shared.networking.ClientCallback;
import bookingsystem.shared.networking.RMIServer;
import bookingsystem.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIServerImpl implements RMIServer
{
  private final ServerBookingManager serverBookingManager;
  public RMIServerImpl(ServerBookingManager serverBookingManager) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this,0);
    this.serverBookingManager = serverBookingManager;
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry= LocateRegistry.createRegistry(1099);
    registry.bind("ChatServer",this);
  }

  @Override public String loginToServer(String str, String userId)
      throws RemoteException
  {
    return serverBookingManager.serverData(str,userId);
  }

  @Override public Boolean loginToDatabase(String url, String user, String password, String database) throws RemoteException
  {
    return serverBookingManager.serverLoginToDb( url,  user,  password,  database);
  }

  @Override public List<LogEntry> getLog()
  {
    return serverBookingManager.getLog();
  }

  @Override public void setUserId(String userId)
  {
    serverBookingManager.setUserId(userId);
  }

  @Override public String getUserId()
  {
    return serverBookingManager.getUserId();
  }

  @Override public void registerClient(ClientCallback client)

  {
    PropertyChangeListener listener = null;
    PropertyChangeListener finalListener=listener;

    listener=evt ->
    {
      try
      {
        client.update((LogEntry)evt.getNewValue());
      }
      catch (RemoteException e)
      {
         serverBookingManager.removeListener("NewLogEntry",finalListener);
      }
    };
     serverBookingManager.addListener("NewLogEntry",listener);
  }


}
