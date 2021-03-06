//import java.util.List;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.Random;
//import java.util.HashMap;
// import java.util.Map;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.*;
import java.util.*;
/**
 * Details pertaining to the ReservationSystem which allows it to make
 * reservations and handle vehicle and customer data.
 *
 *   public void  closeSystem() 
 *   public String    getCustKeys() 
 *   public Customer  getCustValue(java.lang.String iKey) 
 *   public File  getFile() 
 *   public File  getFile(java.lang.String fName) 
 *   public void  getNoOfCust() 
 *   public void  getNoOfVeh() 
 *   public void  getNoOfVehRes() 
 *   public String  getVehKeys() 
 *   public String  getVehResKeys() 
 *   public VehicleReservation  getVehResValue(String iKey) 
 *   public Vehicle  getVehValue(String iKey) 
 *   public boolean  makeVehRes(String iCustID, String iVehID, 
 *   public String  iStartDate, int iNoD) 
 *   public void  printAllCust() 
 *   public void  printAllVeh() 
 *   public void  printAllVehRes() 
 *   public void  readCustData() 
 *   public void  readCustData(String fName) 
 *   public void  readVehData(String iPath) 
 *   public void  readVehResData() 
 *   public void  readVehResData(String fName) 
 *   public void  reloadSystem() 
 *   public void  storeCust(Customer iCust) 
 *   public void  storeVeh(Vehicle iVeh) 
 *   public void  storeVehRes(VehicleReservation iVehRes) 
 *   public void  writeCustData() 
 *   public void  writeCustData(String fName) 
 *   public void  writeVehResData() 
 *   public void  writeVehResData(String fName)
 *   
 */
public class ReservationSystem
{
    // instance variables
    // private ArrayList<Vehicle> vehList;
    // private ArrayList<Customer> custList;
    private Map<String, Vehicle> vehMap;
    private Map<String, Customer> custMap; 
    private Map<String, VehicleReservation> vehResMap;
    private Map<Integer, String> uniqID;    
    private Random rndGen;
    private boolean firstCallToGenResNo;
    private int lastResNo;
    private String lngFileName, custDump, itemResDump;
    
    /**
     * Constructor for objects of class ReservationSystem
     */
    public ReservationSystem(String sysName)
    {
        // initialise instance variables
        firstCallToGenResNo = true;
        lastResNo = 0;
        lngFileName = "LastNumberGenerated.txt ";
        vehMap = new HashMap<String, Vehicle>();
        custMap = new HashMap<String, Customer>();
        rndGen = new Random();  
        uniqID = new HashMap<Integer, String>();
        vehResMap = new HashMap<String, VehicleReservation>();
        
        custDump = sysName + "CustDump.txt";
        itemResDump = sysName + "ItemResDump.txt";
        
        readVehData("vehicle_data_2.txt");
    }

    // Count methods
    /**
     * This method counts all Vehicles that are stored in vehMap.
     */
    public void getNoOfVeh()
    {
        int count = 0;
        
        ArrayList<Vehicle> vehList = 
        new ArrayList<Vehicle>(vehMap.values());
        for (Vehicle veh : vehList)
        {
            count++;
        }
        System.out.println("Total Vehicles: " + count);
    }

    /**
     * This method counts all Customers that are stored in custMap.
     */
    public void getNoOfCust()
    {
        int count = 0;
        
        ArrayList<Customer> custList = 
        new ArrayList<Customer>(custMap.values());       
        for (Customer cust : custList)
        {
           count++;   
        }  
        System.out.println("Total Customers: " + count);
    }
   
    /**
     * This method counts all VehicleReservations that are stored in 
     * vehResMap.
     */    
    public void getNoOfVehRes()
    {
        int count = 0;
        
        ArrayList<VehicleReservation> vehResList = 
        new ArrayList<VehicleReservation>(vehResMap.values());        
        for (VehicleReservation vehRes : vehResList)
        {
           count++;    
        }  
        System.out.println("Total Vehicle Reservations: "+ count);
    }   
    
    // Store Methods
    /**
     * This method allows a vehichle to be stored in a key value pair format.
     * 
     * @param: Vehicle: iVeh
     */    
    public void storeVeh(Vehicle iVeh)
    {
        vehMap.put(iVeh.getVehID(), iVeh);
    }

    /**
     * This method allows a VehicleReservation to be stored in a 
     * key value pair format. 
     * 
     * This will also generate an incrementing resevation number before 
     * putting it into the system.
     * 
     * @param: VehicleReservation: iVehRes
     */    
    public void storeVehRes(VehicleReservation iVehRes)
    {
        iVehRes.setResNo(genResNo());   
        vehResMap.put(iVehRes.getResNo(), iVehRes);        
    }

