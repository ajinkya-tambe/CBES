package ui;

import java.util.*;
import dto.*;
import business.*;
import util.*;

public class ExamUI
{
	static Scanner sc = new Scanner(System.in);
	public static void attendExam(String userName)
	{
		ExamBusiness examBusiness = new ExamBusinessImpl();
		System.out.println();
		System.out.println("** Instructions **");
		System.out.println("1. This will be multi choice objective exam.");
		System.out.println("2. Exam will have 10 questions.");
		System.out.println("3. For multi choice questions, please enter your answer keys separated by comma(eg. 1, 3).");
		System.out.println();
		ExamEnrolmentDTO examEnrolmentDTO = acceptExamDetails(examBusiness);
		System.out.println(examEnrolmentDTO);
		PersonalDetailsDTO personalDetailsDTO = examBusiness.getPersonalDetails(userName);
		QADTO qaDTO = examBusiness.getQADetails(examEnrolmentDTO);
		//System.out.println(qaDTO);
		ExamDTO examDTO = new ExamDTO(personalDetailsDTO, examEnrolmentDTO, qaDTO);
		
		//displaying the questions one by one
		HashMap<String, QADetailsDTO> qaDetails = qaDTO.getQADetails();		//getting hashmap of 10 questions
		Iterator<String> itr = qaDetails.keySet().iterator();
		int cnt = 1;
		String answerPrefix = examEnrolmentDTO.getSemester() + "_" + examEnrolmentDTO.getSubjectName() + "_A_";
		int score = 0;
		sc.nextLine();
		Vector<String> userAnswers = new Vector<String>();
		while(itr.hasNext())
		{
			QADetailsDTO qaDetailsDTO = qaDetails.get(itr.next());
			System.out.println("Q" + cnt + ". " + qaDetailsDTO.getQuestionText());
			Vector<String> answerOptions = qaDetailsDTO.getAnswerOptions();
			for(String answerOption : answerOptions)
			{
				System.out.println(answerOption.substring(answerPrefix.length()));
			}
			cnt++;
			System.out.println();
			
			//accepting the answer 
			System.out.print("Enter your answer(s) separated by comma: ");
			String answer = sc.nextLine();
			String correctAnswer = qaDetailsDTO.getAnswers();
			correctAnswer = correctAnswer.replace(answerPrefix , "");
			answer = Util.sortString(answer).replace("," , "");
			correctAnswer = Util.sortString(correctAnswer).replace("," , "");
			if(answer.equals(correctAnswer))
			{
				score += 10;
			}
		}
		//ReportCardUI.getReportCard(examDTO, score);
		System.out.println("\n\n------------------------------------------------------");	
		System.out.println("REPORT CARD");
		System.out.println("Student name: " +personalDetailsDTO.getName());
		System.out.println("Student enrolment: " +personalDetailsDTO.getEnrolNo());
		System.out.println("Current year: "+personalDetailsDTO.getStd());
		System.out.println("Current semester: " +examEnrolmentDTO.getSemester());
		
		System.out.println("\nAppeared for: "+examEnrolmentDTO.getSubjectName());	
		System.out.println("Total questions: " +qaDetails.size());
		System.out.println("Final score: " +score);
		if(score >= 90)
			System.out.println("Grade : A");
		else if(score >= 60 && score <= 80)
			System.out.println("Grade : B");
		else if(score >= 40 && score <= 60)
			System.out.println("Grade : C");
		else
			System.out.println("Grade: Fail");
		//System.out.println("** Your score is: " + score + ". **");
	}
		
	public static ExamEnrolmentDTO acceptExamDetails(ExamBusiness examBusiness)
	{
		System.out.print("Enter your current semester (eg: 1, 2, 3, 4, 5, 6): ");
		int semester = sc.nextInt();
		System.out.println("Select the subject you want to appear for: ");
		HashMap<Integer, String> subjectNames = examBusiness.getSubjectNames(semester);		
		Iterator<Integer> itr = subjectNames.keySet().iterator();
		while(itr.hasNext())
		{
			int key = itr.next();
			System.out.println(key + ". " + subjectNames.get(key));
		}
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		String subjectName = subjectNames.get(choice);
		return new ExamEnrolmentDTO(semester, subjectName);
	}	
}
