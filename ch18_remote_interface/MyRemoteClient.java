// includes Naming class (for peforming the rmiregistry lookup)
import java.rmi.*;

public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    public void go() {
        try {
            // Must cast, returns as type Object
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/Remote Hello");
            // Looks like a regular method (aside from acknowledging RemoteException)
            String s = service.sayHello();

            System.out.println(s);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
