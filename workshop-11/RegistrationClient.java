import java.rmi.*;
import java.util.*;

public class RegistrationClient {
    public static final String GREEN = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota Corolla", "Dawn M", 1000));
        cars.add(new Car("Honda Civic", "Edward H", 2000));
        cars.add(new Car("Volvo S70", "Raymond B", 3000));
        Register client;
        for (Car car : cars) {
            try {
                client = (Register) Naming.lookup("rmi://localhost:8080/RegistrationServer");
                System.out.println(GREEN + "##### Registering Now #####\n" + RESET + car);
                car.register(client.register(car));
                System.out.println(GREEN + "##### Car registered #####\n" + RESET + car + "\n");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println(GREEN + "##### All cars registered #####" + RESET);
    }
}