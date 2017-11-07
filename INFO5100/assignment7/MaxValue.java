package assignment7;

public class MaxValue extends Thread{ 

    private int max=Integer.MIN_VALUE;
    private int lo,hi;
    private int[] arr;
    
    public MaxValue(int[] arr, int lo, int hi) {
        this.arr=arr;
        this.lo=lo;
        this.hi=hi;
    }    

    @Override
    public void run() {
        while (lo<hi) {
            System.out.println(this.getName()+" scanning int "+ arr[lo]);
            if (arr[lo]>max) max=arr[lo];
            ++lo;
        }
    }
    
    
    public static int max(int[] arr) throws InterruptedException {
        int len=arr.length;
        int max=Integer.MIN_VALUE;
        MaxValue[] ts=new MaxValue[4];
        for (int i=0;i<4;++i) {
            ts[i]=new MaxValue(arr, (i * len) / 4, ((i + 1) * len / 4));
            ts[i].start();
        }
        for (int i = 0; i < 4; i++) {
            ts[i].join();
            max=Math.max(max, ts[i].max);
        }
        return max;
        
    }  

    
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round(1000*Math.random());
        }
        long bt=System.currentTimeMillis();
        int max = max(arr);
        long et=System.currentTimeMillis();
        System.out.println("Searching time: "+(et-bt)+"ms");
        System.out.println("Max: " + max);

    }

}

