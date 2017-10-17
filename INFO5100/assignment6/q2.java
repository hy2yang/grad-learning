package assignment6;

import java.io.*;

public class q2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public static void parse(File file) throws IOException {
        RandomAccessFile input = null;
        String line = null;
        
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } finally {
              if (input != null) {
                input.close();
              }
          }
    }  

}
