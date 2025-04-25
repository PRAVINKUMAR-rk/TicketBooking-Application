package service;

import models.*;
import dao.*;
import controller.*;
import java.util.*;

public class UserService
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

}