package ui;

import ui.*;
import dto.*;
import business.*;
import java.util.*;

public class LoginUI
{
	public static boolean login(CredentialsDTO credDTO) 				//getting the null obj here
	{
		CredentialsDTO credentialsDTO = RegistrationUI.getCredentials(); 	//getting credentials from user to get logged in
		int result = new LoginBusinessImpl().login(credentialsDTO);			//passing the entered info to Business to check if we have the user
		if(result == 2)	
		{
			System.out.println("User " + credentialsDTO.getUserName() + " logged in successfully!");
			credDTO.setUserName(credentialsDTO.getUserName());		//as we got the correct username, here we are setting tht in place of null
			return true;
		}
		else if(result == 1)
		{
			System.out.println("Credentials are incorrect..");
			return false;
		}	
		else
		{
			System.out.print("User is not registered, press 1 if you want to signup else press 0: ");
			int input = new Scanner(System.in).nextInt();
			if(input == 1)
				RegistrationUI.registerUser();
			return false;
		}
		
	}
	
}