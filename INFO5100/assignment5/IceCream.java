package assignment5;

class IceCream extends DessertItem {
    
    private int price;
    
    public IceCream(String n, int p) {
        this.name=n;
        this.price=p;        
    }
    
    int getCost() {
        return price;
    }

}
