package DronePack;
import LocationPack.Location;

public class VTOL extends Drone{
    double wingSpan;

    public VTOL(String iD, float weight, double avgSpeed, float payloadCapacity, float enduranceTime, float maxRange,
            Location location) {
        super(iD, weight, avgSpeed, payloadCapacity, enduranceTime, maxRange, location);
        this.wingSpan=10d;
    }
    

    public synchronized boolean fly(){
        if(!this.onMission){
            System.out.println("No Mission Assigned");
            return false;
        }

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
                System.out.println(this.ID +" Is Flying");
            } catch (Exception e) {
                System.out.println(this.ID+ " Fall Due To Some Issues");
            }
        }
        this.onMission=false;
        return true; ///validations will be implemented further
    }


    @Override
    public void run() {
        this.fly();
    }
    
    
}
