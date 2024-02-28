package dao;

import java.io.*;
import java.util.*;
import dto.*;

public class LoginDAO
{
	public static Vector<RegistrationDTO> getRegistrationDetails()
	{
		Vector<RegistrationDTO> registrationList = new Vector<RegistrationDTO>();
		File f = new File(DAOConstants.REGISTRATION_DB_PATH);
		File[] files = f.listFiles();
		for (File file : files)
		{
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
			{
				RegistrationDTO registrationDTO = (RegistrationDTO) ois.readObject(); //typecasting
				registrationList.add(registrationDTO);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}	
		return registrationList;
	}
}