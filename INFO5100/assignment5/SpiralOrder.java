package assignment5;

import java.util.*;

public class SpiralOrder {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> so=new ArrayList<>();
        if (matrix.length == 0) return so;
        int m=matrix.length-1;
        int n=matrix[0].length-1;
        int x=0;
        int y=0;
        while (x<=n-x && y<=m-y) {
            if (so.size()==(m+1)*(n+1)) return so;
            if (x==n-x && y<m-y) {
                for (int i=y;i<=m-y;i++) so.add(matrix[i][x]);
                break;
            }
            if (y==m-y && x<n-x) {
                for (int i=x;i<=n-x;i++) so.add(matrix[y][i]);
                break;
            }
            if (y==m-y && x==n-x) {
                so.add(matrix[x][y]);
                break;
            }
            if (x>n-x && y>m-y) break;
            
            for (int i=x;i<n-x;i++) so.add(matrix[y][i]);
            for (int i=y;i<m-y;i++) so.add(matrix[i][n-x]);
            for (int i=n-x;i>x;i--) so.add(matrix[m-y][i]);
            for (int i=m-y;i>y;i--) so.add(matrix[i][x]);
            x++;
            y++;            
        }
        return so;
    }   
    
} 
