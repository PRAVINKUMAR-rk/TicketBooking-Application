package service;

import models.*;
import dao.*;
import controller.*;
import java.util.*;
public class AdminService
{

	public void createAdmin(Admin admin)
	{
		Database.adminList.add(admin);
		System.out.println("Admin created successfully...");
	}

	public void createCustomer(Customer customer)
	{
		Database.customerList.add(customer);
		System.out.println("Customer created successfully");
	}

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
		createScreen(screen);
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
				System.out.println("------------------------------------------------------------");
			}
			System.out.println("All the available movie details would be displayed successfully...");
		}
		else
		{
			System.out.println("Oops! There is no movie is available in theatre....");
		}
	}

	public void viewScreen()
	{
		if(Database.screenList.size()!=0)
		{
			ScreenController screenController=new ScreenController();
			for(Screen screen : Database.screenList)
			{
				
				screenController.printScreenDetails(screen);
			}
			System.out.println("All the available screen details would be displayed successfully...");
		}
		else
		{
			System.out.println("Oops! There is no screen is available in theatre....");
		}
	}

	public void viewAdmin()
	{
		if(Database.adminList.size()!=0)
		{
			AdminController adminController=new AdminController();
			for(User user : Database.adminList)
			{
				
				adminController.printAdminDetails(user);
			}
			System.out.println("All the available admin details would be displayed successfully...");
		}
		else
		{
			System.out.println("Oops! There is no admin is available now....");
		}
	}

	public void viewCustomer()
	{
		if(Database.customerList.size()!=0)
		{
			AdminController adminController=new AdminController();
			for(User user : Database.customerList)
			{
				
				adminController.printCustomerDetails(user);
			}
			System.out.println("All the available customer details would be displayed successfully...");
		}
		else
		{
			System.out.println("Oops! There is no customer is available now....");
		}
	}



	public void changeMovie(Movie movie)
	{
		if(Database.screenList.size()!=0)
		{
			ScreenController screenController=new ScreenController();
			for(Screen screen:Database.screenList)
			{
				if(screen.screenName.equals(movie.screenName))
				{
					Map<String,Movie>mp=screen.details;
					MovieController movieController=new MovieController();
					String key=movieController.printKey(movie);
					Database.movieList.add(movie);
					mp.put(key,movie);
					System.out.println("Screen updated succesfully...");
				}
			}
		}
	}

	public void assignMovie()
	{
		AdminController adminController=new AdminController();
		String key=adminController.getKey();
		String sName=adminController.getScreen();
		int id=adminController.getId();
		for(Movie m:Database.movieList)
		{
			if(m.movieId==id)
			{
				for(Screen screen:Database.screenList)
				{
					if(screen.screenName.equals(sName))
					{
						if(screen.details.get(key)==null)
						{
							screen.details.put(key,m);
							System.out.println("Movie added successfully...");
						}
					}
				}
				
			}
		}
	}

}
































