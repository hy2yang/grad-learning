package project2;

public class Deck extends GroupOfCards{
    
    public static int TOTAL_CARDS=52;
    
    public Deck() {
        super(52);
        for (int s=0;s<4;++s) {
            for (int n=2;n<15;++n) {
                super.addCard(new Card(n,s));
            }
        }
    }
    
    public void shuffle() {
        int unshuffled=super.getCurrentSize();
        int i=unshuffled;
        for (;i>0;--i) {
            int x=(int) Math.rint(Math.random()*(i-1));
            super.addCard(super.removeCard(x));
        }
    }
    
    public Card dealCard() {
        return super.removeCard(0);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
