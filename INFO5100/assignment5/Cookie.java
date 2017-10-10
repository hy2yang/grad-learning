package assignment5;

class Cookie extends DessertItem {
    
    private int number;
    private int price_per_dozen;
    
    public Cookie(String n, int x, int p) {
        this.name=n;
        this.number=x;
        this.price_per_dozen=p;
    }
    
    int getCost() {
        int p=Math.round(price_per_dozen*number/12);
        return p;        
    }
    
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("%-"+DessertShoppe.itemwidth+"s%n",number+" @ "+DessertShoppe.cents2dollarsAndCents(price_per_dozen)+" /dz."));
        sb.append(String.format("%-"+DessertShoppe.itemwidth+"s",super.getName()));
        return sb.toString();
    }

}
