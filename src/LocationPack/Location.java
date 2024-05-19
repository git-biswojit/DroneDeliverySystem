package LocationPack;
import java.lang.Math;

public class Location {
    double lattitude;
    double longitude;
    public Location(double lattitude, double longitude) {
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public static double getDistance(Location loc1,Location loc2){
        // System.out.println(loc1+" "+loc2);
        return Math.sqrt(Math.pow((loc1.lattitude-loc2.lattitude),2)+Math.pow((loc1.longitude-loc2.longitude),2));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        if(!(this.lattitude == other.lattitude) || !(this.longitude==other.longitude))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Location [lattitude=" + lattitude + ", longitude=" + longitude + "]";
    }
    
    
}
