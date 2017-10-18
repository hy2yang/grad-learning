import java.util.Arrays;

public class assignment3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(removeVowelsFromString("abcdefgHIJKLMN"));
        System.out.println(checkIfTwoStringsAreAnagrams("rail safety", "fairy tales"));
        System.out.println(checkIfTwoStringsAreAnagrams("Lives", "Elvis"));
        calculator c1=new calculator(); 
        c1.solveQuadratic(1, 0, -49);
    }

// Another issue is constructor duplication
//1. error in "public setName": if it's to set name, it should be void and set this.name=name;
//   if it's a constructor with only name argument, the method name should be Book and set this.name=name;
//   if it's to get name of a book, it should be string and return this.name
    
// Issue is missing return type
//2. in both methods the "time" can not be reolved since the code did not specify, should be this.time
    
    //3.
    static String removeVowelsFromString(String input) {
        String Vowels="aeiouAEIOU";
        String result="";
        for (int i=0;i<input.length();i++) {
            if (input.charAt(i)==' ') continue;
            if (Vowels.indexOf(input.charAt(i))<0) result+=input.charAt(i);
        }
        return result;    
    }
    
    //4.
    static boolean checkIfTwoStringsAreAnagrams(String s1, String s2) {
        // Please search the difference between "==" and ".equals()"
        if (s1==s2) return false;
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (char c:c1) {
            // Consider test case "aaacc" and "aaccc" they are not anagrams but will pass your check
            if (s2.indexOf(c)<0) return false;
        }
        return true;
    }
    
    //5.
    static class calculator{
        private double result;
        
        public calculator() {
        }
        
        private void print() {
            System.out.println("result is"+result);  
        }
        
        //i
        public double addition(double n1, double n2) {
            this.result=n1+n2;
            this.print();
            return this.result;
        }
        
        public double addition(double n1) {
            this.result+=n1;
            this.print();
            return this.result;
        }
        
        public double subtraction(double n1, double n2) {
            this.result=n1-n2;
            this.print();
            return this.result;
        }
        
        public double subtraction(double n1) {
            this.result-=n1;
            this.print();
            return this.result;
        }
        
        public double multiplication(double n1, double n2) {
            this.result=n1*n2;
            this.print();
            return this.result;
        }
        
        public double multiplication(double n1) {
            this.result*=n1;
            this.print();
            return this.result;
        }
        
        public double division(double n1, double n2) {
            this.result=n1/n2;
            this.print();
            return this.result;
        }
        
        public double division(double n1) {
            this.result/=n1;
            this.print();
            return this.result;
        }
        
        //ii
        public double squareroot(double n1) {
            this.result=Math.sqrt(n1);
            this.print();
            return this.result;
        }
        
        public double square(double n1) {
            this.result=n1*n1;
            this.print();
            return this.result;
        }
        
        public double cube(double n1) {
            this.result=n1*n1*n1;
            this.print();
            return this.result;
        }
        
        //iii
        public double FtoC(double n1) {
            this.result=(n1-32)*5/9;
            this.print();
            return this.result;
        }
        
        public double CtoF(double n1) {
            this.result=n1*9/5+32;
            this.print();
            return this.result;
        }
        
        public double feetToIches(double n1) {
            this.result=n1*12;
            this.print();
            return this.result;
        }
        
        public double inchesToFeet(double n1) {
            this.result=n1/12;
            this.print();
            return this.result;
        }
        
        // extra
        public double[] solveQuadratic(double a,double b,double c) {
            double[] result=new double[2];
            if (b*b-4*a*c<0) {
                System.out.println("no real root");
                return result;
            }
            double s=Math.sqrt(b*b-4*a*c);
            // What if a == 0?
            result[0]=(s-b)/(2*a);
            result[1]=(-s-b)/(2*a);
            System.out.println("roots are "+result[0]+" and "+result[1]);
            return result;
        }
        
        
    }
    
}
