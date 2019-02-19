
import java.util.Scanner;


/*
 *
 * @author Sujal Shrestha
 *
*/

public class EmployeeDataManager
{
    private String[] employeeName;
    private int[] workedHours;
    private double[] employeeWage;
    
    final int N=5;
    
    static Scanner inputNumber =new Scanner(System.in);// scanner input
    static Scanner inputText =new Scanner(System.in);    
   
    public EmployeeDataManager()//constructor
    {
        employeeName = new String[N];
        workedHours = new int[N];
        employeeWage = new double[N];
    }

    public void displayMenu() // displays menu items
    {        
        System.out.print("\n1. Input & validate date.");
        System.out.print("\n2. Display");
        System.out.print("\n3. Sort by name.");
        System.out.print("\n4. Sort by hours.");
        System.out.print("\n5. Search by name.");
        System.out.print("\n6. Search by hours.");
        System.out.print("\n7. Statistics.");
        System.out.print("\n8. Exit.");
        System.out.print("\n\nEnter option 1-8:");
        
    }
    
    public void inputData() // acquires input and validates the input
    {  
        for (int i=0;i<N;i++)
        { 
            //EmployeeDataManager emp=new DataEmployee()
            String validatename;
            String empname = "";
            int empHours = 0;
            double empwage =0.0;
            
            do
            {    
                System.out.printf("\nPlease enter employee name %d:",i+1);// acquires name
                 
                 empname=inputText.nextLine();
                 employeeName[i] = empname;
                 validatename=empname;        
            }while(isValidName(validatename)==false);

            int empLevel=0 ;
            System.out.printf("\nPlease enter skill level(1,2,3):"); // acquires skill level
            
            while(empLevel!=1&&empLevel!=2&&empLevel!=3)
            {                  
                while (!inputNumber.hasNextInt())
                {
                    System.out.println("Data input is'nt Integer.");
                    System.out.printf("\nPlease enter skill level(1,2,3):");
                    inputNumber.next();
                }    
                empLevel= inputNumber.nextInt();


                if(empLevel !=1 &&empLevel !=2 &&empLevel !=3)
                System.out.println("\nData should be 1 or 2 or 3 \nPlease enter skill level(1,2,3):");

            }  

            // calculate wage
            
            
            
            final double RATE_LEVEL_1 = 15.00;
            final double RATE_LEVEL_2 = 17.00;
            final double RATE_LEVEL_3 = 21.00;
            
            System.out.printf("\nPlease enter worked hours:");//acquires worked hours
             
            while (!inputNumber.hasNextInt())
                {
                    System.out.printf("The input must be an integer. Please enter worked hours:");
                    inputNumber.next();     
                } 
            
            while(empHours<=0||empHours>60)
            {                  
                 

                empHours=inputNumber.nextInt();
                if(empHours<=0 ||empHours>60)
                {
                    System.out.printf("\nWorked Hours should be between 0 and 60");
                    System.out.printf("\nPlease enter worked hours:");
                }
                workedHours[i] = empHours;
            }
            
            // pay according to rate but pay increased by 1.5 if above 40 hours
            switch(empLevel)
            {
                case 1:
                    if (empHours>0&&empHours<=40)
                    {
                    empwage = empHours * RATE_LEVEL_1;
                    }
                    else if (empHours>40&&empHours<=60)
                    {
                    empwage = 40 * RATE_LEVEL_1 + ((empHours - 40) * RATE_LEVEL_1 * 1.5);
                    }
                    break;
                    
                case 2:
                    if (empHours>0&&empHours<=40)
                    {
                    empwage = empHours * RATE_LEVEL_2;
                    }
                    else if (empHours>40&&empHours<=60)
                    {
                    empwage = 40 * RATE_LEVEL_2 + ((empHours - 40) * RATE_LEVEL_2 * 1.5);
                    }
                    break;
                    
                case 3:
                    if (empHours>0&&empHours<=40)
                    {
                    empwage = empHours * RATE_LEVEL_3;
                    }
                    else if (empHours>40&&empHours<=60)
                    {
                    empwage = 40 * RATE_LEVEL_3 + ((empHours - 40) * RATE_LEVEL_3 * 1.5);
                    }
                    break;
            }
            
            
            employeeWage[i] = empwage;
            
        
                
        }
    }

