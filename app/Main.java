package app;

import models.*;
import dao.*;
import service.*;
import controller.*;
import java.util.*;


class Main 
{
    

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) 
    {
        System.out.println("Welcome to the ticket booking application!!!");
	    boolean next=true;
	    while(next)
	    {
		System.out.println("For Admin login -> 1 \nFor Customer Login -> 2 \nFor new User -> 3");
        	System.out.print("Enter your choice: ");
        	int choice = sc.nextInt();
        	sc.nextLine();
		switch (choice) 
        	{
            		case 1:
                		AdminController adminController=new AdminController();
				adminController.loginDetails();
                		break;
            		case 2:
                		CustomerController customerController=new CustomerController();
				customerController.loginDetails();
               		 	break;
			case 3:
				CustomerController customerController2=new CustomerController();
				customerController2.registerUser();
				break;            		
            		default:
                		System.out.println("Invalid choice!");
        	}
		System.out.print("If you want to continue (enter 1) otherwise (enter 0) : ");
		int next1=sc.nextInt();
		if(next1==0)
		{
			next=false;
			System.out.println("Thank you for using our application!!!");
		}
	    }

        
    }


    
        


    
}
