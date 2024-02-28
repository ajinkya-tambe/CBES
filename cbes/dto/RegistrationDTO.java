package dto;

import java.io.*;

public class RegistrationDTO implements Serializable
{
	private PersonalDetailsDTO personalDetailsDTO;
	private CredentialsDTO credentialsDTO;

	public RegistrationDTO(PersonalDetailsDTO personalDetailsDTO, CredentialsDTO credentialsDTO)
	{
		this.personalDetailsDTO = personalDetailsDTO;
		this.credentialsDTO = credentialsDTO;
	}

	public PersonalDetailsDTO getPersonalDetailsDTO()
	{
		return personalDetailsDTO;
	}

	public CredentialsDTO getCredentialsDTO()
	{
		return credentialsDTO;
	}

	public void setPersonalDetailsDTO(PersonalDetailsDTO personalDetailsDTO)
	{
		this.personalDetailsDTO = personalDetailsDTO;
	}

	public void getCredentialsDTO(CredentialsDTO credentialsDTO)
	{
		this.credentialsDTO = credentialsDTO;
	}

	public String toString()
	{
		return personalDetailsDTO.toString() + credentialsDTO.toString();
	
	}
}
