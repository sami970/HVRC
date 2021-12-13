package bookingsystem.server;

import bookingsystem.server.model.ServerBookingManagerImpl;
import bookingsystem.server.networking.RMIServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args)
        throws RemoteException, AlreadyBoundException
    {

        RMIServerImpl ss = new RMIServerImpl(new ServerBookingManagerImpl());
        ss.startServer();
    }
}
