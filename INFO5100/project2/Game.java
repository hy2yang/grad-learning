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
        tricks=new Trick[ncards];
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
            //String header = String.format("%10s%\n",);
            System.out.printf("%10s%s\n"," ","player "+i+" shortest "+hands[i].getShortest());
            hands[i].display();
            if (i>0 && hands[i].getCards()[52/PLAYERS-1].getSuit()==0) {
                if(hands[i].getCards()[52/PLAYERS-1].getNum()<hands[i-1].getCards()[52/PLAYERS-1].getNum()) playerNum=i;
            }
            System.out.println();
        }        
        
        for (int i=0;i<tricks.length;++i) {
            tricks[i]=new Trick(PLAYERS);
            ++numberOfTricks;
            Card card;
            int j=playerNum;
            
            do {
                if (i==0 && j==playerNum) {
                    card=hands[j].getCards()[52/PLAYERS-1];
                    hands[j].removeCard(52/PLAYERS-1);                    
                }
                else {
                    card=hands[j].playACard(this, tricks[i]);
                }
                tricks[i].update(j, card);
                showPlay(j,card);
                j=(j+1)%PLAYERS;
            }
            while (j!=playerNum);            
            playerNum=tricks[i].getWinner();
            
            if (i==0) {
                while(cardsLeft>0) {
                    Card u=deck.dealCard();
                    tricks[0].addCard(u);
                    showPlay(-1,u);
                    --cardsLeft;
                }
            }
            System.out.println();
            
        }
    }
    
    private void showPlay(int playerNum, Card c) {
        if (playerNum==-1) {
            System.out.printf("%-15s%s%n", "undealt card",c.toString());
            return;
        }
        else System.out.printf("%-15s%s%n", "player "+playerNum,c.toString());
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
