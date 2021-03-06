import java.util.*;
import java.io.*;
/**
 * The VehicleReservation class to make use of VehicleReservation objects.
 */
public class VehicleReservation
{
    // instance variables
    private String resNo, vehID, custID;
    private Date startDate; // format: 25-03-2019 
    private int noOfDays;

    /**
     * Constructor for objects of class VehicleReservation
     */
    public VehicleReservation()
    {
        // initialise instance variables
        resNo = null;
        vehID = null;
        custID = null;
        startDate = null;
        noOfDays = 0;
    }

    public VehicleReservation(String iResID, String iVehID, String iCustID, 
    String iStartDate, int iNoD)
    {
        resNo = iResID;
        vehID = iVehID;
        custID = iCustID;
        startDate = stringToDate(iStartDate); // format: 25-03-2019 
        noOfDays = iNoD;
    }

    //DateUtil usgae
    private Date stringToDate(String iDate)
    {
        DateUtil sd = new DateUtil();
        return sd.convertStringToDate(iDate);   
    } 

    private String dateToString(Date iDate)
    {
        DateUtil sd = new DateUtil();
        return sd.convertDateToShortString(iDate);   
    }   
 
    // Accessors for the fields.
    public String getResNo()
    {
        return resNo;
    }

    public String getVehID()
    {
        return vehID;
    }

    public String getCustID()
    {
        return custID;
    }
   
    public int getNoD()
    {
        return noOfDays;
    }
    
    // mutator methods
    public void setResNo(String iResNo)
    {
        resNo = iResNo;
    }
    
    public void setVehID(String iVehID)
    {
        vehID = iVehID;
    }
    
    public void setCustID(String iCustID)
    {
        custID = iCustID;
    }
    
    public void setNoD(int iNoD)
    {
        noOfDays = iNoD;
    }
    
    // Print and Read methods
    /**
     * This method print the details of a reservation.
     */    
    public void printDetails()
    {
        String line = 
        "-----------------------------------------------------------------------------";
        System.out.printf("%-37s \n", "Reservation No.: " + resNo);              
        System.out.printf("%-37s %-24s \n", "Vehicle ID: "+ vehID, 
        "Customer ID: "+ custID);
        System.out.printf("%-37s %-24s \n", "Start Date: "+ 
        dateToString(startDate), "Reserved for(days): " + noOfDays);  
        System.out.println(line);
        System.out.println();
    }
   
    // Read Write Methods
    /**
     * This method reads each reservation entry line by line from a file.
     * 
     * @param: Scannerr: iScan
     */    
    public void readData(Scanner iScan)
    {
        Scanner sScan = iScan;       
         
        resNo = sScan.next();
        vehID = sScan.next();
        custID = sScan.next();
        
        String a = sScan.next();
        startDate = stringToDate(a);
        
        noOfDays = sScan.nextInt();  
    }
    
    /**
     * This method wrties each reservation entry to a line.
     * 
     * @param: PrintWriter: iWriter
     */    
    public void writeData(PrintWriter iWriter)
    {
        PrintWriter xWrite = iWriter;

        xWrite.println(getResNo() + ", " + getVehID() + ", " + getCustID() + 
        ", " + dateToString(startDate) + ", " + getNoD());
    }
}
