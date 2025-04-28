package controller;

import models.*;
import service.*;
import dao.*;
import java.util.*;


public class CustomerController
{
	
	public void loginDetails()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your name : ");
		String userName=sc.nextLine();
		System.out.print("Enter your password : ");
		String userPwd=sc.nextLine();

		CustomerService customerService=new CustomerService();
		
		if(customerService.login(userName,userPwd))
		{
			System.out.println("Customer logged in successfully");

			boolean loginNext = true;
            		while (loginNext) 
            		{
                		System.out.println("\nCustomer Menu:");
                		System.out.println("1 -> Book Ticket");
                		System.out.println("2 -> View Available Movies");
                		System.out.println("3 -> Cancel Ticket");
            			System.out.println("4 -> Exit");
                		System.out.print("Choose: ");
                		int adminChoice = sc.nextInt();
                		sc.nextLine();

                		switch (adminChoice) 
                		{
                    			
					case 1:
						break;

					case 2:
                        			
                        			break;
                    			case 3:
                        			break;
                			
                    			case 4:
						loginNext=false;
						break;
                    			default:
                        			System.out.println("Invalid choice!");
                		}
			}
			
		}
		else
		{
			System.out.println("Sorry! User with specified name and password does not exist...");
		}
	}

	public void registerUser()
	{

		Scanner sc=new Scanner(System.in);
		CustomerService customerService=new CustomerService();
		System.out.print("Enter the your name : ");
		String userName=sc.nextLine();
		System.out.print("Enter your password : ");
		String userPwd=sc.nextLine();

		Customer customer=new Customer(userName,userPwd);
		customerService.createCustomer(customer);

	}


}