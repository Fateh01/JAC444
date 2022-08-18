import java.rmi.*;

public class RegisterCars extends java.rmi.server.UnicastRemoteObject implements Register {
    public RegisterCars() throws RemoteException {
        super();
    }

    @Override
    public String register(Car theCar) throws RemoteException {
        return String.valueOf(theCar.hashCode());
    }
}