import java.util.Scanner;
/**
 * Commercial abstract class to extend for the use of other objects.
 */
public abstract class Commercial extends Vehicle
{
    // Unique field for commercial vehicles only.
    private int payload;
        
    /**
    * Constructor for objects of class Car
    * 
    */    
    public Commercial()
    {
        super(); // call to super class constructor
        payload = 0; 
    }
    
    // Accessors for the fields.
    public int getPayload()
    {
        return payload;
    }
     
    public void printDetails()
    {
        super.printDetails();       
        System.out.printf("%-37s \n", "Payload (kg): " + payload);
    }    
    
    public void readData(Scanner iScan)
    {        
        Scanner sScan = iScan;
        super.readData(sScan);
        payload = sScan.nextInt();
    }    
}