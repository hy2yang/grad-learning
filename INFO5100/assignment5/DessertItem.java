package assignment5;

abstract class DessertItem {
    
    protected String name;
    
    public String getName() {
        return name;
    }

    public DessertItem() {        
    }
    
    public DessertItem(String n) {
        this.name=n;
    }
    
    abstract int getCost();
    
    public String toString() {
        
        return getName();
    }
}


