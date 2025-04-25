package service;

import models.*;
import dao.*;
import controller.*;
import java.util.*;
public class AdminService
{

	public boolean login(String uName,String uPwd)
	{
		for(User admin:Database.adminList)
		{
			if(admin.userName.equals(uName))
			{
				if(admin.userPwd.equals(uPwd))
				{
					return true;
				}
			}
		}
		return false;
	}

	public void createMovie(Movie movie)
	{

		if(Database.screenList.size()!=0)
		{
			
			for(Screen screen:Database.screenList)
			{
				if(screen.screenName.equals(movie.screenName))
				{
					MovieController movieController=new MovieController();
					String str=movieController.printKey(movie);
					if(screen.details.get(str)==null)
					{
						screen.details.put(str,movie);
						Database.movieList.add(movie);
						System.out.println("Movie added successfully...");
					}
				}
			}
		}
		else
		{
			System.out.println("Sorry there is no screen is available");
		}
	}

	









	public void createScreen(Screen screen)
	{
		Database.screenList.add(screen);
		System.out.println("Screen added sucessfully...");
	}

	public void deleteScreen(String screenName)
	{
		Database.screenList.removeIf(sName->sName.screenName.equals(screenName));
		System.out.println("Movie deleted successfully...");
	}
	
	public void updateScreen(Screen screen)
	{
		AdminService adminService=new AdminService();
		adminService.createScreen(screen);
	}

	public void viewScreen()
	{
		ScreenController controller=new ScreenController();
		controller.printScreenDetails();
	}

	public boolean checkMovie(int id)
	{
		for(Movie movie:Database.movieList)
		{
			if(movie.movieId==id)
			{
				return true;
			}
		}
		return false;
	}
	
	public void deleteMovie(Movie movie)
	{
		if(Database.screenList.size()!=0)
		{
			for(Screen screen:Database.screenList)
			{
				if(screen.screenName.equals(movie.screenName))
				{
					MovieController movieController=new MovieController();
					String key=movieController.printKey(movie);
			
					Map<String,Movie>mp=screen.details;
					boolean flag=false;
					if(mp.containsKey(key))
					{
						Movie m=mp.get(key);
						if(m!=null)
						{
							if(m.title.equals(movie.title))
							{
								mp.put(key,null);
								Database.movieList.removeIf(mId->mId.movieId==movie.movieId);
								System.out.println("Movie successfully removed from the database..");
								break;
							}
							else
							{
								flag=true;
							}
						}
						if(flag)
						{
							System.out.println("Sorry! The given movie is not assigned to this show time...");
						}
						else
						{
							System.out.println("Already the show is empty...");
						}
					}
				}
			}
		}
	}

	public void viewMovie()
	{
		if(Database.movieList.size()!=0)
		{
			MovieController controller=new MovieController();
			for(Movie movie:Database.movieList)
			{
				System.out.println("------------------------------------------------------------");
				controller.printMovieDetails(movie);
			}
			System.out.println("All the available movie details would be displayed successfully...");
		}
		else
		{
			System.out.println("Oops! There is no movie is available in theatre....");
		}
	}

}
































