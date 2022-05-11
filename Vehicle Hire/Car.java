import java.util.Scanner;
/**
 * Car class to enable the use of Car objects.
 */
public class Car extends Vehicle
{
    // Unique fields for cars only.
    private String bodyType;
    private int noOfDoors, noOfSeats;
        
    /**
    * Constructor for objects of class Car
    * 
    */    
    public Car()
    {
        super(); // call to super class constructor
        bodyType = null;
        noOfDoors = 0;
        noOfSeats = 0;
    }
    
    // Accessors for the fields.
    public String getbodyType()
    {
        return bodyType;
    }
    
    public int getNoD()
    {
        return noOfDoors;
    }
    
    public int getNoS()
    {
        return noOfSeats;
    }
    
    public void printDetails()
    {
        super.printDetails();
        String line = 
        "-----------------------------------------------------------------------------";
        System.out.printf("%-37s \n", "Body Type: " + bodyType);              
        System.out.printf("%-37s %-24s \n", "No Of doors: " + noOfDoors, 
        "No Of Seats: " + noOfSeats); 
        System.out.println(line);
    }
    
    public void readData(Scanner iScan)
    {        
        Scanner sScan = iScan;
        super.readData(sScan); 
        
        bodyType = sScan.next();
        noOfDoors = sScan.nextInt();
        noOfSeats = sScan.nextInt();                
    }
}