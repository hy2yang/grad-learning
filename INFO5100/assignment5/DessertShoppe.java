package assignment5;

class DessertShoppe {
    
    final static String name = "Sweet Time Dessert Shoppe"; 
    final static float taxrate=0.1f;
    final static int itemwidth=30;
    final static int pricewidth=6;
    
    
    static String cents2dollarsAndCents(int cents) {
        StringBuilder sb=new StringBuilder();
        sb.append(cents/100);
        sb.append('.');
        sb.append(String.format("%02d",cents%100));
        return sb.toString();
    }    
    

}
