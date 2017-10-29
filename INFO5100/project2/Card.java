package project2;

public class Card {
    
    private int num,suit;
    
    public int getNum() {
        return num;
    }

    public int getSuit() {
        return suit;
    }
    
    public int getValue() {
        return (13 * suit + num);
    }

    public Card (int n, int s) {
        if (n<2||n>14) throw new IllegalArgumentException("number must be between 2 and 14");
        if (s<0||s>3) throw new IllegalArgumentException("suit must be between 0 and 3");
        num=n;
        suit=s;
    }
    
    public String toString() {
        StringBuilder sb=new StringBuilder();
        if (num>10) {
            switch (num) {
            case 11: sb.append("Jack of "); break;
            case 12: sb.append("Queen of "); break;
            case 13: sb.append("King of "); break;
            case 14: sb.append("Ace of "); break;
            }
        }
        else {
            sb.append(num);
            sb.append(" of ");
        }
        switch (suit) {
        case 0:sb.append("clubs"); break;
        case 1:sb.append("diamonds"); break;
        case 2:sb.append("hearts"); break;
        case 3:sb.append("spades"); break;
        }        
        return sb.toString();
    }
    
    public void display() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Card a= new Card(6,2);
        a.display();

    }

}
