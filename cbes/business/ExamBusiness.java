package business;

import dto.*;
import java.util.*;

public interface ExamBusiness
{
	int QUESTION_COUNT = 10;
	int MAX_QUESTIONS_COUNT = 100;	
	public HashMap<Integer, String> getSubjectNames(int semester);
	public PersonalDetailsDTO getPersonalDetails(String userName);
	public QADTO getQADetails(ExamEnrolmentDTO examEnrolmentDTO);
}



