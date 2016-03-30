package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Saurabh on 3/27/2016.
 */
public class RemoteClient {
    public static void main(String[] args) {
      /*  SecurityManager secManager = System.getSecurityManager();
        if (secManager == null) {
            System.setSecurityManager(new SecurityManager());
        }
      */
        try {
            String name = "MyRemoteUtility";
            /*
            // Locate the registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IRemoteUtility remoteUtilStub = (IRemoteUtility) registry.lookup(name);
             */

            IRemoteUtility remoteUtilStub = (IRemoteUtility) Naming.lookup("rmi://localhost:1099/" + name);

            // Add two integers
            int n1 = 101;
            int n2 = 207;
            int sum = remoteUtilStub.add(n1, n2);
            System.out.println(n1 + " + " + n2 + " = " + sum);
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
