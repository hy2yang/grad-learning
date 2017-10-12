package project1;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Hangman {
    private ArrayList<String> list;
    private String target;
    private ArrayList<Character> correctList;
    private ArrayList<Character> wrongList;
    
    
    public Hangman(ArrayList<String> words){
            this.list=words;
            correctList=new ArrayList<Character>();
            wrongList=new ArrayList<Character>();
            System.out.println("Welcome to the hangman game!");           
            
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
        
    }
    
    public void handleGuess(){
        int left=8-wrongList.size();
        System.out.println("You have "+left+" chance(s) left");
        System.out.println("Guess a letter from the word");
        Scanner sc=new Scanner(System.in);
        sc.useDelimiter("");
        char next=sc.next().charAt(0);
        if (target.indexOf(next)>-1){
            if( correctList.contains(next)){
                
            }
            else correctList.add(next);
        }
        else correctList.add(next);
        sc.remove();
        
    }
    
    
    
    public static void main(String[] args) {
        
    }

}
