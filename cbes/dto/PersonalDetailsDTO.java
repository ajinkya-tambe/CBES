package dto;

import java.io.*;

public class PersonalDetailsDTO implements Serializable
{
	private String name;
	private int enrolNo;
	private String std;

	public PersonalDetailsDTO(String name, int enrolNo, String std)
	{
		this.name = name;
		this.enrolNo = enrolNo;
		this.std = std;
	}

	public String getName()
	{
		return name;
	}

	public int getEnrolNo()
	{
		return enrolNo;
	}

	public String getStd()
	{
		return std;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setEnrolNo(int enrolNo)
	{
		this.enrolNo = enrolNo;
	}

	public void setStd(String std)
	{
		this.std = std;
	}

	public String toString()
	{
		return "Name = " + name + " Enrolment No = " + enrolNo + " Class = " + std + " ";
	}
}
