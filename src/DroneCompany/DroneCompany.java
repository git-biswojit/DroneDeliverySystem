package DroneCompany;
import DronePack.*;
// import LocationPack.Location;

import java.util.HashSet;
import java.util.Set;
// import java.io.InvalidObjectException;


public class DroneCompany {
    Double ID;
    String companyName;
    Set<Drone> droneFleet = new HashSet<>();


    public DroneCompany(Double ID, String companyName) { 
        this.ID = ID;
        this.companyName = companyName;
    }
    public void addDrone(Drone drone){
        if(!droneFleet.add(drone))
            System.out.println("Mentioned Drone Already Present In The Fleet");;
    }
    public void removeDrone(Drone drone) {
        if(!droneFleet.remove(drone)) //throws InvalidObjectException
            System.out.println("Mentioned Drone Is Not Present In The Fleet");
    }
}
