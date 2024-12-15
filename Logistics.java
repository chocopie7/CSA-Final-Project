public class Logistics{
    private Client sender;
    private Client reciever;
    private Goods good;
    
    public Logistics(Client sender,Client reciever, Goods good){
        this.sender=sender;
        this.reciever=reciever;
        this.good=good;
        System.out.println("\nSending "+good.ItemName()+" to "+reciever.Name() +":");
        System.out.println(costCalculator(new Truck()));
        System.out.println(costCalculator(new Ship()));
        System.out.println(costCalculator(new Plane()));
        System.out.println(costCalculator(new Train()));
    }
    private String costCalculator(Carrier transport){
        if (good.Perishable()&&(transport.carrierType().equals("Ship")
        ||transport.carrierType().equals("Train"))){
            return "Spoils when transported on a "+transport.carrierType();
        }
        double distance = Math.pow(Math.pow(reciever.Location().Latitude()-sender.Location().Latitude(),2)+Math.pow(reciever.Location().Latitude()-sender.Location().Latitude(),2),0.5);
        if ((distance/transport.Speed())>good.ShipBy()){
            return "Past shipping date" + " with a " +transport.carrierType();
        }
        return "$"+transport.costPerMile()*good.Weight()+" to transport in "+ (distance/transport.Speed())+ " days with a " +transport.carrierType();
    }
}