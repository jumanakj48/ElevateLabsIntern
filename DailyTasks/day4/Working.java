package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Working {
    public static void main(String[] args) throws IOException {
        File f1 = new File("day4/test.txt");

        if (f1.createNewFile()) {
            System.out.println("File created..");
        } 

        try {
            FileWriter writer = new FileWriter(f1);
            writer.write("Writing to the test.txt file...");
            System.out.println("Successfully written to file test.txt");
            writer.close();
        } 
        catch (Exception e) {
            System.err.println("An error has occured while writing to the file test.txt");
            System.out.println(e.getMessage());
            return;
        }   

        try {
            BufferedReader br = new BufferedReader(new FileReader(f1));
            
            System.out.print("Reading file content:\n\t");
            String line;    
          	
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            
            }
          
            br.close();
        }
        
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

    }
}
