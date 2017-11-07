package assignment7;

public class MaxValueThread extends Thread {
    
    private static int[] max= {Integer.MIN_VALUE};
    private int lo,hi,localmax;
    private int[] arr;
    
    public MaxValueThread(int[] arr, int lo, int hi) {
        this.arr=arr;
        this.lo=lo;
        this.hi=hi;
        this.localmax=Integer.MIN_VALUE;
    }
    
    @Override
    public void run() {
        while (lo<hi) {
            System.out.println(this.getName()+" scanning int "+ arr[lo]);
            if (arr[lo]>localmax) {
                synchronized (max) {
                    if (arr[lo]>max[0]) max[0]=arr[lo];
                    localmax=max[0];
                }
            }
            ++lo;
        }
    }
    
    
    public static int max(int threads, int[] arr) throws InterruptedException {
        int len=arr.length;
        MaxValueThread[] ts=new MaxValueThread[threads];
        for (int i=0;i<threads;++i) {
            ts[i]=new MaxValueThread(arr, (i * len) / threads, ((i + 1) * len / threads));
            ts[i].start();
        }  
        for (int i = 0; i < threads; i++) {
            ts[i].join();
        }
        for (int i = 0; i < threads; i++) {
            System.out.println(ts[i].getName()+" local max "+ ts[i].localmax);
        }
        return MaxValueThread.max[0];
        
    }  

    
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round(10000*Math.random());
        }
        long bt=System.currentTimeMillis();
        int max = max(4,arr);
        long et=System.currentTimeMillis();
        System.out.println("Searching time: "+(et-bt)+"ms");
        System.out.println("Max: " + max);
    }

}
