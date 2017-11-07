package assignment7;

public class FindPartition {
    
    public boolean findPartition (int arr[]) {
        if (arr==null || arr.length==0) return true;
        int sum=0;
        for (int x: arr) {
            sum+=x;
        }
        if (sum%2==1) return false;
        sum/=2;
        //Arrays.sort(arr); no need to sort
        
        boolean[] dp=new boolean[1+sum];
        dp[0]=true;
        for (int i:arr) {
            for (int j=sum;j>=i;--j) {    // j from sum to i, if j<i -> current number>target sum, no help adding current number
                dp[j]= dp[j] || dp[j-i];  // so ignore current number and front part of dp[] needs no updating
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
