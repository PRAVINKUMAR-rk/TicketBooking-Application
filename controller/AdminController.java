package controller;

import models.*;
import dao.*;
import service.*;
import java.util.*;

public class AdminController
{
	public void loginDetails()
	{
		Scanner sc=new Scanner(System.in);
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
                		System.out.println("1 -> Create Movie");
                		System.out.println("2 -> Create Screen");
                		System.out.println("3 -> View Booking Details");
                		System.out.println("4 -> Delete Movie");
				System.out.println("5 -> Screen Details");
				System.out.println("6 -> Movie Details");
				System.out.println("7 -> Update Screen");
				System.out.println("8 -> Exit");
                		System.out.print("Choose: ");
                		int adminChoice = sc.nextInt();
                		sc.nextLine();

                		switch (adminChoice) 
                		{
                    			
					case 1:
                        			MovieController movieController1=new MovieController();
						Movie movie1=movieController1.movieDetails();
						adminService.createMovie(movie1);
                        			break;
                    			case 2:
                        			ScreenController screenController1=new ScreenController();
						Screen screen1=screenController1.screenDetails();
						adminService.createScreen(screen1);
                        			break;
                    			case 3:
                        			break;
                    			case 4:
                        			MovieController movieController2=new MovieController();
						Movie movie2=movieController2.movieDetails();
						adminService.deleteMovie(movie2);
                        			break;
		    			case 5:
						adminService.viewScreen();
						break;
                    			case 6:
                        			adminService.viewMovie();										
						break;
					case 7:
                        													
						break;

					case 8:
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
}

























































































