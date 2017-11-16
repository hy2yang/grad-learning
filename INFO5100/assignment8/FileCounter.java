package assignment8;

import java.io.IOException;
import java.util.Scanner;

public class FileCounter {
    
    private int characterCount, wordCount, lineCount;
    
    public FileCounter(){  
        characterCount=0;
        wordCount=0;
        lineCount=0;
    }

    /**
       Processes an input source and adds its character, word, and line
       counts to the respective variables.
       @param in the scanner to process
    */
    void read(Scanner in) throws IOException {
        StringBuilder sb=new StringBuilder();
        while (in.hasNextLine()){
            String line=in.nextLine();                        
            sb.append(line);
            ++lineCount;
            wordCount+=line.split(" ").length;
            characterCount+=line.length();
        }
        //in.close();
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getLineCount() {
        return lineCount;
    }

}
