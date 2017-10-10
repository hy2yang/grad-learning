package assignment5;

class Sundae extends IceCream {
    
    private String topping;
    private int tprice;
    
    public Sundae(String n, int p, String t, int tp) {
        super(n,p);
        this.topping=t;
        this.tprice=tp;
    }
    
    public String getName() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("%-"+DessertShoppe.itemwidth+"s%n",topping+" Sundae with"));
        sb.append(String.format("%-"+DessertShoppe.itemwidth+"s",super.getName()));
        return sb.toString();
    }
    
    int getCost() {
        return super.getCost()+tprice;
    }

}
