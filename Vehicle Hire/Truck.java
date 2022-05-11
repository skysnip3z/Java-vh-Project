import java.util.Scanner;
import java.util.ArrayList;
/**
 * Truck class to enable the use of Truck objects.
 */
public class Truck extends Commercial
{
    // Unique fields for Trucks only.
    private ArrayList<String> features;
        
    /**
    * Constructor for objects of class Van
    * 
    */    
    public Truck()
    {
        super(); // call to super class constructor
        features = new ArrayList<String>(); 
    }
    
    public void printDetails()
    {
        super.printDetails();
        System.out.printf("%-13s", "Features:");
        String line = 
        "-----------------------------------------------------------------------------";
        
        for (String s : features)
        {
            System.out.print(" \u2022" + s);
        }
        System.out.println();
        System.out.println(line);
    }
    
    public void readData(Scanner iScan)
    {        
        Scanner sScan = iScan;
        super.readData(sScan);
        
        while (sScan.hasNext())
        {
            String temp = sScan.next();
            features.add(temp);
        }
    }
}