package controller;

import models.*;
import service.*;
import dao.*;
import java.util.*;

public class MovieController
{
	Scanner sc=new Scanner(System.in);
	public Movie movieDetails()
	{
		
		System.out.print("Enter the movie id: ");
        	int id = sc.nextInt();
        	sc.nextLine();
        	System.out.print("Enter the screen name: ");
        	String screen = sc.nextLine();
        	System.out.print("Enter the movie title: ");
        	String title = sc.nextLine();
        	System.out.print("Enter the hero name: ");
        	String actor = sc.nextLine();
        	System.out.print("Enter the heroine name: ");
        	String actress = sc.nextLine();
        	System.out.print("Enter the director name: ");
        	String dir = sc.nextLine();
        	System.out.print("Enter the producer name: ");
        	String pro = sc.nextLine();
        	System.out.print("Enter the type of movie (Action/Drama/Thriller/Horror/Romance): ");
        	String typ = sc.nextLine();
		System.out.print("Enter the show name : ");
		String showName=sc.nextLine();

		return new Movie(id,screen, title, actor, actress, dir, pro, typ,showName);
		
	}

	public void printMovieDetails(Movie movie)
	{
		System.out.println("The movie ID is           : "+movie.movieId);
		System.out.println("Name of the screen        : "+movie.screenName);
		System.out.println("Show timing will be       : "+movie.showName);
		System.out.println("The title of the movie is : "+movie.title);
		System.out.println("Name of the hero          : "+movie.heroName);
		System.out.println("Name of the heroine       : "+movie.heroineName);
		System.out.println("The movie is directed by  : "+movie.director);
		System.out.println("The movie is produced by  : "+movie.producer);
		System.out.println("Genre of the movie will be: "+movie.type);
	}

	public String printKey(Movie movie)
	{
		if(movie.showName.equals("morning"))
		{
			return "Morning Show";
		}
		else if(movie.showName.equals("matinee"))
		{
			return "Matinee Show";
		}
		else if(movie.showName.equals("evening"))
		{
			return "Evening Show";
		}
		else
		{
			return "Night Show";
		}
	}

	
	
}




























