package todo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class File {
    
    String fileName = "groceries.txt";
    String line = null;
    
    
    public ArrayList<String> readFile() {
        
        ArrayList<String> lines = new ArrayList<>();
 
        try {
            FileReader fileReader = new FileReader(fileName);  
            
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while((line = bufferedReader.readLine()) != null) {
                    //System.out.println(line);
                    lines.add(line);
                }
            }
        }
        catch(FileNotFoundException ex)
        {
            // System.out.println("Unable to open file: " + fileName);
            // return lines;
        }
        catch(IOException ex)
        {
            System.out.println("Error Writing to file: " + fileName);
        }
        
        return lines;
        
    }
    
    
    public void writeFile(ArrayList<String> lines) {
        
        try {
            //FileWriter fileWriter = new FileWriter(fileName, true);  //true means append to file. Don't overwrite. 
            FileWriter fileWriter = new FileWriter(fileName, false);
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                //bufferedWriter.write(line);
                //bufferedWriter.newLine();
                
                for(int i=0; i<lines.size(); i++){
                    bufferedWriter.write(lines.get(i));
                    bufferedWriter.newLine();
                }
                
                //close the file                
                bufferedWriter.close();
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file: " + fileName);
        }
        catch(IOException ex)
        {
            System.out.println("Error Writing to file: " + fileName);
        }
    }

}
