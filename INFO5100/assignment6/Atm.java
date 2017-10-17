package assignment6;

import java.util.*;
//import java.io.*;

//all methods and data are public so that can be tested

public class Atm {
    
    private static Scanner sc=new Scanner(System.in);
    public double availableAmountInMachine, transactionFee;
    public HashMap<User, String> userData;  //user as key, password as val
    public HashMap<String, Double> accountbalance; //account number as key, amount as val;
    public HashMap<String, Stack<String>> transactions;//account number as key, list of transactions as val;
    public Atm () {}
    public Atm (double amount, double tf) {        
        this.availableAmountInMachine=amount;
        this.transactionFee=tf;
        this.userData=new HashMap<>();
        this.accountbalance=new HashMap<>();
        this.transactions=new HashMap<>();
    } 

    public static void main(String[] args) {
        Atm a=new Atm(5000.0f,1.0f);
        User tom=new User(26,"Tom","","1234567890","0001");
        User liz=new User(25,"Liz","","0123456789","0002");
        a.createuser(tom, "0001", "tompw");
        a.createuser(liz, "0002", "lizpw");
        a.accountbalance.put("0001", 3942.68);
        a.accountbalance.put("0002", 8751.24);
        
        for (int i=1;i<6;i++) {
            a.deposit(liz, 20.0*i);
        }
        for (int i=1;i<6;i++) {
            a.withDrawal(liz, 20.0*i);
        }
        a.run();
    }
    
/*  public void save() {
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
    
/*  public static Atm readfromfile() {
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
    
    private static void clearscreen() {
        String clearmagic;
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            c.append(System.lineSeparator());
        }
        clearmagic = c.toString();
        System.out.println(clearmagic);
    }
    
    public boolean start() {
        System.out.println("Wlcome!");
        System.out.println("Are you a new user or current user?");
        System.out.println("input N(for new user) or C(for current user)");
        while (true) {
            char input = sc.next().charAt(0);
            if (input == 'N' || input == 'n') {
                return true;
            }
            if (input == 'C' || input == 'c') {
                return false;
            } else {
                System.out.println("Invalid input, try again");
                System.out.println();
            }
        }
    }
    
    public void createuserP() {
        clearscreen();
        User temp = new User();
        String acc = String.format("%04d", userData.size() + 1);
        temp.bankAccountNumber = acc;
        System.out.println("Your new account number is " + acc);
        while (true) {
            System.out.println("Please enter your password");
            String input1 = sc.next();
            System.out.println("Please enter your password again");
            String input2 = sc.next();
            if (input1.equals(input2)) {
                createuser(temp,acc,input1);
                return;
            }
        }
    }
    
    public void createuser(User u,String acc,String pw) {
        userData.put(u, pw);
        accountbalance.put(acc, 0.0);
        transactions.put(acc, new Stack<String>());
        System.out.println("Your account is set up!");
        System.out.println("You can login by account number now, or by phone number only after finishing your profile details at a counter");
        return;
    }
    
    public User acclogin(String acc, String pw) {
        for (User u : userData.keySet()) {            
            if (u.bankAccountNumber.equals(acc) && userData.get(u).equals(pw)) { // "userData should store USER, PASSWORD" make it hard                
                return u;
            }
        }
        return null;
    }
    
    public User phonelogin(String ph, String pw) {
        for (User u : userData.keySet()) {
            if (u.phoneNumber.equals(ph) && userData.get(u).equals(pw)) {
                return u;
            }
        }
        return null;
    }
    
    public User loginP() {
        boolean in = false;        
        User temp = new User();
        while (!in) {
            System.out.println("Please choose login method");
            System.out.println("input A(for by account number) or P(for by phone number)");
            System.out.println("input F if you forgot your password");
            char input = sc.next().charAt(0);
            if (input == 'A' || input == 'a') {
                System.out.println("Please enter your account number");
                String acc = sc.next();
                System.out.println("Please enter your password");
                String pw = sc.next();
                if (!acclogin(acc,pw).equals(null)) {
                    return acclogin(acc,pw);
                }
                System.out.println("Invalid combination");
                continue;
            }
            if (input == 'P' || input == 'p') {
                System.out.println("Please enter your phone number");
                String ph = sc.next();
                System.out.println("Please enter your password");
                String pw = sc.next();
                if (!phonelogin(ph,pw).equals(null)) {
                    return phonelogin(ph,pw);
                }
                System.out.println("Invalid combination");
                continue;
            }
            if (input == 'F' || input == 'f') {
                resetpwP();
            } else
                System.out.println("Invalid input, try again");
        }
        return temp;
    }
    
    public User resetpwValidate(String ph,String name, String age) {
        for (User u : userData.keySet()) {
            if (u.phoneNumber.equals(ph)) {
                if ( u.name.equals(name) && u.age == Integer.parseInt(age)) {
                    return u;
                }
            }            
        }        
        return null;
    }    
   
    
    public void changepw(User u, String npw) {
        userData.replace(u, npw);
        System.out.println("Your password is changed!");
        return;
    }
    
    public void resetpwP() {
        clearscreen();
        User temp = new User();
        while (true) {
            System.out.println("Please enter your phone number");
            String ph = sc.next();
            System.out.println("Please enter your name");
            String name = sc.next();
            System.out.println("Please enter your age");
            String age = sc.next();
            if (!resetpwValidate(ph,name,age).equals(null)) {
                temp=resetpwValidate(ph,name,age);
                break;            
            }
        }
        while (true) {
            System.out.println("Please enter your new password");
            String input1 = sc.next();
            System.out.println("Please enter your new password again");
            String input2 = sc.next();
            if (input1.equals(input2)) {
                changepw(temp,input1);
                break;
            }
        }
    }
    
    public void changepwP(User u) {
        clearscreen();
        while (true) {
            System.out.println("Please enter your new password");
            String input1 = sc.next();
            System.out.println("Please enter your new password again");
            String input2 = sc.next();
            if (input1.equals(input2)) {
                changepw(u,input1);
                break;
            }
        }
    }
    
    public double printBalance(User u) {
        String acc = u.bankAccountNumber;
        double b = accountbalance.get(acc);
        clearscreen();
        System.out.println(u.name + " your available balance is " + b);
        System.out.println("press ENTER to continue");
        System.out.println();
        sc.nextLine();
        
        return b;
    }
    
    public int printTransactions(User u) {        
        Stack<String> l = new Stack<>();
        int n=0;
        if (!transactions.get(u.bankAccountNumber).isEmpty()) {
            l.addAll(transactions.get(u.bankAccountNumber));
            n = Math.max(10, l.size());        
            for (int i = 0; i < n; i++) {
                System.out.println(l.pop());
            }            
        }        
        System.out.println();
        System.out.println("press ENTER to continue");
        System.out.println();
        sc.nextLine();
        return n;
    }
    
    public boolean deposit(User u, double d) {
        double b = accountbalance.get(u.bankAccountNumber);
        StringBuilder sb = new StringBuilder("deposit - ");
        accountbalance.replace(u.bankAccountNumber, b + d - transactionFee);
        availableAmountInMachine += d;
        sb.append(d);
        transactions.get(u.bankAccountNumber).push(sb.toString());
        b = accountbalance.get(u.bankAccountNumber);
        System.out.println("Your deposit is done, transaction fee of " + transactionFee + " is applied");
        System.out.println(u.name + " your available balance is " + b);
        System.out.println();
        return true;
    }
    
    public void depositP(User u) {       
        double b = accountbalance.get(u.bankAccountNumber);
        while (true) {
            clearscreen();
            System.out.println(u.name + ", your available balance is " + b);
            System.out.println("Please input the amount to deposit");
            double d = Double.parseDouble(sc.next());
            if (d<=0.0) {
                System.out.println("Please input a valid positive amount");
                continue;
                }
            if(deposit(u,d))break;
            }
            System.out.println("press ENTER to continue");
            sc.nextLine();
            return;      
    }
    
    public boolean withDrawal(User u,double w) {
        String acc = u.bankAccountNumber;
        double b = accountbalance.get(acc);
        StringBuilder sb = new StringBuilder("withDrawal - ");
        if (w > b - transactionFee) {
            System.out.println(
                    "Sorry, that (plus the transaction fee) exceeded the available amount in your account");
            return false;
        }
        accountbalance.replace(acc, b - w - transactionFee);
        availableAmountInMachine -= w;
        sb.append(w);
        transactions.get(acc).push(sb.toString());
        b = accountbalance.get(acc);
        System.out.println("Your withdrawal is done, transaction fee of " + transactionFee + " is applied");
        System.out.println(u.name + " your available balance is " + b);
        System.out.println();        
        return true;
    }
    
    public void withDrawalP(User u) {
        String acc = userData.get(u);
        double b = accountbalance.get(acc);
        double w = 0.0;
        while (true) {
            clearscreen();
            System.out.println(u.name + ", your available balance is " + b);
            System.out.println("Please input the amount to withdraw");
            w = Double.parseDouble(sc.next());
            if (w<=0.0) {
                System.out.println("Please input a valid positive amount");
                continue;
            }
            if (w > availableAmountInMachine) {
                System.out.println("Sorry, that exceeded the available amount in this machine");
                continue;
            }
            if (withDrawal(u,w)) break;
        }        
        System.out.println("press ENTER to continue");
        sc.nextLine();
        return;
    }
    
    public void desktop(User u) {
        while (true) {
            clearscreen();
            System.out.println("Hello, " + u.name + ", please choose the activity you want");
            System.out.println("input A(for available balance), T(for recent transactions)");
            System.out.println("input W(for withdraw), D(for deposit)");
            System.out.println("input C(for change password), E(for exit)");
            char input = sc.next().charAt(0);
            if (input == 'A' || input == 'a')
                printBalance(u);
            if (input == 'T' || input == 't')
                printTransactions(u);
            if (input == 'W' || input == 'w')
                withDrawalP(u);
            if (input == 'D' || input == 'd')
                depositP(u);
            if (input == 'C' || input == 'c')
                changepwP(u);
            if (input == 'E' || input == 'e') {
                //sc.close();
                return;
            }
        }
    }
    
    public void run() {
        while (true) {
            boolean isnew = start();
            if (isnew)
                createuserP();
            User cur = loginP();
            desktop(cur);
            
        }
    }

}
