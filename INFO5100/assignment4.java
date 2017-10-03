
public class assignment4 {

    public static void main(String[] args) {
        System.out.println(toLicenseKey("2-4-A0r7-4k",4));

    }
    
    static String toLicenseKey(String input, int k) {
        char[] copy=input.toCharArray();
        StringBuilder key=new StringBuilder();
        int i=input.length()-1;
        while(i>=0) {
            if (copy[i]=='-') {
                i--;
                continue;
            }
            if (copy[i]>96) {
                key.append((char)(copy[i]-32));
                i--;
                continue;
            }
            key.append(copy[i]);
            i--;            
        }        
        i=k;
        while (i<key.length()) {
            key.insert(i, '-');
            i+=(k+1);
        }
        key.reverse();        
        return key.toString();        
    }
    
    
}
