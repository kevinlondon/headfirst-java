import java.rmi.*;

// Interface announces it extends java.rmi.Remote
public interface MyRemote extends Remote {
    // RemoteException may happen with rmi
    // Return type must be serializable or primitve
    public String sayHello() throws RemoteException;
}
