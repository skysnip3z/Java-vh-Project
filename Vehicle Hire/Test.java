import java.io.*; // file related testing
import java.util.*; // date related testing
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    /**
     * Constructor for objects of class Test
     */
    
    public Test() throws IOException
    {
        // TEST 1: Creating Vehicle and ReservationSystem objects and ensuring
                // printDetails(), storeVeh(), printAllVeh() are funtional. 
                
                
        // Vehicle v1 = new Vehicle("A1", "KF-9891", "AH97ALI", "Honda");
        ReservationSystem resSys = new ReservationSystem("Ali");
        
        // v1.printDetails();
        // ResSys.storeVeh(v1);
        // ResSys.printAllVeh();
        
        
        // SUCCESSFUL: all the above methods are functioning correctly.
        
        
        // TEST 2: Testing read algorithm for functionality and only current scanner.
        
        
        // resSys.readVehData();
        

        // SUCCESSFUL: The read output is printing all lines of data aside
                           // from the lines that should be ignored.
        
        
                           
        // TEST 3: Testing the new read algorithm and scanners with try catch.
        
        // resSys.readVehData();                   
        // resSys.printAllVeh();
        
        // SUCCESSFUL: The try catch statement caught the FNF exception
                           // when non-existent file path passed to Scanner.
                           // Scanners are working and storing into ArrayList                           
                           // correctly for data1.
        
        // TEST 4: Testing same as above for customer data.
        
        // resSys.readCustData(); 
        // resSys.printAllCust();
        
        // SUCCESSFUL: Data is being read and printed as per requirements.
        
        
        // TEST 5: Testing the write of the Customer Data from the ArrayList
        
        // resSys.readCustData();
        // resSys.writeCustData();          
        
        // SUCCESSFUL: Data is being read and wrote as per requirements.
        
        
        // TEST 6: Testing the number of digits and Random functionality
        
        // resSys.genCustID("AA-", 4);

        // SUCCESSFUL: Random generator is working without unique values.
        
        // TEST 7: Adding in ability to check for unique keys.
        
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.getKey(); // should return 0-8 unique keys.

        // SUCCESSFUL: Test ran multiple times and debugged to confirm
                    // unique key system is working.       
                    
        // TEST 8: Testing new customer with pre-existing ID scenario (step 3)
        
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // resSys.genCustID("AA-", 1);
        // Customer c1 = new Customer("Ali", "Hassan", null, "Mr");
        // resSys.storeCust(c1);
        // resSys.getKey(); // should return 0-8 unique keys.

        // SUCCESSFUL: Test ran multiple times and debugged to confirm
                    // customer id is changed if it already exists. 
                    
        // TEST 9: Testing storeX() methods for Vehicle and Customer
                //

        // Customer c1 = new Customer("Ali", "Hassan", null, "Mr");
        // Vehicle v1 = new Car();
        // resSys.storeCust(c1);
        // resSys.storeVeh(v1);
        // System.out.println(resSys.getCustKeys());  
        // System.out.println(resSys.getVehKeys());         

        // SUCCESSFUL: Due to rndGen, I limited the NoD to 1. This allowed me
                    // to verify the method works after a number of attempts.                     

        // TEST 10: Testing convertStringToDate() with two 

        // DateUtil test = new DateUtil();
        // String dateOne = "23-03-2019 ";
        // String dateTwo = "30-03-2019 ";
        // Date d1 = test.convertStringToDate(dateOne); 
        // Date d2 = test.convertStringToDate(dateTwo);
        // String dateThree = "01-04-2019 ";
        // String dateFour = "14-04-2019 ";
        // Date d3 = test.convertStringToDate(dateThree); 
        // Date d4 = test.convertStringToDate(dateFour);
        
        // System.out.println("Days between " + dateOne + " & " + dateTwo + 
        // " is: " + test.daysBetween(d1, d2));  
        // System.out.println("Days between " + dateThree + " & " + dateFour + 
        // " is: " + test.daysBetween(d3, d4));
        
        // SUCCESSFUL: Days between date pairs are accurate.
        
        
        // TEST 11: Testing storeVehRes() method

        // VehicleReservation vr1 = new VehicleReservation("000001",
        // "TF-63403","AA-123456","25-03-2019", 7);
        // resSys.storeVehRes(vr1);
        // System.out.println(resSys.getVehResKeys());          

        // SUCCESSFUL: Successfully returned 000001
        

        // TEST 12: Testing genResNo() method. 10 times to test digit shift
        
        // System.out.println(resSys.genResNo());  
        // System.out.println(resSys.genResNo());
        // System.out.println(resSys.genResNo());
        // System.out.println(resSys.genResNo());        
        // System.out.println(resSys.genResNo());
        // System.out.println(resSys.genResNo());
        // System.out.println(resSys.genResNo());
        // System.out.println(resSys.genResNo());
        // System.out.println(resSys.genResNo());
        // System.out.println(resSys.genResNo());
        
        // SUCCESSFUL: Successfully returned 000001 and 000010 respectively        

        // TEST 13: Testing makeVehRes() method
        
        // resSys.readVehData();
        // resSys.readCustData();
        // resSys.makeVehRes("AA-674607","TF-63403","20-04-19", 7);         
        
        // SUCCESSFUL: returns True with messege to confirm       

        
        // TEST 13: Testing printDetails() of VehicleReservation Class
        
        // VehicleReservation vr1 = new VehicleReservation("000001",
        // "TF-63403","AA-123456","25-03-2019", 7);
        // vr1.printDetails();      
        
        // SUCCESSFUL: Details reflect format of code and show correctly

        
        // TEST 14: Testing printAllVehRes() of ReservationSystem Class
        
        // VehicleReservation vr1 = new VehicleReservation(null,
        // "TF-63403","AA-123456","25-03-2019", 7);
        // VehicleReservation vr2 = new VehicleReservation(null,
        // "TF-63403","AA-123456","25-03-2019", 7);
        // resSys.storeVehRes(vr1);
        // resSys.storeVehRes(vr2);
        // resSys.printAllVehRes();
        
        // SUCCESSFUL: Correctly shown, also retested unique resNo.

        
        // TEST 14: Testing reservation Read & Write method in the system.
        
        // VehicleReservation vr1 = new VehicleReservation(null,
        // "TF-63403","AA-123456","25-03-2019", 7);
        // VehicleReservation vr2 = new VehicleReservation(null,
        // "TF-63403","AA-123456","25-03-2019", 7);
        // resSys.storeVehRes(vr1);
        // resSys.storeVehRes(vr2);
        
        // resSys.writeVehResData();
        // resSys.readVehResData();
        // resSys.printAllVehRes();
        
        // SUCCESSFUL: 4 entries are int the Map due to 2 method calls();
 
        
        // TEST 15: Testing getFile() and getFile(String x) methods
        
        // File f1 = resSys.getFile();
        // File f1 = resSys.getFile("\\vehicle_data_2.txt");
        // System.out.println(f1.getPath());     
        
        // SUCCESSFUL: tested paths are correct to file locations;
        
        
        // TEST 16: Testing readVehData() without dialog and constuctor call
                          
        // resSys.printAllVeh();
        
        // SUCCESSFUL: tested paths are correct to file locations;
        
        // TEST 17: Retesting readXData() & writeXData() after refactoring
        
        // resSys.readCustData(); 
        // resSys.printAllCust();
        // resSys.writeCustData();
        
        // resSys.readVehResData(); 
        // resSys.printAllVehRes();        
        // resSys.writeVehResData(); 
       
        // SUCCESSFUL: reads and writes are working correctly;
        
        
        // TEST 18: Checking if closeSystem() works properly.
        
        // resSys.readCustData("customer_data.txt");         
        // resSys.readVehResData("vehRes_test.txt"); 
        // resSys.closeSystem();
       
        // SUCCESSFUL: closeSystem() creates files with correct data.
                    // and only if data exists in the system.
 
                    
        // TEST 19: Checking if reloadSystem() works properly.
                 // TEST 18 ran once to create files.
        
        // resSys.reloadSystem();
        // resSys.printAllCust();
        // resSys.printAllVehRes();
        
        // SUCCESSFUL: reloadSystem() loads data if it is present.
        
        
        // TEST 20: testing count methods
        
        // resSys.readCustData("customer_data.txt");       
        // resSys.readVehData("vehicle_data_2.txt");
        // resSys.readVehResData("vehRes_test.txt");
        // resSys.getNoOfVeh();
        // resSys.getNoOfCust();
        // resSys.getNoOfVehRes();

        // SUCCESSFUL: All counts are accurate and display correctly.        
        
    }
}