import java.util.*;

public class Membership {
    private int memberID;
    private String name;
    private ArrayList<Product> prodPurchased = new ArrayList<>();

    public Membership(int id, String na){
        memberID = id;
        name = na;
    }

    public int getID(){
        return memberID;
    }

    public String getName(){
        return name;
    }

    public void purchasedProd(Product p){
        prodPurchased.add(p);
    }

    public ArrayList<Product> getProdPurchased(){ return prodPurchased;}

    public boolean hasProduct(int id){
        for(Product p : prodPurchased){
            if(p.getID() == id){
                return true;
            }
        }
        return false;
    }
}
