package assignment6;

public class MyIndexOutOfBoundException extends IndexOutOfBoundsException {
    
    /**
     * no idea about the serialVersionUID 
     */
    private static final long serialVersionUID = 1L;
    private int lb,ub,i;
    
    public MyIndexOutOfBoundException() {
        super();
    }
    
    public MyIndexOutOfBoundException(int low, int up, int cur) {
        this.lb=low;
        this.ub=up;
        this.i=cur;
    }
    
    public String toString() {
        StringBuilder sb=new StringBuilder("Error Message: Index: ");
        sb.append(i);
        sb.append(", but Lower bound: ");
        sb.append(lb);
        sb.append(", Upper bound: ");
        sb.append(ub);
        return sb.toString();
    }
    
/*    public static void main(String[] args) {
        throw new MyIndexOutOfBoundException(5,10,23);
        
    }
*/
}
