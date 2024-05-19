package DronePack;

import LocationPack.Location;

public class Rotor extends Drone{
    Integer numOfMotors;


    public Rotor(String iD, float weight, double avgSpeed, float payloadCapacity, float enduranceTime,
            float maxRange, Location location,RotorType rotor) {
        super(iD, weight, avgSpeed, payloadCapacity, enduranceTime, maxRange, location);

        this.numOfMotors=rotor.getRotorCount();
    }

    public enum RotorType{
        SINGLE(1),QUAD(4),HEXA(6),OCTA(8),TRIO(3);

        private int count;
        private RotorType(int count){
            this.count=count;
        }
        public int getRotorCount(){
            return this.count;
        }
    }

    public void run(){
        this.fly();
    }

    public synchronized boolean fly(){
        if(!this.onMission){
            System.out.println("No Mission Assigned");
            return false;
        }
        
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(50);
                System.out.println(this.ID +" Is Flying");
            } catch (Exception e) {
                System.out.println(this.ID+ " Fall Due To Some Issues");
            }
        }
        this.onMission=false;
        return true; ///validations will be implemented further
    }
    
}
