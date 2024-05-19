package TestPack;
import DronePack.*;
import DronePack.Mission.MissionType;
import ExceptionPack.InvalidMission;
import LocationPack.Location;

public class DroneTest {
    public static void main(String[] args) {
        
        Drone d1 = new VTOL("Drone_1", 4.5f, 60d, 2f, 20f, 100, new Location(100, 200));
        Mission m1 = new Mission(new Location(100, 150), "Demo Mission", MissionType.SURVEILLANCE);
        Mission m2 = new Mission(new Location(100, 250), "Demo Mission 2", MissionType.SEARCH);


        
        try{
            d1.assignMission(m2);
        }catch(InvalidMission e){
            System.out.println(e);
        }
        try{
            d1.assignMission(m1);
        }catch(InvalidMission e){
            System.out.println(e);
        }

    }
}
