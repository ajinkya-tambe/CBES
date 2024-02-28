package business;

import dao.*;
import dto.*;
import java.util.*;

public class ExamBusinessImpl implements ExamBusiness
{
	private static final int QUESTION_COUNT = 10;
	private static final int MAX_QUESTIONS_COUNT = 100;	
	public HashMap<Integer, String> getSubjectNames(int semester)
	{
		HashMap<Integer, String> subjectNames = new HashMap<Integer, String>();
		Properties p = ExamDAO.getSubjectNames();
		//System.out.println(p);
		Enumeration e = p.propertyNames();
		while(e.hasMoreElements())
		{
			String key = (String) e.nextElement();
			if(key.startsWith(String.valueOf(semester)))
			{
				subjectNames.put(Integer.parseInt(key.split("\\.")[1]), (String)p.getProperty(key)); 			//slpitting the key
			}
		}
		return subjectNames;
	}

	public PersonalDetailsDTO getPersonalDetails(String userName)
	{
		Vector<RegistrationDTO> registrationList = LoginDAO.getRegistrationDetails();
		Enumeration<RegistrationDTO> e = registrationList.elements();
		while(e.hasMoreElements())
		{
			RegistrationDTO registrationDTO = e.nextElement();
			if(userName.equals(registrationDTO.getCredentialsDTO().getUserName()))
			{
				return registrationDTO.getPersonalDetailsDTO();
			}
		}
		return null;			
	}

	public QADTO getQADetails(ExamEnrolmentDTO examEnrolmentDTO)
	{
		//System.out.println("here");
		QADTO qaDTO = ExamDAO.getQADetails(examEnrolmentDTO);
		HashMap<String, QADetailsDTO> qaDetails = qaDTO.getQADetails();
		HashMap<String, QADetailsDTO> filteredQADetails = new HashMap<String, QADetailsDTO>(); 			// 10 questions.
		int cnt = 0;
		String questionPrefix = examEnrolmentDTO.getSemester() + "_" + examEnrolmentDTO.getSubjectName() + "_Q";
		do
		{
			int no = (int)(Math.random() * MAX_QUESTIONS_COUNT);
			String questionKey = questionPrefix + "_" + no;
			QADetailsDTO qaDetailsDTO = qaDetails.get(questionKey);
			if(qaDetailsDTO != null)
			{
				if(filteredQADetails.get(questionKey) == null)
				{
					filteredQADetails.put(questionKey , qaDetailsDTO);
					cnt++;
				}
			}
		}while(cnt < QUESTION_COUNT);
		return new QADTO(filteredQADetails); 
	}
}



