import java.util.*;
public class Bookstore {

    Inventory inv;
    private static int memberNum = 1;
    private static int prodID = 1;
    public Bookstore(Inventory inv){
        this.inv = inv;
        addItemToInv(new CD(19.99, "Nas - Illmatic (Full Album)", 1));
        addItemToInv(new DVD(9.99, "Shawshank Redemption", 2));
        addItemToInv(new Book(4.99, "Harry Potter and the Goblet of Fire", "J.K. Rowling", 3));

    }


    /**
     * This helper method returns the desired ArrayList inventory type
     * @param type
     * @return an ArrayList of whatever argument type is thrown
     */
    public ArrayList<? extends Product> getProperInv(String type){
        ArrayList<? extends Product> list;
        switch(type){
            case "DVD":
                list = inv.dvdInv;
                break;
            case "CD":
                list = inv.cdInv;
                break;
            case "Book":
                list = inv.bookInv;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return list;
    }

    /**
     * This method searches the inventory for the product with the matching ID to the argument
     * @param id
     * @param type
     * @return The product with the matching ID
     */
    public Product searchById(int id, String type){
        ArrayList<? extends Product> list = getProperInv(type);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getID() == id) return list.get(i);
        }
        return null;
    }

    public Product searchById(String type){
        ArrayList<? extends Product> list = getProperInv(type);
        if(list.size() != 0)
        return list.get(0);

        return null;
    }

    /**
     *Finds the member with the matching ID to the one thrown in the parameter
     * @param id Member ID argument to help find member in the memberList
     * @return the Member object with the matching ID
     */
    public Membership searchMemberById(int id){
        for(int i = 0; i < inv.membersList.size(); i++){
            if(inv.membersList.get(i).getID() == id) return inv.membersList.get(i);
        }
        return null;
    }

    public void purchaseProduct(Product p, Membership m){
        m.purchasedProd(p);
        removeItem(p);
    }

    /**
     * Method to add a product to the store inventory list
     * @param p The product to be added to the inventory
     */
    public void addItemToInv(Product p){
        switch (p.getType()){
            case "DVD":
                inv.dvdInv.add((DVD)p);
                break;
            case "CD":
                inv.cdInv.add((CD)p);
                break;
            case "Book":
                inv.bookInv.add((Book)p);
                break;
        }
        prodID++;
    }

    /**
     * Removes a specific product from the inventory list
     * @param p
     */
    public void removeItem(Product p){
        ArrayList<? extends Product> list = getProperInv(p.getType());
        list.remove(p);

    }

//    public void removeItemByID(int id, String type){
//        ArrayList<? extends Product> list = getProperInv(type);
//        Product index = searchById(id, type);
//        list.remove(index);
//    }
//
//    public Product newItem(double price, int id, String...a){
//        switch(a[1]) {
//            case "CD":
//                return new CD(price, a[0], id);
//
//            case "DVD":
//                return new DVD(price, a[0], id);
//            case "Book":
//                return new Book(price, a[0], a[2], id);
//        }
//        return null;
//    }

    /**
     * Adds a new member to the store member list
     * @param name
     * @param prem
     * @param pay
     */
    public void newMembership(String name, boolean prem, boolean pay){
        inv.membersList.add(new Membership(memberNum, name));
        if(prem){
            inv.paidList.put(new PremiumMembership(memberNum, name, ""), pay);
        }
        memberNum++;
    }

//    public String memberItems(Membership m){
//        return m.getProdPurchased().toString();
//    }

    /**
     * Method to get current member number
     * @return memberNum
     */
    public int getMemberNum(){
        return memberNum;
    }

    /**
     * @return current product ID
     */
    public int getProdID(){
        return prodID;
    }

}
