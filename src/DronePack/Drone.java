package DronePack;
import LocationPack.Location;
import ExceptionPack.InvalidMission;

public abstract class Drone implements Runnable{
    String ID;
    float weight;
    double maxSpeed;
    double avgSpeed;

    float payloadCapacity;
    float enduranceTime;
    float maxAltituted;
    float maxRange;
    boolean onMission;
    Location currentLocation;

    PowerSourceType powerSource;
    public enum PowerSourceType{
        BATTERY,SOLAR,OIL;
    }

    public Drone(String iD, float weight, double avgSpeed, float payloadCapacity, float enduranceTime, float maxRange,
            Location location) {
        this.ID = iD;
        this.weight = weight;
        this.avgSpeed = avgSpeed;
        this.payloadCapacity = payloadCapacity;
        this.enduranceTime = enduranceTime;
        this.maxRange = maxRange;
        this.currentLocation = location;
        this.maxSpeed = avgSpeed*1.3;

        //keeping default
        this.powerSource = PowerSourceType.BATTERY;
        this.maxAltituted =100;

    }

    public void assignMission(Mission newMission) throws InvalidMission{

        if(newMission.isCompleted())
            throw new InvalidMission(this, "The Mission Is Already In Progress");

        if(this.onMission) //IF drone is already on a mission
            throw new InvalidMission(Drone.this, " Is Already On A Mission");

        double distance = Location.getDistance(this.currentLocation, newMission.getTargeLocation());
        double timeRequired = distance*2/Drone.this.getavgSpeed();

                                                                                        /// on mission thing will be added later
        if(timeRequired > this.getenduranceTime())//If drone can't go and get back within endurance time
            throw new InvalidMission(Drone.this, "Time Required To Complete The Mission "+timeRequired+" Is More Than The Endurance Time "+this.enduranceTime);

        
        if(distance > this.getmaxRange()) //If Mission Distance is Out Of Range
            throw new InvalidMission(Drone.this, "Target Location "+newMission.getTargeLocation()+" Is Out Of Range");


        newMission.setInitial(this);
        System.out.println("Mission ID:  "+newMission.getMissionID()+" Is Succefully Assigned To The Drone "+this.ID);
        this.onMission=true;
    }

    public String getID() {
        return this.ID;
    }
    public Location getLocation() {
        return this.currentLocation;
    }
    public double getavgSpeed(){
        return this.avgSpeed;
    }
    public PowerSourceType getPowerSource() {
        return this.powerSource;
    }
    public float getenduranceTime(){
        return this.enduranceTime;
    }
    public float getmaxRange(){
        return this.maxRange;
    }
    @Override
    public String toString() {
        return "Drone [ID=" + ID + ", weight=" + weight+"kg, maxSpeed=" + maxSpeed+"km/h, avgSpeed=" + avgSpeed
                +"km/h, payloadCapacity=" + payloadCapacity+"kg, enduranceTime=" + enduranceTime +"hr(s), maxAltituted="
                + maxAltituted +"meter, maxRange=" + maxRange+"km, location=" + currentLocation + ", powerSource=" + powerSource + "]";
    }

    public abstract boolean fly();

    public boolean onMission(){
        return this.onMission;
    }
    
}