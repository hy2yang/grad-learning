package midterm;

public class q2 {
    public static void main(String[] args) {
        for (int i=-10;i<29;i++) {
            System.out.println(arrangeCoins(i));
        }
        
    }
    
    public static int arrangeCoins(int n) {
        int i=1;
        int res=0;
        while (n>=i) {
            n-=i;
            ++res;
            ++i;
        }
        return res;
    }

}
