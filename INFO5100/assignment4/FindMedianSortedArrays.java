package assignment4;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a= {1};
        int[] b= {1};
        System.out.println(findMedianSortedArrays(a,b));
        

    }
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length==0) return FindMedian(nums2);
        if (nums2.length==0) return FindMedian(nums1);        
        
        // "stupid" brute way: combine 2 arrays, then find median
        int[] aux=new int[nums1.length+nums2.length];
        int i=0,j=0,a=0;
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i]<nums2[j]) {
                aux[a++]=nums1[i++];
            }
            else aux[a++]=nums2[j++];
        }
        if (i<nums1.length) {
            while (i<nums1.length) {
                aux[a++]=nums1[i++];
            }
        }
        if (j<nums2.length) {
            while (j<nums2.length) {
                aux[a++]=nums2[j++];
            }
        }
        return  FindMedian(aux);
    }
    
    static double FindMedian(int[] arr) {
        if (arr.length==0) return Double.NaN;        
        if (arr.length%2==0) return (arr[(arr.length/2)-1]+arr[arr.length/2])/2.0;
        if (arr.length%2==1) return arr[(arr.length-1)/2];
        return Double.NaN;
    }
    
}
 
