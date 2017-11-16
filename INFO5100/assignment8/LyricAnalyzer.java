package assignment8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LyricAnalyzer {
    
    private HashMap<String, ArrayList<Integer>> map;
    
    public LyricAnalyzer(){
        this.map=new HashMap<String, ArrayList<Integer>>();
    }
    
    public void read(File file) throws IOException{
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        int pos=1;
        String line;
        while ((line=br.readLine())!=null){
            //if (br.readLine()==null) break;
            String[] words=line.toUpperCase().split(" ");            
            for (int i=0;i<words.length;++i){
                if(i==words.length-1){
                    add(words[i],-pos);
                }
                else add(words[i],pos);
                ++pos;
            }  
        }
        br.close();
        fr.close();
    }
    
    private void add(String lyricWord, int wordPosition){        
        if (map.containsKey(lyricWord)){
            map.get(lyricWord).add(wordPosition);
        }
        else {
            ArrayList<Integer> pos=new ArrayList<>();
            pos.add(wordPosition);
            map.put(lyricWord, pos);
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
            String list=map.get(s).toString();
            sb.append(list.substring(1, list.length()-1));
            System.out.println(sb.toString());
        }
        System.out.println();
    }
    
    public void writeLyrics(File file) throws IOException{
        int num=0;
        for (ArrayList<Integer> a:map.values()) {
            num+=a.size();
        }
        String[] words=new String[num+1];
        Arrays.fill(words,"");
        for (String s:map.keySet()) {
            for (Integer i: map.get(s)) {
                if (i<0) {
                    words[-i]=s.toUpperCase()+" "+System.lineSeparator();
                }
                else words[i]=s.toUpperCase()+" ";
            }
        }
        FileWriter writer = new FileWriter(file);
        PrintWriter pw = new PrintWriter(writer);
        for (int i=1;i<words.length;++i) {
            pw.print(words[i]);
        }
        pw.close();
        writer.close();
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
        LyricAnalyzer la=new LyricAnalyzer();
        try {
            la.read(new File("q2t3.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(la.count()+" unique words in the lyric");
        System.out.println(la.mostFrequentWord()+" is the most frequent");
        System.out.println();
        la.displayWords();
        File nfile=new File("newlyrics.txt");
        try {
            la.writeLyrics(nfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    

}
