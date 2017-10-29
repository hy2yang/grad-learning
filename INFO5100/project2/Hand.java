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
    
    public Card playACard(Game g, Trick trick) {
        int index;       
        if (trick.getCurrentSize()==0) {
            index=findHighest(shortest)==-1? findLowest(g):findHighest(shortest);  
        }
        else if (trick.getCurrentSize()==g.PLAYERS-1 && !trick.getHearts() && !trick.getQueen()&& (index = findLastHigh(trick.getWinningCard().getSuit())) >= 0);
        else if ((index = findHighestBelow(trick.getWinningCard())) >= 0);
        else if ((index = findMiddleHigh(g, trick.getWinningCard().getSuit())) >= 0);
        else if ((index = find(12, 3)) >= 0); // queen of Spades
        else if ((index = find(14, 3)) >= 0); // Ace of Spades
        else if ((index = find(13, 3)) >= 0); // King of Spades
        else if ((index = findHighest(2)) >= 0); // heart
        else  {index = findHighest();}
        Card c=this.removeCard(index);
        trick.update(NUM, c);
        g.updateHeartsAndQueen(c);
        return c;
    }
    
    private int find(int suit, int num) {
        int res=-1;
        for (int i=0;i<this.getCurrentSize();++i) {
            if (this.getCards()[i].getNum()==num && this.getCards()[i].getSuit()==suit) res=i;
        }
        return res;
    }
    
    public int findLowest(int suit) {
        int min= Integer.MAX_VALUE;
        for (Card c:this.getCards()) {
            if (c.getSuit()!=suit) continue;
            min=Math.min(min, c.getNum());
        }
        return min==Integer.MAX_VALUE? -1:find(suit,min);
    }
    
    private int findCount(int suit) {
        int res=0;
        for (Card c:this.getCards()) {
            if (c.getSuit()!=suit) continue;
            ++res;
        }
        return res;
    }  
    
    private int findHighest() {
        int max= Integer.MIN_VALUE,index=0;
        for (int i=0;i<this.getCurrentSize();++i) {
            if (this.getCards()[i].getNum()>max) {
                max=this.getCards()[i].getNum();
                index=i;
            }
        }
        return max==Integer.MIN_VALUE? -1:index;
    }
    
    private int findHighest(int suit) {
        int max= Integer.MIN_VALUE;
        for (Card c:this.getCards()) {
            if (c.getSuit()!=suit) continue;
            max=Math.max(max, c.getNum());
        }
        return max==Integer.MIN_VALUE? -1:find(suit,max);
    }
    
    private int findLowest(Game g) {
        int min=Integer.MAX_VALUE;
        for (Card c:this.getCards()) {
            if (!g.getHearts() && c.getSuit()==2) continue;
            min=Math.min(min, c.getNum());
        }
        return min==Integer.MAX_VALUE? -1:min;
    }
    
    private int findLastHigh(int suit) {
        int max= Integer.MIN_VALUE;
        for (Card c:this.getCards()) {
            if (c.getSuit()!=suit) continue;
            if (c.getSuit()==3 && c.getNum()==12) continue;
            max=Math.max(max, c.getNum());
        }
        return max==Integer.MIN_VALUE? -1:find(suit,max);
    }
    
    private int findHighestBelow(Card winning) {
        int max= Integer.MIN_VALUE;
        for (Card c:this.getCards()) {
            if (c.getSuit()!=winning.getSuit()) continue;
            if (c.getNum()<winning.getNum()) max=Math.max(max, c.getNum());            
        }
        return max==Integer.MIN_VALUE? -1:find(winning.getSuit(),max);
    }
    
    private int findMiddleHigh(Game g, int suit) {
        if(suit==3 && !g.getQueenOfSpades()) return findHighestBelow(new Card(11,3));
        int max= Integer.MIN_VALUE;
        for (Card c:this.getCards()) {            
            if (c.getSuit()!=suit) continue;            
            max=Math.max(max, c.getNum());
        }
        return max==Integer.MIN_VALUE? -1:find(suit,max);
        
    }
    
    
    

}
