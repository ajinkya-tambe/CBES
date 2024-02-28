package dto;

import java.io.*;

public class ExamEnrolmentDTO implements Serializable
{
	private String subjectName;
	private int semester;

	public ExamEnrolmentDTO(int semester, String subjectName)
	{
		this.subjectName = subjectName;
		this.semester = semester;
	}
	
	public String getSubjectName()
	{
		return subjectName;
	}
	
	public void setSubjectName(String subjectName)
	{
		this.subjectName = subjectName;
	}

	public int getSemester()
	{
		return semester;
	}

	public void setSemester(int semester)
	{
		this.semester = semester;
	}
	
	public String toString()
	{
		return "Subject Name = " + subjectName + " Semster = " + semester;
	}
}
