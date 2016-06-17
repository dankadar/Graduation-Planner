
import java.util.*;
import java.util.ArrayList;
import java.math.*;


/**
 *
 * @author Dan Kadar
 * This program will prompt a user to input the number of CUs required for each class
 * remaining to graduate and the number of CUs the user wants to complete each term. 
 * It will output the numbers of terms needed, tuition cost and the number of months needed to graduate
 */
public class GraduationPlanner {

   
    public static void main(String[] args) {
       
        
    final int TUITION_COST = 2890; //tuition cost per semester
    double unitsPerTerm = 0; //number of CUs user wants to take per term
    double sumCus= 0; //total CUs remaining
    int numTerms= 0; //number of terms required to graduate
    int numMonths = 0; //number of months required to graduate
    int totalCost = 0;
    
    ArrayList<Integer> cus = new ArrayList<Integer>();  //Array list to hold inputed CUs
    
    Scanner in = new Scanner(System.in); // read input from command line
    
    //Prompt user to input number of CUs
    System.out.print ("Please enter the numbers of Competency Units required for each of your remaining course. Seperate them with a space and hit enter when done:");
    
    
   //read next line of input
     String str = in.nextLine();
     
     Scanner scanCU = new Scanner(str);
     
    while (scanCU.hasNext())
    {
        int temp = scanCU.nextInt();
         
        //Check if 0 or negative number entered
        if (temp  < 0){
           System.out.print("Error: Competency Units must be positive, please re-enter:");
           str = in.nextLine();     
           scanCU = new Scanner(str);
           cus.clear();
        }
        //if valid numbers, add it to Array LIst cus
        else 
        {
       cus.add(temp);
        }
           
       
            }
    //determines total number of CUs
    for (int i= 0; i<cus.size(); i++)
    {
        sumCus+= cus.get(i);
    }
    //Output total CUs to user and ask user how many credits they want to study each term
    System.out.print("You have a total of " + sumCus + " CUs remaining. How many CUs do you wish to complete each term?");
    unitsPerTerm = in.nextInt();
    // Check to make sure they meet 12 CU per term minimum
    if (unitsPerTerm <12)
    {
        do
        {
            System.out.print("Sorry  no slacking, you must complete at least 12 CUs per term, please try again.");
            unitsPerTerm = in.nextInt();
        }while (unitsPerTerm < 12);
    }
    
    //Calcuate how many terms, months and tuition will be required. 
    numTerms =  (int) Math.ceil(sumCus / unitsPerTerm);
    numMonths = (int) numTerms * 6;
    totalCost = (int) numTerms *TUITION_COST;
    
    System.out.println("At " + unitsPerTerm + " units per term, it will take you " + numTerms + " terms to graduate.");
    System.out.println("You will need " + numMonths + " months to graduate and it will cost $" + totalCost + " in tuition.");
    

    // close input stream
     in.close();
     
       

    
    }
}
