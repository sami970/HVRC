package bookingsystem.shared.networking;

import bookingsystem.shared.transferobjects.LogEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote
{
   void update(LogEntry log) throws RemoteException;


}
