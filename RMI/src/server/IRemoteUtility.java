package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Saurabh on 3/27/2016.
 */

public interface IRemoteUtility extends Remote {
    // Adds two integers and returns the result to the client
    int add(int n1, int n2) throws RemoteException;
}
