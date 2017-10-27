package project2;

public class Hand extends GroupOfCards {    
    
    public final int NUM;
    private int shortest=0;
    
    public Hand(int playerNum, int numOfCards) {
        super(numOfCards);
        NUM=playerNum;
    }
    
    public void sort() {
        int unsorted=super.getCurrentSize();
        for (int i=unsorted;i>0;--i) {
            int max=0;
            for (int j=0;j<i;j++) {
                if (super.getCards()[j].getValue()>super.getCards()[max].getValue()) max=j;
            }
            super.addCard(super.removeCard(max));
        }
    }
    
    public int getShortest() {
        return shortest;
    }

    public void setShortest() {
        int diamonds=0,clubs=0,spades=0;
        boolean spadeQKA=false;
        for (Card c: super.getCards()) {
            if (c.getSuit()==0) {
                clubs++;
                continue;
            }
            if (c.getSuit()==1) {
                diamonds++;
                continue;
            }
            if (c.getSuit()==3) {
                spades++;
                if (c.getNum()>11) spadeQKA=true;
                continue;
            }            
        }
        if (diamonds<=clubs) shortest=1;
        if (spades<=Math.min(diamonds, clubs) && !spadeQKA) shortest=3;
    }
    
    public Card playACard(Game game, Trick trick) {
        return this.getCards()[0];
    }
    
    
    

}
