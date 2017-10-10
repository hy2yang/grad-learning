package assignment5;

class Candy extends DessertItem{
    
    private double weight;
    private int price_per_pound;
    
    public Candy (String n, double d, int p) {
        this.name=n;
        this.weight=d;
        this.price_per_pound=p;
    }
    
    public int getCost() {
        int p=(int) Math.round(weight*price_per_pound);
        return p;        
    }

    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("%-"+DessertShoppe.itemwidth+"s%n",weight+" lbs. @ "+DessertShoppe.cents2dollarsAndCents(price_per_pound)+" /lb."));
        sb.append(String.format("%-"+DessertShoppe.itemwidth+"s",super.getName()));
        return sb.toString();
    }
}
