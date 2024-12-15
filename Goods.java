public class Goods{
    private String itemname;
    private long itemid;
    private double weight;
    private boolean perishable;
    private int shipBy;

    public Goods(String itemname, long itemid, double weight, boolean perishable, int shipBy){
        this.itemname=itemname;
        this.itemid=itemid;
        this.weight=weight;
        this.perishable=perishable;
        this.shipBy=shipBy;
    }
    public String ItemName(){
        return itemname;
    }
    public long Itemid(){
        return itemid;
    }
    public double Weight(){
        return weight;
    }
    public Boolean Perishable(){
        return perishable;
    }
    public int ShipBy(){
        return shipBy;
    }
    public String toString(){
        return itemname+" "+itemid+" to be shipped by "+shipBy;
    }
}