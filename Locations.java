import java.util.ArrayList;

public class Locations{
    public static ArrayList<Locations> CitiLocations = new ArrayList<>();
    private String City;
    private double longitude;
    private double latitude;
    private ArrayList<Carrier> reachableBy = new ArrayList<>();

    public Locations(String City, double longitude, double latitude){
        this.City=City;
        addCarrier(new Truck());
        this.longitude=longitude;
        this.latitude=latitude;
        CitiLocations.add(this);
    }
    public String Cityname(){ return City;}
    public double Latitude() { return latitude; }
    public double Longitude() { return longitude;}

    public void addCarrier(Carrier carrier){
        if (reachableBy.contains(carrier)){
            System.out.println("Already exists");
        }
        else{
            reachableBy.add(carrier);
        }
    }
    public void removeCarrier(Carrier carrier){
        reachableBy.remove(carrier);
        System.out.println("Removed");
    }
}