package midterm;

import java.util.ArrayList;

class Cell{
    int x,y;
    Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "["+this.x +", "+this.y+ "]";
    }
}

public class q5 {
    
    public static ArrayList<Cell> findPath(int[][] maze){
        ArrayList<Cell> res=new ArrayList<>();
        if (maze.length==0 || maze[0].length==0) return res;
        ArrayList<Cell> wip=new ArrayList<>();
        wip.add(new Cell(0,0));
        q5helper(maze, res, wip);
        return res;
}
    
    static void q5helper(int[][] maze, ArrayList<Cell> res, ArrayList<Cell> wip) {   //backtrack, wip = work in process
        int x=wip.get(wip.size()-1).x;
        int y=wip.get(wip.size()-1).y;
        if (x==maze.length-1 && y==maze[0].length-1) {
            if (!res.isEmpty()) res.add(null);          // use null to seperate different routes
            res.addAll(wip);                                                                       
            return;
        }
        if ( (x<maze.length-1 && maze[x+1][y]==1) ) {   // can go down 
            wip.add(new Cell(x+1,y));
            q5helper(maze, res, wip);
            wip.remove(wip.size()-1);
        }
        
        if ( y<maze[0].length-1 && maze[x][y+1]==1 ) {  // can go right
            wip.add(new Cell(x,y+1));
            q5helper(maze, res, wip);
            wip.remove(wip.size()-1);
        }
    }
    
    public static void main(String[] args) {
        int[][] a= {{1,0,0,0},{1,1,1,1},{0,1,1,0},{1,1,1,1}};
        System.out.println(findPath(a));
    }
    
}
