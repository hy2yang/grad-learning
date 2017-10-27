package project2;

public class Game {
    
    public final int PLAYERS;
    private Deck deck;
    private Hand[] hands;
    private Trick[] tricks;
    private int numberOfTricks=0;
    private boolean hearts=false;
    private boolean queenOfSpades=false;
    
    public int getNumberOfTricks() {
        return numberOfTricks;
    }
    
    public boolean getHearts() {
        return hearts;
    }

    public boolean getQueenOfSpades() {
        return queenOfSpades;
    }
    
    public Game(int nplayers) {
        PLAYERS=nplayers;
        hands=new Hand[nplayers];
        int ncards=52/nplayers;
        for (int i=0;i<nplayers;++i) {
            hands[i]=new Hand(i, ncards);
        }
        tricks=new Trick[nplayers];
    }
    
    public void playAGame() {
        deck=new Deck();
        deck.shuffle();
        int cardsLeft = 52%PLAYERS;
        
        while (deck.getCurrentSize()>cardsLeft) {
            for (int i=0;i<PLAYERS;i++) {
                hands[i].addCard(deck.dealCard());
            }
        }
        
        for (int i=0;i<PLAYERS;i++) {
            hands[i].sort();
            hands[i].setShortest();
        }
        
        int playerNum=0;
        for (int i=0;i<PLAYERS;i++) {
            System.out.printf("player "+i+" shortest="+hands[i].getShortest(), "% 10s%n" );
            hands[i].display();
            if (i>0 && hands[i].getCards()[52/PLAYERS].getSuit()==0) {
                if(hands[i].getCards()[52/PLAYERS].getNum()<hands[i-1].getCards()[52/PLAYERS].getNum()) playerNum=i;
            }
            System.out.println();
        }
    }
    
    
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
