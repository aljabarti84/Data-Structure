
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
/**
 * This program demonstrates how to write characters to a text file using
 * a specified charset.
 
 *
 */
public class demoDataGenerator {
 
	public static void readFile(String fileName) {
		try {
    		File f = new File(fileName);
        	FileReader fr = new FileReader(f);
        	BufferedReader br  = new BufferedReader(fr);

        	String s = (br.readLine());

        	while (s!=null) {
        		System.out.println(s);
        		s = br.readLine();
        	}
        	fr.close();
        	br.close();
    	}
    	catch(Exception i) {
    		System.out.println("File not found");	
    	}
	}
	
	
	public static void writeFile(String fileName, int nos) {
    	try {
        	File f = new File(fileName);
        	FileWriter fw = new FileWriter(f, true);
        	BufferedWriter br  = new BufferedWriter(fw);

        	/*Generating demo records*/
        	List<String> arr =  new ArrayList<>();
        	for(int i=1 ; i<=nos ; i++) {
        										    
        		arr.add(i+",Shirt"+i+",brandXYZ"+i+",$"+i+"\n");
        	}
        
        	Collections.shuffle(arr); /*shuffling records in array*/
        	
        	/*Reading in the file*/
        	for(int i=0 ; i<nos ; i++) {
        		br.write(arr.get(i));
        	}        	
        	br.close();
        	fw.close();
    	}
    	catch(Exception i) {
    		System.out.println(i.getMessage());
    	}
    
	}
	
    public static void main(String[] args){
  
//    	readFile("customerData.txt");
    	writeFile("stockData.txt" , 500);
    
    }       
}