    /**
     * This method allows a vehichle to be stored in a key value pair format.
     * 
     * @param: Vehicle: iVeh
     */     
    public void storeCust(Customer iCust)
    {
        if(iCust.getCustID().equals("unknown"))
        {
            iCust.setCustID(genCustID("AA-", 6)); 
            custMap.put(iCust.getCustID(), iCust); 
        }
        else
        {
            custMap.put(iCust.getCustID(), iCust);
        }           
    }
    
    // Print methods
    /**
     * This method prints the details of all vehicles in the system.
     */      
    public void printAllVeh()
    {       
        System.out.println("Details of current vehicles:");        
        System.out.println();        
        ArrayList<Vehicle> vehList = 
        new ArrayList<Vehicle>(vehMap.values());
        
        for (Vehicle veh : vehList)
        {
           veh.printDetails();    
        }
    } 

    /**
     * This method prints the details of all customers in the system.
     */    
    public void printAllCust()
    {       
        System.out.println("Details of current customers:");        
        System.out.println();     
        ArrayList<Customer> custList = 
        new ArrayList<Customer>(custMap.values());
        
        for (Customer cust : custList)
        {
           cust.printDetails();     
        }  
    }

    /**
     * This method prints the details of all vehicle reservations 
     * in the system.
     */   
    public void printAllVehRes()
    {       
        System.out.println("Details of current reservations:");        
        System.out.println();     
        ArrayList<VehicleReservation> vehResList = 
        new ArrayList<VehicleReservation>(vehResMap.values());
        
        for (VehicleReservation vehRes : vehResList)
        {
           vehRes.printDetails();     
        }  
    }

    /**
     * This method reads all vehicle data from a given path.
     * 
     * @param: String: iPath (this is fixed for vehicle data)
     */      
    public void readVehData(String iPath)
    {        
        // Ensuring the file is attained from data folder
        File xData = getFile(iPath);
                
        // Setting up a Scanner for going through the data
        try
        {
            
            Scanner xScan = new Scanner(xData);
            String currentLine; 
            String typeOfData = new String();
        
            while(xScan.hasNextLine())
            {
                currentLine = xScan.nextLine().trim();
                if(currentLine.isEmpty() || currentLine.startsWith("/")) 
                {
                }
                else if(currentLine.startsWith("["))
                {
                    typeOfData = currentLine;
                }
                else
                {                 
                    Scanner sScan = new Scanner(currentLine).useDelimiter
                    (" *, *");
                    Vehicle v1;
                    if (typeOfData.toLowerCase().equals("[car data]"))
                    {
                        v1 = new Car();  
                        v1.readData(sScan); // read delagation
                        storeVeh(v1);
                    }
                    else if(typeOfData.toLowerCase().equals("[van data]"))
                    {
                        v1 = new Van();  
                        v1.readData(sScan); // read delagation
                        storeVeh(v1);
                    }
                    else if(typeOfData.toLowerCase().equals("[truck data]"))
                    {
                        v1 = new Truck();  
                        v1.readData(sScan); // read delagation
                        storeVeh(v1);
                    }
                    else
                    {
                        System.out.println("Undefined Vehicle Type Found");
                    }                    
                } 
            }
        }
        catch(FileNotFoundException found)
        {
            System.out.println("You have not loaded a valid " + 
                                "file");
        }
    }

    /**
     * Non parameter version of reading all customer data from a file
     */   
    public void readCustData()
    {
       File xData = getFile();
       String fName;
       if (xData != null)
       {
            fName = xData.getName();
            readCustData(fName);
       }       
    }

    /**
     * This method reads all customer data from a given file.
     * 
     * @param: String: fName
     */     
    public void readCustData(String fName)
    {        
        File xData = getFile(fName);                
        // Setting up a Scanner for going through the data
        try
        {
            
            Scanner xScan = new Scanner(xData);
            String currentLine; 
        
            while(xScan.hasNextLine())
            {
                currentLine = xScan.nextLine().trim();
                if(currentLine.isEmpty() || currentLine.startsWith("/")) 
                {
                }
                else
                {                 
                    Scanner sScan = new Scanner(currentLine).useDelimiter
                    (" *, *");
                    
                    Customer c1 = new Customer();
                    c1.readData(sScan); // read delagation
                    storeCust(c1);
                } 
            }
        }
        catch(FileNotFoundException found)
        {
            System.out.println("You have not loaded a valid " + 
                                "file");
        }
    }

    /**
     * Non parameter version of writing all customer data to a file
     */       
    public void writeCustData()
    {
       File xData = getFile();
       String fName;
       if (xData != null)
       {
            fName = xData.getName();
            writeCustData(fName);
       }       
    }     

