package controller;

import models.*;
import service.*;
import dao.*;
import java.util.*;


public class ScreenController
{
	public Screen screenDetails()
	{
		Scanner sc=new  Scanner(System.in);
		System.out.print("Enter the Screen Name : ");
		String screenName=sc.nextLine();
		
		Map<String, Movie>details=new LinkedHashMap<>();
		
		details.put("Morning Show",null);
		details.put("Matinee Show",null);
		details.put("Evening Show",null);
		details.put("Night Show",null);

		return new Screen(screenName,details);
	}

	public void printScreenDetails()
	{
		if(Database.screenList.size()!=0)
		{
			for(Screen screen:Database.screenList)
			{
				System.out.println("------------------------------------------------------------");
				System.out.println("Name of the screen : "+screen.screenName);

			
				for(Map.Entry<String,Movie>en:screen.details.entrySet())
				{
					String name=en.getKey();
					Movie movie=en.getValue();
					AdminService adminService=new AdminService();
					
					if(movie!=null)
					{
						boolean flag=adminService.checkMovie(movie.movieId);
						if(flag)
						{
							System.out.println(name+" : "+movie.getTitle()+" ");
						}
						else
						{
							System.out.println(name+" : "+"No movie is assigned...");
						}
					}
					else
					{
						System.out.println(name+" : "+"No movie is assigned...");
					}	
				}


				System.out.println("------------------------------------------------------------");
			
			}
		}
		else
		{
			System.out.println("Oops! There is no screen is available in theatre....");
		}
	}
}













