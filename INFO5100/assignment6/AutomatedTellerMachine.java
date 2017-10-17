package assignment6;

import java.util.*;
//import java.io.*;

public class AutomatedTellerMachine {
    
    //private final static String datapath="D:/PROF/GIT/INFO5100/INFO5100/assignment6/atmdata";
    
    static class User{
        //private String datapath="D:/PROF/GIT/INFO5100/INFO5100/assignment6/userdata";
        private String name, address, phoneNumber, bankAccountNumber;
        private int age;  
        public User() {}
        public User(int age, String name,String address,String phoneNumber,String bankAccountNumber) {
            this.age=age;
            this.name=name;
            this.address=address;
            this.phoneNumber=phoneNumber;
            this.bankAccountNumber=bankAccountNumber;            
        }
    }
    
    static class Atm{
        
        private double availableAmountInMachine, transactionFee;
        private HashMap<User, String> userData;
        private HashMap<String, Double> accountbalance;
        private HashMap<String, ArrayList<String>> transactions;
        
        public Atm (double amount, double tf) {
            
            this.availableAmountInMachine=amount;
            this.transactionFee=tf;
            this.userData=new HashMap<>();
        }
        
/*        private void save() {
            try {
                FileOutputStream out = new FileOutputStream(datapath);  
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);  
                objectOutputStream.writeObject(this);  
                out.close();  
                System.out.println("data save/update success");
            }catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
 */       
        private void clearscreen(){
            String clearmagic;
            StringBuilder c=new StringBuilder();
            for(int i=0;i<50;i++){
               c.append(System.lineSeparator());
            }
            clearmagic=c.toString();
            System.out.println(clearmagic);
        }
        
        private boolean start() {
            System.out.println("Wlcome!");
            System.out.println("Are you a new user or current user?");
            System.out.println("input N(for new user) or C(for current user)");
            Scanner sc=new Scanner(System.in);
            while (true) {
                char input=sc.next().charAt(0);
                if (input=='N' || input=='n') {
                    sc.close();
                    return true;
                }
                if (input=='C' || input=='c') {
                    sc.close();
                    return false;
                }
                else {
                    System.out.println("Invalid input, try again");
                    System.out.println();
                }
            }            
        }
        
        private void createuser() {
            clearscreen();
            User temp=new User();
            String acc=String.format("%04d", this.userData.size()+1);
            temp.bankAccountNumber=acc;
            System.out.println("Your new account number is "+acc);
            Scanner sc=new Scanner(System.in);
            while (true) {
                System.out.println("Please enter your password");
                String input1=sc.next();
                System.out.println("Please enter your password again");
                String input2=sc.next();
                if (input1.equals(input2)) {
                    userData.put(temp, input1);
                    accountbalance.put(acc, 0.0);
                    System.out.println("Your account is set up!");
                    System.out.println("You can login by account number now, or by phone number only after finishing your profile details at a counter");
                    sc.close();
                    return;
                }
            }             
        }
        
        private User login() {
            boolean in=false;
            Scanner sc=new Scanner(System.in);
            User temp=new User();
            while (!in) {
                System.out.println("Please choose login method");
                System.out.println("input A(for by account number) or P(for by phone number)");
                System.out.println("input F if you forgot your password");                
                char input=sc.next().charAt(0);
                if (input=='A' || input=='a') {
                    System.out.println("Please enter your account number");
                    String acc=sc.next();
                    System.out.println("Please enter your password");
                    String pw=sc.next();
                    for (User u:userData.keySet()) {
                        if (u.bankAccountNumber.equals(acc) && userData.get(u).equals(pw)) {
                            in=true;
                            temp=u;
                            break;
                        }
                    }                    
                    continue;
                }
                if (input=='P' || input=='p') {
                    System.out.println("Please enter your phone number");
                    String ph=sc.next();
                    System.out.println("Please enter your password");
                    String pw=sc.next();
                    for (User u:userData.keySet()) {
                        if (u.phoneNumber.equals(ph) && userData.get(u).equals(pw)) {
                            in=true;
                            temp=u;
                            break;
                        }
                    }
                    continue; 
                }
                if (input=='F' || input=='f') {
                    this.resetpw();
                }
                else System.out.println("Invalid input, try again");
            }
            sc.close();
            return temp;
        }
            