    /**
     * This method writes all customer data to a given file.
     * 
     * @param: String: fName
     */       
    public void writeCustData(String fName) 
    {      
        // Ensuring the file is stored in a local variable
        File xData = getFile(fName);
        try
        {
            PrintWriter xWrite = new PrintWriter(xData);          
            
            xWrite.println("// Customer data from system");
            xWrite.println(
            "// customerID, surname, firstName, otherInitials, title");
            // a reference for alignment
            xWrite.println();
            ArrayList<Customer> custList = 
            new ArrayList<Customer>(custMap.values());
            for (Customer cust : custList)
            {
                cust.writeData(xWrite); // write delagation
            }
            xWrite.close();
        }
        catch(FileNotFoundException found)
        {
            System.out.println("You have not loaded a valid " + 
                                "file!");
        }
    }

    /**
     * Non parameter version of reading all vehicle reservation
     * data from a file
     */     
    public void readVehResData()
    {
       File xData = getFile();
       String fName;
       if (xData != null)
       {
            fName = xData.getName();
            readVehResData(fName);
       }       
    }    

    /**
     * This method reads all vehicle reservation data from a given file.
     * 
     * @param: String: fName
     */       
    public void readVehResData(String fName)
    {        
        // Ensuring the file is attained
        File xData = getFile(fName);                
        // Setting up a Scanner for going through the data
        try
        {
            
            Scanner xScan = new Scanner(xData);
            String currentLine; 
        
            while(xScan.hasNextLine())
            {
                currentLine = xScan.nextLine().trim();
                if(currentLine.isEmpty() || currentLine.startsWith("/")) 
                {
                    // for comments in file, admin.
                }
                else
                {                 
                    Scanner sScan = new Scanner(currentLine).useDelimiter
                    (" *, *");
                    
                    VehicleReservation vr1 = new VehicleReservation();
                    vr1.readData(sScan); // read delagation
                    storeVehRes(vr1);
                } 
            }
        }
        catch(FileNotFoundException found)
        {
            System.out.println("You have not loaded a valid " + 
                                "file");
        }
    }

    /**
     * Non parameter version of writing all vehicle reservation
     * data to a file
     */     
    public void writeVehResData()
    {
       File xData = getFile();
       String fName;
       if (xData != null)
       {
            fName = xData.getName();
            writeVehResData(fName);
       }       
    }

    /**
     * This method writes all customer data to a given file.
     * 
     * @param: String: fName
     */     
    public void writeVehResData(String fName) 
    {      
        // Ensuring the file is stored in a local variable
        File xData = getFile(fName);
        try
        {
            PrintWriter xWrite = new PrintWriter(xData);          
            
            xWrite.println("// Vehicle Reservation data from system");
            xWrite.println(
            "// resNo, vehID, custID, startDate, noOfDays");
            // a reference for alignment
            xWrite.println();
            ArrayList<VehicleReservation> vehResList = 
            new ArrayList<VehicleReservation>(vehResMap.values());
        
            for (VehicleReservation vehRes : vehResList)
            {
                vehRes.writeData(xWrite); // write delagation   
            }  
            xWrite.close();
        }
        catch(FileNotFoundException found)
        {
            System.out.println("You have not loaded a valid " + 
                                "file!");
        }
    }    
       
    // temp public, now private (methods made to avoid duplicate code)
    /**
     * This method grabs a file from the given folder relative to it's own.
     * This does not open a visible dialog to pick the file.
     * @param: String: fName
     */       
    private File getFile(String fName)
    {
        //Setting up FileDialog for file retrieval with correct path
        Frame f1 = null;
        FileDialog xFile = new FileDialog(f1, null, FileDialog.LOAD);
        xFile.setDirectory("..\\data\\");
        xFile.setVisible(false);
        String dir, file, fullPath;
        dir = xFile.getDirectory();
        xFile.setFile(fName);
        file = xFile.getFile();
        fullPath = dir + file;
        
        // Ensuring the file is stored in a local variable
        File iData = new File(fullPath);
        return iData;
    }

    /**
     * This is the non-parameter version to allow the user to select the
     * file. 
     */    
    public File getFile() 
    {
        //Setting up FileDialog for file retrieval with correct path
        Frame f1 = null;
        FileDialog xFile = new FileDialog(f1, "Open File", FileDialog.LOAD);
        xFile.setDirectory("..\\data\\");
        xFile.setVisible(true);
        String dir, file, fullPath;
        dir = xFile.getDirectory();
        file = xFile.getFile();
        fullPath = dir + file;
        
        // Ensuring the file is stored in a local variable
        File iData = new File(fullPath);
        
        return iData;
    }
    
