package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Saurabh on 3/27/2016.
 */
public class RemoteUtilityImpl extends UnicastRemoteObject implements IRemoteUtility {

    protected RemoteUtilityImpl() throws RemoteException {
    }


    @Override
    public int add(int n1, int n2) throws RemoteException {
        return n1 + n2;
    }
}
