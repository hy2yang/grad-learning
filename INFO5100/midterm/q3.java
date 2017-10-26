package midterm;

public class q3 {
    
    public static void main(String[] args) {
        int[] a= {1,2,3,3};
        System.out.println(minMoves(a));
    }
    
    public static int minMoves(int[] nums) {
        if (nums.length<2) return 0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<nums.length;++i) {
            sum+=nums[i];
            min=Math.min(min, nums[i]);            
        }
        return sum-min*nums.length;
        // suppose there are n numbers in array, the minimum among array is i
        // i must be added in every move, if not, there will be a number > i, which is not finished and will take more moves
        // so in the minimum moves strategy, after all x moves, each number equals x+i
        // total number added to the array is (n-1)*x
        // sum(nums)+(n-1)*x == (x+i)*n -> two ways to calculate final sum of array should equal
        // so x=sum(nums)-i*n
    }

}
