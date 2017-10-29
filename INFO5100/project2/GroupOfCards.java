package project2;

public class GroupOfCards {
    
    private Card[] cards;    
    private int currentSize=0;
    
    public Card[] getCards() {
        return cards;
    }

    public int getCurrentSize() {
        return currentSize;
    }
    
    public GroupOfCards(int s) {
        if (s<0||s>52) throw new IndexOutOfBoundsException("size cards must be between 0 and 52");
        cards=new Card[s];
    }
    
    public void addCard(Card c) {
        cards[currentSize++]=c;
    }
    
    public Card removeCard(int i) {
        Card res=cards[i]; 
        --currentSize;
        for (int j=i;j<currentSize;++j) {
            cards[j]=cards[j+1];
        }
        cards[currentSize]=null;
        return res;
    }
    
    public void display() {
        for (Card c:cards) {
            c.display();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
