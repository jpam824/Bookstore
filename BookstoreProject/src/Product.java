public abstract class Product {
    private double price;
    private int ID;
    private String name;
    private String type;
    public Product(double price, String name, int id){
        this.price = price;
        this.name = name;
        this.ID = id;
    }

    public void setType(String tye){
        type = tye;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

}