    // Unique ID generators: temp public, now private
    /**
     * This method generates a random customer up to given digits.
     * 
     * @param: String: prefix | int: iNoD
     */       
    private String genCustID(String prefix, int iNoD) 
    {        
        String a = "";
        String cPrefix = prefix;
        int cNoD = iNoD;
        
        for(int i = iNoD; i > 0; i--) 
        {
             a = a + "9";
        }
        Integer b = Integer.valueOf(a); 
        int lastInt = rndGen.nextInt(b);        
        
        if(uniqID.containsKey(lastInt)) 
        {   
            genCustID(cPrefix, cNoD);
        }
        else
        {
            uniqID.put(lastInt, prefix);
        }
        return prefix + lastInt;        
    }

    /**
     * This method generates increments a unique reservation number
     * and checks it agaisnt a file in the case of a system restart.
     */         
    private String genResNo()
    {       
        File xLastResNo = getFile("..\\data\\" + lngFileName.trim()); //trim due to /u0000
        try
        {     
            if(!xLastResNo.exists())
            {
                xLastResNo.createNewFile();                
            }
            if(firstCallToGenResNo == true)
            {
                firstCallToGenResNo = false;
            }
            
            
            Scanner xScan = new Scanner(xLastResNo);           
            if(xScan.hasNextInt())
            {             
                lastResNo = xScan.nextInt(); 
            }
            
            Integer iLastResNo = lastResNo;           
            String a = iLastResNo.toString(); 
            int limit = 6;
            String before = "";     
            
            for(int i = a.length(); i < limit; i++)
            {
                before = before + 0;
            }
            
            PrintWriter xWrite = new PrintWriter(xLastResNo);
            lastResNo++;
            xWrite.print(lastResNo);
            xWrite.close();
            
            String after = before + a;
            return after;        
        }
        catch(IOException found)
        {
              return "Bug found!";
        }                               
    } 
    
    // makeVehRes() method
    /**
     * This method facilitates making a reservation of a vehicle
     * 
     * @param: String: iCustID | String: iVehID | String: iStartDate | 
     *         int: iNoD
     */     
    public boolean makeVehRes(String iCustID, String iVehID, 
                              String iStartDate, int iNoD)
    {
        if(getCustValue(iCustID) != null && getVehValue(iVehID) != null 
        && iStartDate != null && iNoD != 0)  
        {
            VehicleReservation vrOne = new VehicleReservation(genResNo(),
            iVehID, iCustID, iStartDate, iNoD);
            
            //System.out.println("Success!");
            
            return true;
        }
        else
        {
            System.out.println("Details given do not match the system criteria" + 
            ", please try again.");
            return false;
        }       
    }

    /**
     * This method restores the system's data to the state it was 
     * in prior to shutdown
     */     
    public void reloadSystem()
    {
        if(custMap.isEmpty())
        {
            File xData = getFile(custDump);
            if(xData.exists())
            {
                try
                {
                    xData.createNewFile();
                    readCustData(custDump);
                }
                catch(IOException found)
                {
                    System.out.println("Error: refer to closeSystem()");
                }
            }
        }     
        if(vehResMap.isEmpty())
        {
            File xData = getFile(itemResDump);
            if(xData.exists())
            {
                try
                {
                    xData.createNewFile();
                    readVehResData(itemResDump);
                }
                catch(IOException found)
                {
                    System.out.println("Error: refer to closeSystem()");
                }
            }
        }   
    }    

    /**
     * This method shutdowns the system and creates a dump file for all data.
     */       
    public void closeSystem()
    {
        if(custMap.isEmpty())
        {}
        else
        {
            File xData = getFile(custDump);
            if(!xData.exists())
            {
                try
                {
                    xData.createNewFile();
                    writeCustData(custDump);
                }
                catch(IOException found)
                {
                    System.out.println("Error: refer to closeSystem()");
                }
            }
        }        
        if(vehResMap.isEmpty())
        {}
        else
        {
            File xData = getFile(itemResDump);
            if(!xData.exists())
            {
                try
                {
                    xData.createNewFile();
                    writeVehResData(itemResDump);
                }
                catch(IOException found)
                {
                    System.out.println("Error: refer to closeSystem()");
                }
            }
        }
        System.exit(0);     
    }
    
    // get methods for Maps
    public Vehicle getVehValue(String iKey)
    {
        return vehMap.get(iKey);
    }    

    public Customer getCustValue(String iKey)
    {
        return custMap.get(iKey);
    }  

    public VehicleReservation getVehResValue(String iKey)
    {
        return vehResMap.get(iKey);
    }    
    
    // Get Methods for HashMap Keys
    public String getVehKeys()
    {       
         return vehMap.keySet().toString();
    }    
    
    public String getCustKeys()
    {       
         return custMap.keySet().toString();
    }
    
    public String getVehResKeys()
    {       
         return vehResMap.keySet().toString();
    }   
}           