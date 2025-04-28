package service;

import models.*;
import dao.*;
import controller.*;
import java.util.*;

public class CustomerService
{
	public boolean login(String uName,String uPwd)
	{
		for(User customer:Database.customerList)
		{
			if(customer.userName.equals(uName))
			{
				if(customer.userPwd.equals(uPwd))
				{
					return true;
				}
			}
		}
		return false;
	}

	public void createCustomer(Customer customer)
	{
		Database.customerList.add(customer);
		System.out.println("Customer registered successfully...");
	}

}