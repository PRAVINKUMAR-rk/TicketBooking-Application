package controller;

import models.*;
import service.*;
import dao.*;
import java.util.*;


public class UserController
{
	public void registerUser()
	{
		Scanner sc=new Scanner(System.in);
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
			UserService userService=new UserService();
			userService.createAdmin(admin);
		}
		else
		{
			Customer customer=new Customer(userName,userPwd);
			UserService userService=new UserService();
			userService.createCustomer(customer);
		}
	}
}