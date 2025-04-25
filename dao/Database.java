package dao;

import models.*;
import service.*;
import java.util.*;

public class Database
{
	public static Set<User> adminList = new LinkedHashSet<>();
	public static Set<User> customerList = new LinkedHashSet<>();
	public static Set<Movie> movieList = new LinkedHashSet<>();
	public static Set<Screen> screenList = new LinkedHashSet<>();
}