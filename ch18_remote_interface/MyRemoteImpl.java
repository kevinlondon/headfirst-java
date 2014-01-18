import java.rmi.*;
// server contains UnicastRemoteObject
import java.rmi.server.*;

// Simplest way to perform some work as a remote service object
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    // Must implement custom method we've specified in interface
    public String sayHello() {
        return "Server says, 'Hey'";
    }

    // UnicastRemoteObject requires we catch RemoteException
    public MyRemoteImpl() throws RemoteException { }

    public static void main (String[] args) {

        try {
            // Make the remote object and bind it to the rmiregistry
            // The name you register it under is the name clients will need
            // to look it up under in the rmi registry
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("Remote Hello", service);
        } catch (Exception ex) }
            ex.printStackTrace();
        }
    }
}
