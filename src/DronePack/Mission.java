package DronePack;
import LocationPack.Location;


public class Mission {
    public enum MissionType{
        DELIVERY, RETURN, SEARCH, MAPPING, SURVEILLANCE;
    }
    public enum MissionStatus{
        NOT_ASSIGNED,ASSIGNED,IN_PROGRESS,COMPLETED;
    }
    static int missionCounter;
    public int missionID;
    public String vehicleID;
    private Location initLocation;
    private Location targeLocation;
    private String naration;
    private MissionType misssionType;
    private double timeTaken; //keeping time taken & required same for now;

    private MissionStatus status;

    public Mission(Location targeLocation, String naration, MissionType misssionType) {
        this.missionID= missionCounter;
        this.targeLocation = targeLocation;
        this.naration = naration;
        this.misssionType = misssionType;
        this.status=MissionStatus.NOT_ASSIGNED;
        missionCounter++;
    }
    public MissionType getMisssionType() {
        return misssionType;
    }
    public int getMissionID(){
        return this.missionID;
    }
    public boolean setInitial(Drone drone){
        if(!(this.status==MissionStatus.NOT_ASSIGNED))
            return false;
        this.initLocation=drone.getLocation();
        this.vehicleID=drone.getID();
        this.timeTaken=Location.getDistance(initLocation, targeLocation)*2/drone.getavgSpeed(); //Time Taken = Distance/speed
        this.status=MissionStatus.ASSIGNED;
        return true;  
    }
    public String getVehicleID(){
        return vehicleID;
    }
    public boolean markComplete(){
        if(this.status==MissionStatus.COMPLETED){
            System.out.println("Already Completed");
            return false;
        }
        System.out.println(this.missionID +" is Over");
        this.status = MissionStatus.COMPLETED;
        return true;
    }
    public boolean startMission(){
        if(this.status!=MissionStatus.ASSIGNED){
            System.out.println("Unable To Start Mission");
            return false;
        }
        this.status=MissionStatus.IN_PROGRESS;
        return true;
    }
    public boolean isCompleted(){
        return this.status==MissionStatus.COMPLETED;
    }
    public MissionStatus getStatus(){
        return this.status;
    }
    public Location getTargeLocation() {
        return targeLocation;
    }
    public double getTimeTaken() {
        return timeTaken;
    }
    @Override
    public String toString() {
        return "Mission [missionID=" + missionID + ", vehicleID=" + vehicleID + ", initLocation=" + initLocation
                + ", targeLocation=" + targeLocation + ", naration=" + naration + ", misssionType=" + misssionType
                + ", timeTaken=" + timeTaken + ", status=" + status + "]";
    }
   
}