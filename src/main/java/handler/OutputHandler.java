package handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class OutputHandler {

    Path sampleCSV, outputCSV, outputTXT;
    
    public OutputHandler(String sampleCSV, String outputCSV, String outputTXT)
    {
    	this.sampleCSV = Paths.get(sampleCSV);
    	this.outputTXT = Paths.get(outputTXT);
    	this.outputCSV = Paths.get(outputCSV);
    }
    
    public ArrayList<String> TranslateFileData()
    {
        BufferedReader br;
        ArrayList<String> fileInput = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(sampleCSV.toFile()));
            String line = br.readLine();
            while (line != null) {
                line = br.readLine();
                fileInput.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileInput;
    }
    
    public void generateTXT(ArrayList<String> alerts) throws IOException {
    	FileWriter fw = new FileWriter(outputTXT.toString());
    	for(String line: alerts) {
    		fw.write(line+"\n");
    	}
    	fw.close();
    }
    
    public void generateOutput(ArrayList<String> alert) throws IOException {
    	FileWriter fw = new FileWriter(outputCSV.toString());
    	String nav = "RESERVATION NAME, FLIGHT NUMBER, SEAT CATEGORY, NUMBER OF SEATS RESERVED, FINAL PRICE";
    	fw.write(nav+"\n");
    	for(String line: alert) {
    		fw.write(line+"\n");
    	}
    	fw.close();
    }

}