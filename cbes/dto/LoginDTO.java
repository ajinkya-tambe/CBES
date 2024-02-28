package ui;

import ui.*;
import dto.*;
import business.*;

public class LoginUI
{
	public static void login()
	{
		CredentialsDTO credentialsDTO = RegistrationUI.getCredentials();
		LoginBusiness.login(credentialsDTO);	
	}
	
}