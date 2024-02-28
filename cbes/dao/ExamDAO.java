package dao;

import dto.*;
import java.io.*;
import java.util.*;

public class ExamDAO
{
	public static Properties getSubjectNames()
	{
		Properties subjectNames = null;
		try
		{
			subjectNames = new Properties();
			subjectNames.load(new FileReader(DAOConstants.SUBJECT_NAMES_DB_PATH));
		}
		catch(Exception e)
		{																	
			System.out.println(e);
		}
		return subjectNames;
	}
	
	public static QADTO getQADetails(ExamEnrolmentDTO examEnrolmentDTO)
	{
		String questionPaperFileName = examEnrolmentDTO.getSemester() + "_" + examEnrolmentDTO.getSubjectName() + "_question_paper.txt";
		String questionPaperFilePath = DAOConstants.QUESTION_PAPER_DB_PATH + File.separator + questionPaperFileName;
		HashMap<String, QADetailsDTO> qaDetails = new HashMap<String, QADetailsDTO>();
		try (BufferedReader br = new BufferedReader(new FileReader(questionPaperFilePath)))
		{
			String questionPrefix = examEnrolmentDTO.getSemester() + "_" + examEnrolmentDTO.getSubjectName() + "_Q";
			String answerPrefix =  examEnrolmentDTO.getSemester() + "_" + examEnrolmentDTO.getSubjectName() + "_A";
			String questionText = "";
			String questionKey = "";
			Vector<String> answerOptions = new Vector<String>();
			String answers = "";
			while(true)
			{
				String line = br.readLine();
				//System.out.println(line);
				if(line == null)			//end of file
					break;
				String lastRead = "";
				if (line.startsWith("**********************************************"))
				{
					QADetailsDTO qaDetailsDTO = new QADetailsDTO(questionText, answerOptions, answers);
					qaDetails.put(questionKey, qaDetailsDTO);			//adding in hahmap
					questionText = "";						//resetting all the variables
					questionKey = null;
					answerOptions = new Vector<String>();				
					answers = "";
				}	
				else if(line.startsWith(questionPrefix))
				{
					lastRead = "Q";
					String tokens[] = line.split("\\.");
					questionKey = tokens[0];
					questionText = tokens[1];
					for(int i = 2; i < tokens.length; i++)
					{
						questionText = questionText + "." +  tokens[i];	
					}
				}
				else if(line.startsWith(answerPrefix))
				{
					lastRead = "A";
					String tokens[] = line.split("\\.");
					String answerKey = tokens[0];
					int index = answerKey.indexOf('*');
					String answerText = line;
					if (index != -1)
					{
						answers += answerKey.trim().substring(0, answerKey.trim().length()-1) + ",";
						answerText = line.substring(0, index) + line.substring(index+1);
					}
					
					answerOptions.add(answerText);
				}
				else
				{
					if(lastRead.equals("Q"))
					{
						questionText += line;
					}
					else if(lastRead.equals("A"))
						answerOptions.add(line);					
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return new QADTO(qaDetails);
	}

	/*public static void main(String args[])
	{
		QADTO qaDTO = getQADetails(new ExamEnrolmentDTO(5, "Java"));
		System.out.println(qaDTO);
	}*/
}
