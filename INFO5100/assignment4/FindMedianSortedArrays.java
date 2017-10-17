package assignment4;

import java.util.Arrays;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length==0) return FindMedian(nums2);
        if (nums2.length==0) return FindMedian(nums1);
        
        int[] l=nums1;
        int[] s=nums2;        
        if (nums1.length<nums2.length) {
            l=nums2;
            s=nums1;
        }
        
    }
    
    static double FindMedian(int[] arr) {
        if (arr.length==0) return Double.NaN;        
        if (arr.length%2==0) return (arr[(arr.length/2)-1]+arr[arr.length/2])/2.0;
        if (arr.length%2==1) return arr[(arr.length-1)/2];
        return Double.NaN;
    }
    
    static int FindMedianIndex(int[] arr) {        
        if (arr.length==0) return -1;        
        if (arr.length%2==0) return arr.length/2;
        if (arr.length%2==1) return (arr.length-1)/2;
        return -1;
    }

}
