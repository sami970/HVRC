package bookingsystem.shared.networking;

import bookingsystem.shared.transferobjects.LogEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote
{
  String loginToServer(String str,String userId) throws RemoteException;
  List<LogEntry> getLog()throws RemoteException;
  void setUserId(String userId)throws RemoteException;
  String getUserId() throws RemoteException;
  void registerClient(ClientCallback client) throws RemoteException;
  Boolean loginToDatabase(String url, String user, String password, String database) throws RemoteException;

}
