public class Client{
    private String name;
    private Locations location;
    
    public Client(String name, Locations location){
        this.name=name;
        this.location=location;
    }
    public String Name(){
        return name;
    }
    public Locations Location(){
        return location;
    }
    public String toString(){
        return name+" from "+location.Cityname();
    }
}