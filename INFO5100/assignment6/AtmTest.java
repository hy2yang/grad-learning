package assignment6;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// only test the "backend" logic methods, not the "frontend" console write\flow\phase process method

//you need to hit ENTER in console during test
//you need to hit ENTER in console during test
//you need to hit ENTER in console during test

class AtmTest {
    Atm a=new Atm(5000,1);
    User tom=new User(26,"Tom","","1234567890","0001");
    User liz=new User(25,"Liz","","0123456789","0002");

    @BeforeEach
    void setUp() throws Exception {
        
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
    }

    @Test
    void testCreateuser() {
        User test=new User();
        test.bankAccountNumber="9999";
        a.createuser(test, test.bankAccountNumber, "testpw");
        assertEquals(a.userData.size(),3);
        assertEquals(a.userData.get(test),"testpw");
        assertEquals(a.accountbalance.get(test.bankAccountNumber),0.0,0.001);        
    }

    @Test
    void testAcclogin() {
        User x=a.acclogin("0001", "tompw");
        User y=a.acclogin("0002", "lizpw");
        User z1=a.acclogin("0001", "wrongpw");  //wrong pw
        User z2=a.acclogin("0003", "tompw");    //wrong acc
        User z3=a.acclogin("0003", "wrongpw");  //both
        assertEquals(x,tom);
        assertEquals(y,liz);
        assertEquals(z1,null);
        assertEquals(z2,null);
        assertEquals(z3,null);
    }

    @Test
    void testPhonelogin() {
        User x=a.phonelogin("1234567890", "tompw");
        User y=a.phonelogin("0123456789", "lizpw");
        User z1=a.phonelogin("0001232345", "tompw");  //wrong phone
        User z2=a.phonelogin("1234567890", "wrongpw"); //wrong pw
        User z3=a.phonelogin("198195431", "wrongpw");  //both
        assertEquals(x,tom);
        assertEquals(y,liz);
        assertEquals(z1,null);
        assertEquals(z2,null);
        assertEquals(z3,null);
    }

    @Test
    void testResetpwValidate() {
        User x=a.resetpwValidate("1234567890", "Tom", "26");
        User y=a.resetpwValidate("0123456789", "Liz", "25");
        User z1=a.resetpwValidate("0123456789", "Liz", "26");  //wrong age
        User z2=a.resetpwValidate("0123456789", "Lisa", "25"); //wrong name
        User z3=a.resetpwValidate("123456789", "Liz", "25");  // wrong number
        User z4=a.resetpwValidate("123456789", "Lisa", "25");  //correct age only
        User z5=a.resetpwValidate("123456789", "Liz", "26");  //correct name only
        User z6=a.resetpwValidate("0123456789", "Lisa", "26");  //correct number only
        assertEquals(x,tom);
        assertEquals(y,liz);
        assertEquals(z1,null);
        assertEquals(z2,null);
        assertEquals(z3,null);
        assertEquals(z4,null);
        assertEquals(z5,null);
        assertEquals(z6,null);
    }

    @Test
    void testChangepw() {
        a.changepw(liz, "liznewpw");
        a.changepw(tom, "tomnewpw");
        assertEquals(a.userData.get(tom),"tomnewpw");
        assertEquals(a.userData.get(liz),"liznewpw");
    }

    @Test
    void testPrintBalance() {
        assertEquals(a.printBalance(tom),3942.68,0.01);
        assertEquals(a.printBalance(liz),(8751.24-10*a.transactionFee),0.01); // Liz has done 10 transactions 
    }

    @Test
    void testPrintTransactions() {
        assertEquals(a.printTransactions(liz),10);
        assertEquals(a.printTransactions(tom),0);
    }

    @Test
    void testDeposit() {
        a.deposit(tom, 300);
        assertEquals(a.accountbalance.get(tom.bankAccountNumber),(3942.68+299),0.01);
        assertEquals(a.availableAmountInMachine, 5300.0, 0.01);
    }

    @Test
    void testWithDrawal() {
        a.withDrawal(liz, 300);
        double current=a.accountbalance.get(liz.bankAccountNumber);
        assertEquals(current,(8751.24-10*a.transactionFee-301),0.01);
        a.withDrawal(liz, 10000);                                      //exceeeds account balance 
        current=a.accountbalance.get(liz.bankAccountNumber);           // for exceeding machine balance, the logic is before
        assertEquals(current,(8751.24-10*a.transactionFee-301),0.01);  // calling the withDrawl function, therefore no test here
    }

}
