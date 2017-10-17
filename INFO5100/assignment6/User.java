package assignment6;

public class User {    
    public String name, address, phoneNumber, bankAccountNumber;
    public int age;  
    
    public User() {}
    public User(int age, String name,String address,String phoneNumber,String bankAccountNumber) {
        this.age=age;
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.bankAccountNumber=bankAccountNumber;            
    }

}
