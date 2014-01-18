import java.rmi.*;

// Interface announces it extends java.rmi.Remote (which is allowed)
public interface MyRemote extends Remote {
    // RemoteException may happen with rmi
    // Return type must be serializable or primitve
    // If your own class will be passed, make it serializable too.
    public String sayHello() throws RemoteException;
}
