package project2;

import java.util.Scanner;

public class GameDriver {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while (true) {
            System.out.println("Please input the number of players (3-6)");
            int n=input.nextInt();
            Game a =new Game(n);
            a.playAGame();
            while (true) {
                System.out.println("Play another game (y/n)?");
                char c=input.next().charAt(0);
                if (c=='n' || c=='N') {
                    input.close();
                    return;
                }
                if (c=='y' || c=='Y') break;
            }            
        }          
    }

}
