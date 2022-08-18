import java.rmi.registry.*;
import java.rmi.RemoteException;

public class RegistrationServer {
    public static void register() {
        try {
            Register register = new RegisterCars();
            Registry registry = LocateRegistry.createRegistry(8080);
            registry.rebind("RegistrationServer", register);
            System.out.println("Registration Server bound to registry!");
        }catch (RemoteException re){
            System.err.println(re.getMessage());
        }
    }
    public static void main(String[] args){
        register();
        System.out.println("Registering Cars...");
    }
}