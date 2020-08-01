package todo;

import java.util.Scanner;


public class IO {
    
    private Scanner input = new Scanner(System.in);
    
    //**OUT
    public void introduction(){
        System.out.println("--------\n"
                + "This application allows users to add or delete items.\n"
                + "The app will use a file to store the items when the app is not in use."
                + "\n--------\n");
    }
    
    public void goodbye(){
        System.out.println("Thank you for using our software!");
    }
    
    
    //**IN
    public int Menu(){
        //display check grades, add grades, edit student grades, calculate a final grade, display all students, and exit.
        System.out.println("\nWelcome:-");
        System.out.println("1) Display Items \n2) Add Items \n3) Delete Item \n0) Exit List \n");
        return input.nextInt();
    }
    
    public String addItem(){
        
        System.out.println("Enter item name: ");
        input.nextLine(); //fix mismatched error
        
        while(!input.hasNext()){
            input.next();
        }
       
        return input.nextLine();
    }
    
    public int deleteItem(){
        System.out.println("Enter the number of the item you would like to delete or -1 to cancel: ");
        while(!input.hasNextInt()){
            System.out.println("Invalid input!");
            input.next();
        }
        return input.nextInt();
    }
}
