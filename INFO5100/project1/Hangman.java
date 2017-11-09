package project1;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Hangman {
    private ArrayList<String> list;
    private String target;
    private ArrayList<Character> correctList;
    private ArrayList<Character> wrongList;
    private ArrayList<String> graph;
    private static Scanner sc=new Scanner(System.in);
    
    
    public Hangman(ArrayList<String> words){
            this.list=words;
            correctList=new ArrayList<Character>();
            wrongList=new ArrayList<Character>();
            graph=new ArrayList<String>();
            graph.add("+------------------+\r\n" + 
                    "+------------------+\r\n" + 
                    " | |          |\r\n" + 
                    " | |          |\r\n" + 
                    " | |          |\r\n" + 
                    " | |          +\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " +-+\r\n");
            graph.add("+------------------+\r\n" + 
                    "+------------------+\r\n" + 
                    " | |          |\r\n" + 
                    " | |          |\r\n" + 
                    " | |          +\r\n" + 
                    " | |          A\r\n" + 
                    " | |         (_)\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " +-+\r\n");
            graph.add("+------------------+\r\n" + 
                    "+------------------+\r\n" + 
                    " | |          |\r\n" + 
                    " | |          |\r\n" + 
                    " | |          +\r\n" + 
                    " | |          A\r\n" + 
                    " | |         (_)\r\n" + 
                    " | |          +\r\n" + 
                    " | |          |\r\n" + 
                    " | |          |\r\n" + 
                    " | |          |\r\n" + 
                    " | |          +\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " +-+\r\n");
            graph.add("+------------------+\r\n" + 
                    "+------------------+\r\n" + 
                    " | |          |\r\n" + 
                    " | |          |\r\n" + 
                    " | |          +\r\n" + 
                    " | |          A\r\n" + 
                    " | |         (_)\r\n" + 
                    " | |         /+\r\n" + 
                    " | |        / |\r\n" + 
                    " | |       /  |\r\n" + 
                    " | |      /   |\r\n" + 
                    " | |          +\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " +-+\r\n");
            graph.add("+------------------+\r\n" + 
                    "+------------------+\r\n" + 
                    " | |          |\r\n" + 
                    " | |          |\r\n" + 
                    " | |          +\r\n" + 
                    " | |          A\r\n" + 
                    " | |         (_)\r\n" + 
                    " | |         /+\\ \r\n" + 
                    " | |        / | \\ \r\n" + 
                    " | |       /  |  \\ \r\n" + 
                    " | |      /   |   \\ \r\n" + 
                    " | |          +\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " | |\r\n" + 
                    " +-+\r\n");
            graph.add("+------------------+\r\n" + 
                    "+------------------+\r\n" + 
                    " | |          |\r\n" + 
                    " | |          |\r\n" + 
                    " | |          +\r\n" + 
                    " | |          A\r\n" + 
                    " | |         (_)\r\n" + 
                    " | |         /+\\\r\n" + 
                    " | |        / | \\\r\n" + 
                    " | |       /  |  \\\r\n" + 
                    " | |      /   |   \\\r\n" + 
                    " | |          +\r\n" + 
                    " | |         /\r\n" + 
                    " | |        /\r\n" + 
                    " | |       /\r\n" + 
                    " | |      /\r\n" + 
                    " | |\r\n" + 
                    " +-+\r\n");
            graph.add("+------------------+\r\n" + 
                    "+------------------+\r\n" + 
                    " | |          |\r\n" + 
                    " | |          |\r\n" + 
                    " | |          +\r\n" + 
                    " | |          A\r\n" + 
                    " | |         (_)\r\n" + 
                    " | |         /+\\\r\n" + 
                    " | |        / | \\\r\n" + 
                    " | |       /  |  \\\r\n" + 
                    " | |      /   |   \\\r\n" + 
                    " | |          +\r\n" + 
                    " | |         / \\\r\n" + 
                    " | |        /   \\\r\n" + 
                    " | |       /     \\\r\n" + 
                    " | |      /       \\\r\n" + 
                    " | |\r\n" + 
                    " +-+\r\n");
            graph.add("+------------------+\r\n" + 
                    "+------------------+\r\n" + 
                    " | |          |\r\n" + 
                    " | |          |\r\n" + 
                    " | |          +\r\n" + 
                    " | |          A\r\n" + 
                    " | |         (_)\r\n" + 
                    " | |         /+\\\r\n" + 
                    " | |        / | \\\r\n" + 
                    " | |       /  |  \\\r\n" + 
                    " | |      /   |   \\\r\n" + 
                    " | |          +\r\n" + 
                    " | |         / \\\r\n" + 
                    " | |        /   \\\r\n" + 
                    " | |       /     \\\r\n" + 
                    " | |    __/       \\\r\n" + 
                    " | |\r\n" + 
                    " +-+\r\n");
            graph.add("+------------------+\r\n" + 
                    "+------------------+\r\n" + 
                    " | |          |\r\n" + 
                    " | |          |\r\n" + 
                    " | |          +\r\n" + 
                    " | |          A\r\n" + 
                    " | |         (_)\r\n" + 
                    " | |         /+\\\r\n" + 
                    " | |        / | \\\r\n" + 
                    " | |       /  |  \\\r\n" + 
                    " | |      /   |   \\\r\n" + 
                    " | |          +\r\n" + 
                    " | |         / \\\r\n" + 
                    " | |        /   \\\r\n" + 
                    " | |       /     \\\r\n" + 
                    " | |    __/       \\__ \r\n" + 
                    " | |\r\n" + 
                    " +-+\r\n");
            
    }
    
    public void playGame() {
        System.out.println("Welcome to the hangman game!");
        chooseWord();
        while (!gameWon() && wrongList.size()<8) {
            displayWord();
            printHangman();
            progress();
            handleGuess();
            clearscreen();            
        }
        displayWord();
        printHangman();
        gameOver();
        
    }
    
    public void chooseWord(){
        int random=ThreadLocalRandom.current().nextInt(0, list.size());
        target=list.get(random);
    }
    
    public void displayWord(){
        StringBuilder sb= new StringBuilder();
        for (char i:target.toCharArray()){
            if (correctList.contains(i)) sb.append(i);
            else sb.append('-');
        }
        System.out.println(sb.toString());
    }
    
    private void clearscreen(){
        String clearmagic;
        StringBuilder c=new StringBuilder();
        for(int i=0;i<50;i++){
           c.append(System.lineSeparator());
        }
        clearmagic=c.toString();
        System.out.println(clearmagic);
    }
    
    public void printHangman(){
        int a=wrongList.size();
        System.out.print(graph.get(a));
    }
    
    public void handleGuess(){ 
        System.out.println("Guess a letter from the word");
        //sc.useDelimiter("");        
        while (true) {
            char next=sc.next().charAt(0);
            if (target.indexOf(next)>-1){
                if( correctList.contains(next)){
                    System.out.println("You've already got this one");
                    sc.reset();
                    continue;
                }            
                else {
                    correctList.add(next);
                    break;
                }
            }
            else {
                wrongList.add(next);  
                break;
            }
        }
    }
    
    private void progress() {
        int left=8-wrongList.size();
        System.out.println("You have "+left+" chance(s) left");
        StringBuilder sb= new StringBuilder();
        for (char i:wrongList){
            sb.append(' ');
            sb.append(i);
        }
        System.out.println("Your wrong guess(es):"+sb.toString());
    }
    
    public boolean gameWon() {
        if (wrongList.size()<8 && correctList.size()==target.length()) return true;
        return false;
    }
    
    public void gameOver() {
        if (gameWon()) System.out.println("You win!");
        else System.out.println("You lose! The word is \""+target+"\"");
        System.out.println("press ENTER to exit hangman");
        sc.nextLine();
        sc.nextLine();
        sc.close();
        clearscreen();
        System.exit(0);
    }
    
    
    
    public static void main(String[] args) {
        ArrayList<String> words= new ArrayList<String>();
        words.add("abcd");
        words.add("efgh");
        Hangman a=new Hangman(words);
        a.playGame();
        
    }

} 
