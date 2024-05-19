package ExceptionPack;
import DronePack.*;

public class InvalidMission extends Exception{
    Drone currDrone;
    String reason;

    public InvalidMission(Drone currDrone, String reason) {
        this.currDrone = currDrone;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "For "+this.currDrone.getID()+" "+this.reason;
    }
    
}
