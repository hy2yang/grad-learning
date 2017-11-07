package assignment7;

public class PrintPascalTriangle {
    
    public static void printPascalTriangle(int n){
        if (n<1) return;
        int[] dp=new int[n];
        int x;
        for (int i=0;i<n;++i) {
            for (int j=i;j>=0;--j) {         // reverse to avoid update a value with a already updated one
                if (j==0 || j==i) x=1;
                else x=dp[j-1]+dp[j];
                dp[j]=x;
                System.out.print(x+" ");
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        printPascalTriangle(10);
    }

}
