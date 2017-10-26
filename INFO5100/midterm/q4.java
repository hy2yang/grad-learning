package midterm;

public class q4 {
    
    public static int countNumberOfPossibleWays(int m, int n, int x) {
        //if (m<4) return 0;  minimum faces of a dice in real world is 4, should this be considered?
        if (n<1) return 0;           // can't play without dice
        if (n>x || n*m<x) return 0;  // x too small/large
        if (n==1 && x<=m) return 1;  // one dice can get any <= m
        int sum=0;
        for (int i=1;i<=m;++i) {
            sum+=countNumberOfPossibleWays(m,n-1,x-i);  // sum all possible situations with 1 less dice
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(countNumberOfPossibleWays(6,3,4));
        System.out.println(countNumberOfPossibleWays(2,2,3));
        System.out.println(countNumberOfPossibleWays(12,2,15));
    }
    

}
