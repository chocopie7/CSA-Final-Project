public class Carrier{
    private double costpermile;
    private double speed;
    private String carriertype;

    public Carrier(double costPerMile, double speed){
        this.costpermile=costPerMile;
        this.speed=speed;
    }
    public void setType(String type){
        carriertype=type;
    }
    public String carrierType(){
        return carriertype;
    }
    public double Speed(){
        return speed;
    }
    public double costPerMile(){
        return costpermile;
    }
}
class Truck extends Carrier{
    public Truck(){
        super(4.5,80.0);
        setType("Truck");
    }
}
class Ship extends Carrier{
    public Ship(){
        super(1.8,20.0);
        setType("Ship");
    }
}
class Plane extends Carrier{
    public Plane(){
        super(9.0,120.0);
        setType("Plane");
    }

}
class Train extends Carrier{
    public Train(){
        super(2.0,80.0);
        this.setType("Train");
    }
}