package assignment4;

public class IpAddress {

    private String dottedDecimal;
    private int firstOctet, secondOctet, thirdOctet, fourthOctet;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public IpAddress(String dotted) {
        this.dottedDecimal=dotted;
        this.firstOctet=Integer.parseInt(dotted.split("\\.",4)[0]);
        this.secondOctet=Integer.parseInt(dotted.split("\\.",4)[1]);
        this.thirdOctet=Integer.parseInt(dotted.split("\\.",4)[2]);
        this.fourthOctet=Integer.parseInt(dotted.split("\\.",4)[3]);
    }

    public String getDottedDecimal() {
        return dottedDecimal;
    }

    public int getOctet(int pos) {
        switch (pos) {
        case 1: return firstOctet;
        case 2: return secondOctet;
        case 3: return thirdOctet;
        case 4: return fourthOctet;
        }
        return 0;
    }

}
