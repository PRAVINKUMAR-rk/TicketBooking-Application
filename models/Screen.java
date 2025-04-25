package models;
import java.util.*;
public class Screen
{
	public String screenName;
	public Map<String,Movie>details=new LinkedHashMap<>();
	
	

	public Screen(String screen, Map<String,Movie>details)
	{
		this.screenName=screen;
		this.details=details;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(this==obj)
		{
			return true;
		}
		if(!(obj instanceof Screen))
		{
			return false;
		}

		Screen sample=(Screen)obj;
		return Objects.equals(screenName,sample.screenName);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(screenName);
	}

}