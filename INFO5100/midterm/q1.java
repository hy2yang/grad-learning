package midterm;

public class q1 {
    
    public static void main(String[] args) {
        int[] a= {9,4,8,7,5,1,3};
        int[] b= {6,4,1,0,3,2};
        int[] c= {1};
        for (int i: reverseEvenIndices(a)) {
            System.out.print(i+", ");
        }
        System.out.println();
        for (int i: reverseEvenIndices(b)) {
            System.out.print(i+", ");
        }
        System.out.println();
        for (int i: reverseEvenIndices(c)) {
            System.out.print(i+", ");
        }
        System.out.println();

    }
    
    public static int[] reverseEvenIndices(int[] nums) {
        if (nums.length<3) return nums;
        int lo=0;
        int hi= (nums.length-1)%2==0? nums.length-1:nums.length-2;
        while (lo<hi) {
            int temp=nums[lo];
            nums[lo]=nums[hi];
            nums[hi]=temp;
            lo+=2;
            hi-=2;
        }
        return nums;
    }

}
