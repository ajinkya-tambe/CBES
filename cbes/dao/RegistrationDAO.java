package dao;

import dto.*;
import java.io.*;

public class RegistrationDAO 
{	
	public static boolean storeRegistrationDetails(RegistrationDTO registrationDTO)
	{
		ObjectOutputStream oos = null;
		try
		{
			File f = new File(DAOConstants.REGISTRATION_DB_PATH);
			f.mkdir();
			oos = new ObjectOutputStream(new FileOutputStream(new File(f, registrationDTO.getPersonalDetailsDTO().getName() + ".out"), true));
			oos.reset();
			oos.writeObject(registrationDTO);
			oos.flush();
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		finally
		{
			try
			{
				oos.close();	
			}
			catch(Exception e)
			{
				System.out.println(e);
				return false;
			}
		}
		return true;
	}
}
