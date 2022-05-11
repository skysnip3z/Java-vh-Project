import java.util.Scanner;
/**
 * Details pertaining to the Vehicle Class:
 * 
 *   public String    getAirCon() 
 *   public String    getDateFirstReg() 
 *   public String    getEngSize() 
 *   public String    getfuelType()  
 *   public String    getGearBox() 
 *   public String    getGroup() 
 *   public String    getMake() 
 *   public int   getMilage() 
 *   public String    getModel() 
 *   public String    getRegNo() 
 *   public String    getTrans() 
 *   public String    getVehID() 
 *   public void  printDetails() 
 *   public void  readData(Scanner iScan) 
 * 
  */
public abstract class Vehicle
{
    // Vehicle variables
    private String group, vehID, regNo, make, model, fuelType, gearBox,
    trans,dateFirstReg;
    private boolean airCon;
    private double engSize;
    private int milage;
    
    
    /**
    * Constructor for objects of class Vehicle
    * 
    */
    public Vehicle(String iGroup, String iVehID, String iRegNo, String iMake)
    {
       // initialise instance variables
       group = iGroup;
       vehID = iVehID;
       regNo = iRegNo;
       make = iMake;
    }
    
    public Vehicle()
    {
        // ordered in accordance to data file
        group = null;
        vehID = null;
        regNo = null;
        make = null;
        model = null;
    
        airCon = false;
        engSize = 0.0; // litres
    
        fuelType = null;
        gearBox = null;
        trans = null;
        dateFirstReg = null;       
    }
    
    // Accessors for the fields.
    public String getGroup()
    {
        return group;
    }  
    
    public String getVehID()
    {
        return vehID;
    }
       
    public String getRegNo()
    {
        return regNo;
    }
        
    public String getMake()
    {
        return make;
    }
    
    public String getModel()
    {
        return model;
    }
    
    public String getAirCon()
    {
        if (airCon == true)
        {
            return "Yes";
        }
        else
        {
            return "No";
        }
    }    
    
    public Double getEngSize()
    {
        return engSize; 
    }
    
    public String getfuelType()
    {
        return fuelType;
    }
       
    public String getGearBox()
    {
        return gearBox;
    }
    
    public String getTrans()
    {
        return trans;
    } 
    
    public int getMilage()
    {
        return milage;  
    }
    
    public String getDateFirstReg()
    {
        return dateFirstReg;
    }     
    
    // print method
    /**
     * This method prints this, and the details of all classes 
     * that extend vehicle
     */ 
    public void printDetails()
    {
        String airCC = "Air Conditioning/CC: ";
        
        System.out.printf("%-37s %-13s %-24s \n", make + " " + model, "Group: "
                      + group, "Reg No.: " + regNo); 
        if(airCon == true)
        {
            System.out.println(airCC + "Yes");
        }
        else
        {
            System.out.println(airCC + "No");
        }
        System.out.printf("%-37s %-24s \n", "Engine Size: " + engSize, "Fuel: "
                      + fuelType);
        System.out.printf("%-37s %-24s \n", "GearBox: " + gearBox, "Transmission: "
                      + trans);              
        System.out.printf("%-37s %-24s \n", "Milage: " + milage, "Date2 first Registered: "
                      + dateFirstReg);
        System.out.println();
    }         
    
    // read method
    /**
     * This method scans a file in the format set below and all the extended
     * classes.
     * 
     * @param: Scanner: iScan
     */     
    public void readData(Scanner iScan)
    {
        Scanner sScan = iScan;       
        
        
        group = sScan.next();
        vehID = sScan.next();
        regNo = sScan.next();
        make = sScan.next();
        model = sScan.next();
            
        String isYes = sScan.next();
        if(isYes.equals("Yes"))
        {
            airCon = true; // false by default
        }

        engSize = sScan.nextDouble();    
        
        fuelType = sScan.next();
        gearBox = sScan.next();
        trans = sScan.next();
            
 
        milage = sScan.nextInt();
            
        dateFirstReg = sScan.next();
    }               
}