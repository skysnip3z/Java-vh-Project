import java.util.Scanner;
/**
 * Van class to enable the use of Van objects.
 */
public class Van extends Commercial
{
    // Unique fields for Vans only.
    private double loadVol; // in m3
    private boolean slideDoor;   
        
    /**
    * Constructor for objects of class Van
    * 
    */    
    public Van()
    {
        super(); // call to super class constructor
        loadVol = 0.0;
        slideDoor = false;
    }
    
    // Accessors for the fields.
    
    public double getLoadVol()
    {
        return loadVol;
    }
    
    public boolean getSlideDoor()
    {
        return slideDoor;
    }
    
    public void printDetails()
    {
        super.printDetails();
        String sDoor = "Sliding Side Doors: ";
        String line = 
        "-----------------------------------------------------------------------------";
                             
        System.out.printf("%-37s \n", "Load Volume (m3): " + loadVol);
        if(slideDoor == true)
        {
            System.out.println(sDoor + "Yes");
        }
        else
        {
            System.out.println(sDoor + "No");
        }
        System.out.println(line);
    }
    
    public void readData(Scanner iScan)
    {        
        Scanner sScan = iScan;
        super.readData(sScan);      
        
        loadVol = sScan.nextDouble();
        String isYes = sScan.next();
        if(isYes.equals("Yes"))
        {
            slideDoor = true; // false by default
        }      
    }
}