    public void displayInfo()// displays information
    {
        System.out.print("\t\t\t Employee worked hours & Hours  ");
        System.out.print("\n\t\t==================================================== ");
        System.out.printf("\n\t\t%s%25s%12s","Employyee","Worked Hours","Wage");
        System.out.print("\n\t\t----------------------------------------------------\n ");
   
        for (int i = 0; i < N; i++)
        System.out.printf("\t\t%-23s%-19d%s%.1f\n",employeeName[i],workedHours[i],"$",employeeWage[i]); 
        System.out.println("\t\tTotal: " + N + " data entries");
           
    }

    public void sortByName()// sorts by name
    {
        for (int i = 1; i < N; i++)
        {
            String name = employeeName[i];
            int hoursWorked = workedHours[i];
            double wage = employeeWage[i];
            int j;

            for (j = i - 1; j >= 0 && name.compareTo(employeeName[j]) < 0; j--) {
                employeeName[j + 1] = employeeName[j];
                workedHours[j + 1] = workedHours[j];
                employeeWage[j + 1] = employeeWage[j];
            }

            employeeName[j + 1] = name;
            workedHours[j + 1] = hoursWorked;
            employeeWage[j + 1] = wage;
        }
        System.out.print("\t\t\t Employee worked hours & Hours  ");
        System.out.print("\n\t\t==================================================== ");
        System.out.printf("\n\t\t%s%25s%12s","Employyee","Worked Hours","Wage");
        System.out.print("\n\t\t----------------------------------------------------\n ");
        
        for (int i=0; i<N; i++)
        {   
            System.out.printf("\t\t%-23s%-19d%s%.1f\n",employeeName[i],workedHours[i],"$",employeeWage[i]);  
        }
    }

    public void sortByHours()// sorts by hours
    {
        for (int i = 1; i < N; i++) {
            String name = employeeName[i];
            int hoursWorked = workedHours[i];
            double wage = employeeWage[i];
            int j;

            for (j = i - 1; j >= 0 && hoursWorked < workedHours[j]; j--) {
                employeeName[j + 1] = employeeName[j];
                workedHours[j + 1] = workedHours[j];
                employeeWage[j + 1] = employeeWage[j];
            }

            employeeName[j + 1] = name;
            workedHours[j + 1] = hoursWorked;
            employeeWage[j + 1] = wage;
        }
        System.out.print("\t\t\t Employee worked hours & Hours  ");
        System.out.print("\n\t\t==================================================== ");
        System.out.printf("\n\t\t%s%25s%12s","Employyee","Worked Hours","Wage");
        System.out.print("\n\t\t----------------------------------------------------\n ");
        
        
        for (int i=0;i<N;i++)
        {
            System.out.printf("\t\t%-23s%-19d%s%.1f\n",employeeName[i],workedHours[i],"$",employeeWage[i]);  
        }
    }

    public void searchByName() // search by name
    {
        String empName;
        System.out.printf("Please enter the employee name: ");
        empName=inputText.nextLine();   
        
      
        int j = -1;

        for (int i = 0; i < N && j == -1; i++) {
            if (employeeName[i].equalsIgnoreCase(empName)) {
                j = i;
            }
        }

        // Print our search results
        if (j == -1) {
            System.out.println("The name you provided does not match with any names in the list.");
        } else {
            System.out.println(employeeName[j] + " - Worked hours: " + workedHours[j] + " - Wage: $" + employeeWage[j]);
        }
        
              
    }

