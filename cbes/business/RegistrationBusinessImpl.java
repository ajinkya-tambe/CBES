package business;

import dto.*;
import dao.*;

public class RegistrationBusinessImpl implements RegistrationBusiness
{
	public boolean registerUser(RegistrationDTO registrationDTO)
	{
		return RegistrationDAO.storeRegistrationDetails(registrationDTO);
	}
}
