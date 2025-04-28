package controller;

import models.*;
import dao.*;
import service.*;
import java.util.*;

public class AdminController
{
	Scanner sc=new Scanner(System.in);
	public void loginDetails()
	{
		
		System.out.print("Enter your name : ");
		String userName=sc.nextLine();
		System.out.print("Enter your password : ");
		String userPwd=sc.nextLine();

		AdminService adminService=new AdminService();
		
		if(adminService.login(userName,userPwd))
		{
			System.out.println("Admin logged sucessflly");

			boolean loginNext = true;
            		while (loginNext) 
            		{
                		System.out.println("\nAdmin Menu:");
				System.out.println("1 -> Create New User");
                		System.out.println("2 -> Create Movie");
                		System.out.println("3 -> Create Screen");
                		System.out.println("4 -> View Booking Details");
                		System.out.println("5 -> Delete Movie");
				System.out.println("6 -> Change Movie");
				System.out.println("7 -> Screen Details");
				System.out.println("8 -> Movie Details");
				System.out.println("9 -> View Admin List");
				System.out.println("10-> View Customer List");
				System.out.println("12 -> Assign Movie");
				System.out.println("11 -> Exit");
                		System.out.print("Choose: ");
                		int adminChoice = sc.nextInt();
                		sc.nextLine();

                		switch (adminChoice) 
                		{
                    			
					case 1:
						registerUser();
                				break;

					case 2:
                        			MovieController movieController1=new MovieController();
						Movie movie1=movieController1.movieDetails();
						adminService.createMovie(movie1);
                        			break;
                    			case 3:
                        			ScreenController screenController1=new ScreenController();
						Screen screen1=screenController1.screenDetails();
						adminService.createScreen(screen1);
                        			break;
                    			case 4:
                        			break;
                    			case 5:
                        			MovieController movieController2=new MovieController();
						Movie movie2=movieController2.movieDetails();
						adminService.deleteMovie(movie2);
                        			break;
					case 6:
						MovieController movieController3=new MovieController();
						Movie movie3=movieController3.movieDetails();
						adminService.changeMovie(movie3);
						break;
		    			case 7:
						adminService.viewScreen();
						break;
                    			case 8:
                        			adminService.viewMovie();										
						break;
					case 9:
                        			adminService.viewAdmin();															
						break;
	
					case 10:
						adminService.viewCustomer();
						break;

					case 11:
						loginNext=false;
						break;

					case 12:
						adminService.assignMovie();
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
		AdminService adminService=new AdminService();
		System.out.print("Enter the your name : ");
		String userName=sc.nextLine();
		System.out.print("Enter your password : ");
		String userPwd=sc.nextLine();

		System.out.println("For user -> 1 \nFor customer -> 2");
		System.out.print("Enter your choose : ");
		int choose=sc.nextInt();

		if(choose==1)
		{
			Admin admin=new Admin(userName,userPwd);
			adminService.createAdmin(admin);
		}
		else
		{
			Customer customer=new Customer(userName,userPwd);
			adminService.createCustomer(customer);
		}


	

	}

	public void printAdminDetails(User user)
	{
		System.out.println("Name of the Admin : "+user.userName);
	}

	public void printCustomerDetails(User user)
	{
		System.out.println("Name of the customer : "+user.userName);
	}

	public String getScreen()
	{
		System.out.print("Enter the screen name : ");
		String str=sc.nextLine();
		return str;
	}

	public String getKey()
	{
		System.out.print("Enter the show name : ");
		String str=sc.nextLine();
		if(str.equals("morning"))
		{
			return "Morning Show";
		}
		else if(str.equals("matinee"))
		{
			return "Matinee Show";
		}
		else if(str.equals("evening"))
		{
			return "Evening Show";
		}
		else
		{
			return "Night Show";
		}

	}

	public int getId()
	{
		System.out.print("Enter the movie Id : ");
		int n=sc.nextInt();
		return n;
	}



}

























































































