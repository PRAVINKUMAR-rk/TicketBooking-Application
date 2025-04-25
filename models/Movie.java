package models;

import java.util.*;

public class Movie
{
    public int movieId;
    public String screenName;
    public String showName;
    public String title;
    public String heroName;
    public String heroineName;
    public String director;
    public String producer;
    public String type;
    public Movie(int id,String screenName,String tit,String actor,String actress,String dir,String pro,String typ,String showName)
    {
        this.movieId=id;
        this.screenName=screenName;
        this.title=tit;
        this.heroName=actor;
        this.heroineName=actress;
        this.director=dir;
        this.producer=pro;
        this.type=typ;
	this.showName=showName;
    }

	

	@Override
	public boolean equals(Object obj)
	{
		if(this==obj)
		{
			return true;
		}
		if(!(obj instanceof Movie))
		{
			return false;
		}
		
		Movie m=(Movie)obj;

		return Objects.equals(movieId,m.movieId);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(movieId);
	}








    public String getTitle()
    {
        return title;
    }
    public String getHeroname()
    {
        return heroName;
    }
    public String getHeroineName()
    {
        return heroineName;
    }
    public String getDirector()
    {
        return director;
    }
    public String getProducer()
    {
        return producer;
    }
    public String getType()
    {
        return type;
    }
    public String getShowName()
    {
	return showName;
    }
}