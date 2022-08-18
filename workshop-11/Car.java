import java.io.*;

public class Car implements Serializable {

    private final String model;
    private final String owner;
    private final double mileage;
    private String plates;

    public Car(String model, String owner, double mileage) {
        this.model = model;
        this.owner = owner;
        this.mileage = mileage;
        this.plates = "unregistered";
    }

    public String toString() {
        return String.format("Model:%-15sOwner:%-10sMileage:%7.2f\tRegistration:%-10s", model, owner, mileage, plates);
    }

    public void register(String plate) {
        this.plates = plate;
    }
}
