package dto;

import java.util.*;

public class QADTO
{
	private HashMap<String, QADetailsDTO> qaDetails;		
	
	public QADTO(HashMap<String, QADetailsDTO> qaDetails)
	{
		this.qaDetails = qaDetails;
	}

	
	public HashMap<String, QADetailsDTO> getQADetails()
	{
		return qaDetails;
	}
	
	public void setQADetails(HashMap<String, QADetailsDTO> qaDetails)
	{
		this.qaDetails = qaDetails;
	}

	public String toString()
	{
		return qaDetails.toString(); 
	}
}
