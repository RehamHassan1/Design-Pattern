import java.util.ArrayList;
import java.util.List;

interface AirTrafficControl {
    void sendMessage(String message, Airplane sender);
    void registerAirplane(Airplane airplane);
}
// Control Tower
class ControlTower implements AirTrafficControl {
    private List<Airplane> airplanes = new ArrayList<>();

    @Override
    public void registerAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }
    @Override
    public void sendMessage(String message, Airplane sender) {
        for (Airplane airplane : airplanes) {
            if (airplane != sender) {
                airplane.receive(message, sender);
            }
        }
    }
}

// Airplane
class Airplane {
    private String id;
    private AirTrafficControl controlTower;

    public Airplane(String id, AirTrafficControl controlTower) {
        this.id = id;
        this.controlTower = controlTower;
        controlTower.registerAirplane(this); 
    }

    public String getId() {
        return id;
    }

    public void send(String message) {
        System.out.println(id + " sends: " + message);
        controlTower.sendMessage(message, this);
    }

    public void receive(String message, Airplane sender) {
        System.out.println(id + " receives from " + sender.getId() + ": " + message);
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();

        Airplane plane1 = new Airplane("Plane-101", tower);
        Airplane plane2 = new Airplane("Plane-202", tower);
        Airplane plane3 = new Airplane("Plane-303", tower);

        plane1.send("Requesting permission to land.");
        plane2.send("Taking off in 2 minutes.");
        plane3.send("Holding at 5000 feet.");
    }
}
