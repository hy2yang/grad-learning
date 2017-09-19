import java.util.HashMap;
import java.util.Map;

public class assignment2 {

	public static void main(String[] args) {
		System.out.println(employeeSalary(48));
		System.out.println(addDigits(376));
		printPerfectNumbers(497);
		printIsoscelesTriangle(6);
	}
	

/*1. Write a java function to calculate the salary of an employee based on the following rules.
i. function takes input of number of hours an employee worked and returns the salary.
ii.  The first 36 hours worked are paid at a rate of 15.0, 
then the next 5 hours are paid at a rate of 15 * 1.5. Hours after that up to a max of 48 are paid at a rate of 15 * 2.*/
		
	public static double employeeSalary(double hours){
	    if (hours <0 || hours >48) throw new IllegalArgumentException();
	    if (hours <=36) return hours*15;
	    if (hours>36){
	        if (hours-36 <=5) return 36*15+(hours-36)*15*1.5;
	        else return 36*15+5*15*1.5+(hours-41)*30;
	    }
	    return 0;
	}
	
/*2. Write a java function that adds all the digits of an integer until it is single digit.
i. function takes an integer as input and returns its sum of digits.
ii. for example input = 37, sum = 3+7 = 10, sum = 1+0 = 1. result = 1.*/

	public static int addDigits(int input){
	    int x=input;
	    while (x/10>0){
	        x=x/10+x%10;
	    }
	    return x;
	}	

/*3. Write a java function to print all perfect number between 1 and n.
i. Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
ii. For example: 6 is the first perfect number, Proper divisors of 6 are 1, 2, 3. Sum of its proper divisors = 1 + 2 + 3 = 6.*/
	
	public static void printPerfectNumbers(int n){
	    int sum=0;
	    int i=1;
	    do {
	        for (i=1;i<n;i++){
	            if (n%i ==0) sum+=i;
	        }	        
	        if (sum==n) System.out.print(n+" ");	
	        n--;
	        sum=0;
	    }while (n>1);
	    System.out.print(System.lineSeparator());
	}
	
/*	4. Write a java class called pizza with (Add detail as needed) : 
        i. Create atleast 3 attributes :pizza type , unit price and loyalty points. More attributes are welcome to have. 
        ii. Create constructors . Extra-credit of 0.5 point if you write more than 1 right constructor to this class*/
	public class pizza{
	    String pizza_type;
	    float price;
	    int loyalty_points;
	    
	    public pizza(String type, float p, int lp){
	        this.pizza_type=type;
	        this.price=p;
	        this.loyalty_points=lp;	        
	    }
	    
	    public pizza(String type, float p){
            this.pizza_type=type;
            this.price=p;
            this.loyalty_points=(int) (100*p);   // assume you loyalty points as 100 times the price of the pizza
        }
	    
	    public pizza(String type, int lp){
            this.pizza_type=type;
            this.price=(float) (lp/100.0);  // assume you loyalty points as 100 times the price of the pizza
            this.loyalty_points=lp;         
        }
	}

/*5. Write a java class called customer (Add detail as needed) : 
        i. Create Attributes: customer name and which pizzas customer has ordered. 
        ii. Think about what kind of data structure can be used to record the pizza name and number of each kind of pizza.( Give me your thought, Extra credit of 1 point)
        iii. In main method , sum up how much money the customer spent.*/
	public class customer{
	    String name;
	    Map<pizza, Integer> orders;
	    
	    public customer(String str){
	        this.name=str;
	        orders= new HashMap<pizza, Integer>();
	    }
	    
	    public float main() {
	        float sum=0;
	        for (pizza pizza : orders.keySet()) {
	            sum+=pizza.price*orders.get(pizza);
	        } 
	        return sum;
	    }
	    
	}


/*EXTRA CREDIT
6. Write a Java program that generates an isosceles right angled triangle made of asterisks. 
  i. function should take input of one equal side as integer. Other than the edges the inner part of the triangle should be empty.
  ii. For example input is 6. the function should print—
  
 *
 **
 * *
 *  *
 *   *
 ******

 Here is the prototype you can work with*/

  public static void printIsoscelesTriangle(int n){
      String a="*";
      System.out.println(a);
      String b="";
      for (int i=1;i<n-1;i++) {          
          System.out.println(a+b+a);
          b+=" ";
      }
      for (int i=0;i<n;i++) {
          System.out.print("*");
      }
      
  }
	
	    
	
}
