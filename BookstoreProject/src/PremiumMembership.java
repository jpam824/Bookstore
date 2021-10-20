public class PremiumMembership extends Membership{
    private String paymentMethod;
    private boolean billPaid;
    public PremiumMembership(int id, String name, String meth){
        super(id, name);
        paymentMethod = meth;
    }
    public void payBill(){
        billPaid = true;
    }

    public String getMethod(){
        return paymentMethod;
    }

    public void setMethod(String meth){paymentMethod = meth;}

    public boolean isBillPaid(){
        return billPaid;
    }
}
