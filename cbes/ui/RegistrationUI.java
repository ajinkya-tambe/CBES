package ui;

import java.util.*;
import dto.*;
import business.*;

public class RegistrationUI
{
	static Scanner sc = new Scanner(System.in);
	public static void registerUser()
	{
		RegistrationDTO registrationDTO = getRegistrationDetails();			//here registrationDTo now contains two objs in it 
		boolean result = new RegistrationBusinessImpl().registerUser(registrationDTO);		//passing those two objs to business
		if (result)
		{
			System.out.println("User " + registrationDTO.getPersonalDetailsDTO().getName() + " is registered successfully");
			/*System.out.print("Do you want to get logged in [1/0]? ");
			int input = new Scanner(System.in).nextInt();
			if(input == 1)
				LoginUI.login();*/
		}
	}
	
	public static RegistrationDTO getRegistrationDetails()
	{
		return new RegistrationDTO(getPersonalDetails(), getCredentials());	
	}

	public static PersonalDetailsDTO getPersonalDetails()
	{
		System.out.println("Please provide the following Personal details: ");
		System.out.print("Enter your full name: ");
		String name = sc.nextLine();
		System.out.print("Enter your enrolment number: ");
		int enrol = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the year you are studying in (e.g. TY-H3): ");
		String std = sc.nextLine();
		return new PersonalDetailsDTO(name, enrol, std);
	}

	public static CredentialsDTO getCredentials()
	{
		System.out.println();
		System.out.println("Please provide the following credential details: ");
		System.out.print("Enter your username: ");
		String userName = sc.nextLine();
		System.out.print("Enter your password: ");
		String password = sc.nextLine();
		return new CredentialsDTO(userName, password);
	}
}
