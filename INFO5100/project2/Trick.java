package project2;

public class Trick extends GroupOfCards {
    
    private int winner;
    private Card winningCard;
    private boolean hearts=false;
    private boolean queen=false;

    public int getWinner() {
        return winner;
    }

    public Card getWinningCard() {
        return winningCard;
    }

    public boolean getHearts() {
        return hearts;
    }

    public boolean getQueen() {
        return queen;
    }

    public Trick(int players) {
        super(2*players-1);
    }
    
    private boolean isWinner(Card c) {
        if (winningCard!=null) {
            if (c.getSuit()!=winningCard.getSuit() || c.getNum()<winningCard.getNum()) return false;
        }
        return true;
    }
    
    public void update(int playerNum, Card c) {
        if (isWinner(c)) {
            winningCard=c;
            winner=playerNum;
        }
        if (c.getSuit()==2) hearts=true;
        if (c.getNum()==12 && c.getSuit()==3) queen=true;
    }

}
