package assignment5;

import java.util.*;

class Checkout {
    private ArrayList<DessertItem> list;
    
    public Checkout() {
        this.list=new ArrayList<DessertItem>();
    }
    
    public int numberOfItems() {
        return list.size();
    }
    
    public void enterItem( DessertItem item) {
        list.add(item);
    }
    
    public void clear() {
        list.clear();
    }
    
    public int totalCost() {
        int c=0;
        for (DessertItem i:list) {
            c+=i.getCost();
        }
        return c;
    }
    
    public int totalTax() {
        return (int) Math.round(totalCost()*DessertShoppe.taxrate);
    }   
    
    public String toString() {
        StringBuilder sb=new StringBuilder();
        int w=DessertShoppe.itemwidth+DessertShoppe.pricewidth;
        int left=(w-DessertShoppe.name.length())/2;
        sb.append(String.format("%"+left+"s%s%"+(w-left)+"s%n"," ",DessertShoppe.name," ")); //print shop name
        for (int i=0;i<left;i++) sb.append(" ");
        for (int i=0;i<DessertShoppe.name.length();i++) sb.append("-");
        sb.append(System.getProperty("line.separator"));             // print the division line
        sb.append(System.getProperty("line.separator"));
        for (DessertItem i:list) {
            sb.append(String.format("%-"+DessertShoppe.itemwidth+"s",i ) );
            sb.append(String.format("%"+DessertShoppe.pricewidth+"s%n",DessertShoppe.cents2dollarsAndCents(i.getCost()) ) );
        }
        sb.append(System.getProperty("line.separator"));
        sb.append(String.format("%-"+DessertShoppe.itemwidth+"s%"+DessertShoppe.pricewidth+"s%n","Tax",DessertShoppe.cents2dollarsAndCents(totalTax())));
        sb.append(String.format("%-"+DessertShoppe.itemwidth+"s%"+DessertShoppe.pricewidth+"s%n","Total Cost",DessertShoppe.cents2dollarsAndCents(totalTax()+totalCost())));
        return sb.toString();
        
    }

   

}
