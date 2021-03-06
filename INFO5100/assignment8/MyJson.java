package assignment8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;

public class MyJson {
    
    private static ArrayList<Vehicle> readAndGetVehicles(File file) throws IOException{
        ArrayList<Vehicle> cars=new ArrayList<>();
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        String line=br.readLine();
        while(true){
            line=br.readLine();
            if(line==null) break;            
            Vehicle cur=new Vehicle(line.split("~"));
            cars.add(cur);
        }
        br.close();
        fr.close();
        return cars;
    }
    
    public static String getJsonString(ArrayList<Vehicle> vehicles){
        String nl=System.lineSeparator();
        StringBuilder sb=new StringBuilder("{"+nl);
        sb.append("\""+vehicles.get(0).webId+"\" : ["+nl);
        for(int i=0;i<vehicles.size();++i){
            sb.append("{"+nl);
            sb.append(vehicle2Json(vehicles.get(i)));
            if(i<vehicles.size()-1) sb.append("},"+nl);
            else sb.append("}"+nl);
        }
        sb.append("]"+nl);
        sb.append("}"+nl);
        
        return sb.toString();
    }
    
    private static String vehicle2Json(Vehicle c){
        String nl=System.lineSeparator();
        StringBuilder sb=new StringBuilder();
        
        sb.append("\"id\" : \""+c.id+"\","+nl);
        sb.append("\"category\" : \""+c.category+"\","+nl);
        sb.append("\"year\" : \""+c.year+"\","+nl);
        sb.append("\"make\" : \""+c.make+"\","+nl);
        sb.append("\"model\" : \""+c.model+"\","+nl);
        sb.append("\"trim\" : \""+c.trim+"\","+nl);
        if (c.type.isEmpty()) sb.append("\"type\" : null,"+nl);
        else sb.append("\"type\" : \""+c.type+"\","+nl);
        sb.append("\"price\" : "+c.price+","+nl);
        sb.append("\"photo\" : \""+c.photo+"\","+nl);
        return sb.toString();
    }
    
    public static void writeToFile(String inputToWrite, String filePath) throws IOException{
        File res=new File(filePath+"/res.txt");
        res.createNewFile();
        FileWriter fw=new FileWriter(res);
        fw.write(inputToWrite);
        fw.close();
    }   
    
    
    public static void main(String[] args) throws IOException{  
        File file = new File("assignment8/q3.txt");
        ArrayList<Vehicle> vehicles = readAndGetVehicles(file);
        String s = getJsonString(vehicles);
        writeToFile(s, file.getParent());
        back2original(new File("assignment8/res.txt"));
        
    }
    
    public static void back2original(File file) throws IOException{   //extra, defects in price section and when type==null
        File back=new File(file.getParent()+"/back.txt");
        
        FileReader fr=new FileReader(file);        
        BufferedReader br=new BufferedReader(fr);
        
        FileWriter fw = new FileWriter(back);
        PrintWriter pw = new PrintWriter(fw);
        
        StringBuilder sb=new StringBuilder();
        
        pw.println("id~webId~category~year~make~model~trim~type~price~photo");
        String in=br.readLine();
        String webid=br.readLine().split("\"")[1];
        
        while (true){
            in=br.readLine();
            if (in==null) break;
            if (in.contains("{")) {                
                for (int i=0;i<10;++i) {
                    if (i==1) sb.append(webid);
                    else {
                        String[] line=br.readLine().split("\"");
                        if (line.length>3) sb.append(line[3]);
                        else sb.append(line[2]);
                    }
                    if (i<9) sb.append("~");
                }
                continue;
            }
            if (in.contains("}")) {
                pw.println(sb.toString());
                sb.setLength(0);
                continue;
            }            
        }
        br.close();
        pw.close();   
    }

}

class Vehicle{

    String id;
    String webId;
    Category category;
    Year year;
    String make;
    String model;
    String trim;
    String type;
    double price;
    URL photo;

    Vehicle(String[] arr){
        this.id = arr[0];
        this.webId = arr[1];
        this.category = Category.getCategory(arr[2].toLowerCase());
        this.year = Year.parse(arr[3]);
        this.make = arr[4];
        this.model = arr[5];
        this.trim = arr[6];
        this.type = arr[7];
        this.price = Double.parseDouble(arr[8]);
        try {
            this.photo = new URL(arr[9]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}

enum Category{
    NEW , USED, CERTIFIED;

    public static Category getCategory(String cat){
       switch (cat){
           case "used": return USED;
           case "new": return NEW;
           case "certified": return CERTIFIED;
           default: throw new IllegalArgumentException();
       }
    }

    @Override
    public String toString() {
        switch (this){
            case NEW: return "NEW";
            case USED: return "USED";
            case CERTIFIED: return "CERTIFIED";
            default: throw new IllegalArgumentException();
        }
    }
}