        private void resetpw() {
            clearscreen();
            Scanner sc=new Scanner(System.in);
            boolean found=false;
            User temp=new User();
            String ph;
            while (!found) {
                System.out.println("Please enter your phone number");
                ph=sc.next();                
                for (User u:userData.keySet()) {
                    if (u.phoneNumber.equals(ph)) {
                        temp=u;
                        found=true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("This number is not registered");
                }                
            }
            String name;
            while (true) {
                System.out.println("Please enter your name");
                name=sc.next();
                if (!temp.name.equals(name)) break;
                System.out.println("name incorrect");
            }
            String age;
            while (true) {
                System.out.println("Please enter your age");
                age=sc.next();
                if (temp.age!=Integer.parseInt(age)) break;
                System.out.println("age incorrect");
            }
            while (true) {
                System.out.println("Please enter your new password");
                String input1=sc.next();
                System.out.println("Please enter your new password again");
                String input2=sc.next();
                if (input1.equals(input2)) {
                    this.userData.replace(temp, input1);
                    //accountlogins.put(acc, input1);
                    System.out.println("Your password is reset!");
                    sc.close();
                    return;
                }
            }
        }
        
        private void changepw(User u) {
            clearscreen();
            Scanner sc=new Scanner(System.in);
            while (true) {
                System.out.println("Please enter your new password");
                String input1=sc.next();
                System.out.println("Please enter your new password again");
                String input2=sc.next();
                if (input1.equals(input2)) {
                    this.userData.replace(u, input1);
                    System.out.println("Your password is changed!");
                    sc.close();
                    return;
                }
            }           
        }
        private void printBalance(User u) {
            String acc=userData.get(u);
            double b=accountbalance.get(acc);
            clearscreen();
            System.out.println(u.name+" your available balance is "+b);
            System.out.println("press ENTER to continue");
            System.out.println();
            Scanner sc=new Scanner(System.in);
            String line = sc.nextLine();
            sc.close();
        }
        
        private void printTransactions(User u) {
            String acc=userData.get(u);
            ArrayList<String> l=transactions.get(acc);
            int n=Math.max(10,l.size());
            clearscreen();
            for (int i=0;i<n;i++) {
                System.out.println(l.get(i));
            }
            System.out.println("press ENTER to continue");
            System.out.println();
            Scanner sc=new Scanner(System.in);
            String line = sc.nextLine();
            sc.close();
        }
        
        private void deposit(User u) {
            String acc=userData.get(u);
            double b=accountbalance.get(acc);
            Scanner sc=new Scanner(System.in);
            StringBuilder sb=new StringBuilder("deposit - ");
            clearscreen();
            System.out.println(u.name+" your available balance is "+b);
            System.out.println("Please input the amount to deposit");            
            double d=Double.parseDouble(sc.next());            
            accountbalance.replace(acc, b+d-transactionFee);
            this.availableAmountInMachine+=d;
            sb.append(d);
            transactions.get(acc).add(sb.toString());
            b=accountbalance.get(acc);
            System.out.println("Your deposit is done, transaction fee of "+transactionFee+" is applied");
            System.out.println(u.name+" your available balance is "+b);
            System.out.println();
            System.out.println("press ENTER to continue");
            String line = sc.nextLine();
            sc.close();
        }
        
        private void withDrawal(User u) {
            String acc=userData.get(u);
            double b=accountbalance.get(acc);
            Scanner sc=new Scanner(System.in);
            StringBuilder sb=new StringBuilder("withDrawal - ");    
            double d=0.0;
            while (true) {
                clearscreen();
                System.out.println(u.name+" your available balance is "+b);
                System.out.println("Please input the amount to withdraw");            
                d=Double.parseDouble(sc.next());
                if (d>this.availableAmountInMachine) {
                    System.out.println("Sorry, that exceeded the available amount in this machine");
                    continue;
                }
                if (d>b-transactionFee) {
                    System.out.println("Sorry, that (plus the transaction fee) exceeded the available amount in your account");
                    continue;
                }
                else break;
            }
            accountbalance.replace(acc, b-d-transactionFee);
            this.availableAmountInMachine-=d;
            sb.append(d);
            transactions.get(acc).add(sb.toString());
            b=accountbalance.get(acc);
            System.out.println("Your withdrawal is done, transaction fee of "+transactionFee+" is applied");
            System.out.println(u.name+" your available balance is "+b);
            System.out.println();
            System.out.println("press ENTER to continue");
            String line = sc.nextLine();
            sc.close();
            return;
        }
        
        
        private void desktop(User u) {
            Scanner sc=new Scanner(System.in);
            while (true) {
                clearscreen();
                System.out.println("Hello, "+u.name+" please choose the activity you want");
                System.out.println("input A(for available balance), T(for recent transactions)");
                System.out.println("input W(for withdraw), D(for deposit)");
                System.out.println("input C(for change password), E(for exit)");
                char input=sc.next().charAt(0);
                if (input=='A' || input=='a') printBalance(u);
                if (input=='T' || input=='t') printTransactions(u);
                if (input=='W' || input=='w') withDrawal(u);
                if (input=='D' || input=='d') deposit(u);
                if (input=='C' || input=='c') changepw(u);
                if (input=='E' || input=='e') {
                    sc.close();
                    return;
                }
            }            
        }
        
        public void run() {
            while (true) {                
                boolean isnew=start();
                if (isnew) createuser();
                User cur=login();
                desktop(cur);
            } 
        }
        
    }
    
/*    private static Atm readfromfile() {
        try {  
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(datapath));  
            Atm temp =(Atm) in.readObject();
            in.close();
            return temp;                
        } catch (Exception e) {
            e.printStackTrace();
            return new Atm(5000.0f,1.0f);
        }            
    }
 */   
    
    public static void main(String[] args) {
        Atm a=new Atm(5000.0f,1.0f);
        a.run();        
    }
}
