import java.rmi.*;

public interface Register extends Remote {
    String register(Car theCar) throws RemoteException;
}
