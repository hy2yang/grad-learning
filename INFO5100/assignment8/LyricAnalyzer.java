package assignment8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LyricAnalyzer {
    
    private HashMap<String, ArrayList<Integer>> map;
    
    public LyricAnalyzer(){
        this.map=new HashMap<String, ArrayList<Integer>>();
    }
    
    public void read(File file) throws IOException{
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        int pos=0;
        while (true){
            String[] line=br.readLine().split(" ");
            for (int i=0;i<line.length;++i){
                if(i==line.length-1){
                    add(line[i],-pos);
                }
                else add(line[i],pos);
                ++pos;
            }
            
            
        }
    }
    
    private void add(String lyricWord, int wordPosition){        
        if (map.containsKey(lyricWord)){
            map.get(lyricWord).add(wordPosition);
        }
        else {
            map.put(lyricWord, new ArrayList<Integer>(wordPosition));
        }
    }
    
    public void displayWords(){
        String[] w=new String[map.size()];
        map.keySet().toArray(w);
        Arrays.sort(w);        
        for (String s:w){
            StringBuilder sb=new StringBuilder();
            sb.append(s);
            sb.append(": ");
            sb.append(map.get(s));
            System.out.println(sb.toString());
        }
        System.out.println();
    }
    
    public void writeLyrics(File file){
        
    }
    
    public int count(){
        return map.size();
    }
    
    public String mostFrequentWord(){
        int count=0;
        String res="";
        for(String s:map.keySet()){
            if (map.get(s).size()>count){
                count=map.get(s).size();
                res=s;
            }            
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
    
    

}
