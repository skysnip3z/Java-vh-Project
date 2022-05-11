import java.util.Scanner;
import java.io.*;
/**
 * Customer class to enable the use of customer objects.
 */
public class Customer
{
    // fields for Customer
    private String custID, sName, fName, otherInit, title;

    /**
     * Constructor for objects of class Customer
     */
    public Customer(String iSName, String iFName, String iOtherInit,
                    String iTitle)
    {
        // initialise variables
        custID = "AA-1"; // changed to "AA-1" for testing
        sName = iSName;
        fName = iFName;
        otherInit = iOtherInit;
        title = iTitle;        
    }
    
    public Customer()
    {
        custID = null;
        sName = null;
        fName = null;
        otherInit = null;
        title = null;
    }

    // Accessor Methods
    public String getCustID()
    {
        return custID;
    } 

    public String getSName()
    {
        return sName;
    }
    
    public String getFName()
    {
        return fName;
    }
    
    public String getOtherInit()
    {
        return otherInit;
    }
    
    public String getTitle()
    {
        return title;
    } 

    // Mutator Method    
    public void setCustID(String iCust)
    {
        custID = iCust; 
    } 
    //
    public void printDetails()
    {               
        System.out.printf("%-37s \n", "Customer ID: " + custID);
        System.out.print("Customer: " + title + ". " + fName);
        if (!otherInit.isEmpty())
        {
            System.out.print(" " + otherInit);
        }  
        System.out.print(" " + sName + "\n");  
        System.out.println();
    }  
         
    // Read Write Methods
    public void readData(Scanner iScan)
    {
        Scanner sScan = iScan;       
         
        custID = sScan.next();
        sName = sScan.next();
        fName = sScan.next();
        otherInit = sScan.next();
        title = sScan.next();   
    }
    
    /**
     * This method wrties each customer's data to a line.
     * 
     * @param: PrintWriter: iWriter
     */           
    public void writeData(PrintWriter iWriter)
    {
        PrintWriter xWrite = iWriter;

        xWrite.println(getCustID() + ", " + getSName() + ", " + getFName() + 
        ", " + getOtherInit() + ", " + getTitle());
    }
}
