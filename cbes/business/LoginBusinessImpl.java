package business;

import dto.*;
import dao.*;
import java.io.*;
import java.util.*;

public class LoginBusinessImpl implements LoginBusiness
{
	public int login(CredentialsDTO credentialsDTO)
	{
		//System.out.print(credentialsDTO);
		int flag = 0;
		Vector<RegistrationDTO> registrationList = LoginDAO.getRegistrationDetails();
		Enumeration<RegistrationDTO> e = registrationList.elements();
		while(e.hasMoreElements())
		{
			RegistrationDTO registrationDTO = e.nextElement();
			if(credentialsDTO.getUserName().equals(registrationDTO.getCredentialsDTO().getUserName()))
			{
				flag = 1;
				if(credentialsDTO.getPassword().equals(registrationDTO.getCredentialsDTO().getPassword()))
				{	
					flag = 2;
					break;	
				}

			}
			//System.out.println(registrationDTO);
		}
		return flag;			
	}
}