    public void searchByHours()// search by hours
    {
        System.out.print("\nPlease enter the specific number of worked hours :");
        
        while (!inputNumber.hasNextInt())//check whether the entered input is number or not
            {
                System.out.println("That's not a number!"); 
                System.out.print("\nPlease enter the specific number of worked hours :");
                inputNumber.next();
            }
        int hour_search =inputNumber.nextInt();
        int count=0;
        
        System.out.printf("\nFollowing employees have less than %d worked hours: ",hour_search);
        System.out.print("\n\t\t\t Employee worked hours & Hours  ");
        System.out.print("\n\t\t==================================================== ");
        System.out.printf("\n\t\t%s%25s%17s","Employyee","Worked Hours","Wage");
        System.out.print("\n\t\t----------------------------------------------------\n ");
        
        for (int i = 0; i < N; i++)
        {  
            if(workedHours[i]<hour_search)
            {                      
               System.out.printf("\t\t%-23s%-19d%s%.1f\n",employeeName[i],workedHours[i],"$",employeeWage[i]); 
               count++;
            }
        }
        if(count==0)// when there is no match case
        System.out.printf("\nNo availabie employee have less than %d worked hours: ",hour_search);       
    }

    public void statistics() // statistics
    {
        int lowestWorkedHoursIndex = -1;
        int highestWorkedHoursIndex = -1;

        for (int i = 0; i < N; i++) {
            if (lowestWorkedHoursIndex == -1 || workedHours[i] < workedHours[lowestWorkedHoursIndex]) {
                lowestWorkedHoursIndex = i;
            }

            if (highestWorkedHoursIndex == -1 || workedHours[i] > workedHours[highestWorkedHoursIndex]) {
                highestWorkedHoursIndex = i;
            }
        }

        // Calculate the median
        int medianWorkedHours;

        if (N % 2 == 0) {
            medianWorkedHours = workedHours[N / 2] + workedHours[N / 2 - 1] / 2;
        } else {
            medianWorkedHours = workedHours[N / 2];
        }

        System.out.print("\t\t\t A Simple Statistics ");
        System.out.print("\n\t\t========================================== ");
        System.out.println("\tThe employee has lowest worked hours: " + employeeName[lowestWorkedHoursIndex] + ", " + workedHours[lowestWorkedHoursIndex] + " hours");
        System.out.println("\tThe employee has highest worked hours: " + employeeName[highestWorkedHoursIndex] + ", " + workedHours[highestWorkedHoursIndex] + " hours");
        System.out.println("\tThe median value of worked hours: " + medianWorkedHours + " hours");
    }

    
    public boolean isValidName(String name)   // checking name validation
    {
       String check=name;
            if(check.length()>25)// validating max length
            {
                System.out.print("The name cannot be more than 25 characters");
                return false;
            }            
            else if(check.matches("[a-zA-Z]*"))// need for space
            {  
                System.out.print("The name should contain first and last name seperated by a space");
                return false;
            }
            else if(check.matches("([a-zA-Z]+\\s[a-zA-Z]*)+"))           
               return true;           
            else
            { 
                System.out.print("The name should contain first and last name in english letters only seperated by a space"); 
                return false;
            }
    }
    

    public static void main(String[] args) // main method
    {
        System.out.print("\n\t\t\tEmployee Data Manager ");
        System.out.print("\n\t\t---------------------------------- ");
        
        EmployeeDataManager empobj = new EmployeeDataManager();
  
        int choice=0; 
        empobj.displayMenu();
        while(choice!=8)
        {
            while (!inputNumber.hasNextInt())// check whether the entered input is number or not
            {
                System.out.println("You are required to input a number!!!"); 
                empobj.displayMenu();
                inputNumber.next();
            } 
            
            choice=inputNumber.nextInt();

            switch(choice)//control choice option
            {
                case 1:
                    empobj.inputData();
                    break;

                case 2:
                    empobj.displayInfo();
                    break;

                case 3:
                    empobj.sortByName();
                    break;

                case 4:
                    empobj.sortByHours();
                    break;

                case 5: 
                    empobj.searchByName();
                    break;

                case 6: 
                    empobj.searchByHours();
                    break;

                case 7:
                    empobj.statistics();
                    break;

                case 8: 
                    continue;

                default: 
                System.out.println("\n Choose the option from 1 to 8");

                break;               
            }
            empobj.displayMenu();
        }
        System.out.print("\nThank you for using the Employee Data Manager System\n");
        System.out.print("Program written by 12043248\n");
    }
    
}
