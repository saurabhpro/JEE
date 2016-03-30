package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Created by Saurabh on 3/27/2016.
 */
public class RemoteServer {
    public static void main(String[] args) {
        /*SecurityManager secManager = System.getSecurityManager();
        if (secManager == null) {
            System.setSecurityManager(new SecurityManager());
        }*/

        try {
            RemoteUtilityImpl remoteUtility = new RemoteUtilityImpl();

        /*     // Export the object as a remote object
            int port = 0; // an anonymous port
            server.IRemoteUtility remoteUtilityStub = (server.IRemoteUtility) UnicastRemoteObject.exportObject(remoteUtility, port);

            // Locate the registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Bind the exported remote reference in the registry
            String name = "MyRemoteUtility";
            registry.rebind(name, remoteUtility);
*/
            Naming.rebind("MyRemoteUtility", remoteUtility);
            System.out.println("Remote server is ready...");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
