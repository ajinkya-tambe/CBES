package dto;

import java.util.*;

public class QADetailsDTO				//this dto will contain will have all the details related to the question
{
	private String questionText;			//quesiton statemen
	private Vector<String> answerOptions;		//all  the options
	private String answers;				//the correct anser of the question
	
	public QADetailsDTO(String questionText, Vector<String> answerOptions, String answers)
	{
		this.questionText = questionText;
		this.answerOptions = answerOptions;
		this.answers = answers;
	}

	public String getQuestionText()
	{
		return questionText;
	}

	public Vector<String> getAnswerOptions()
	{
		return answerOptions;
	}
	
	public String getAnswers()
	{
		return answers;
	}
	
	public void setQuestionText(String questionText)
	{
		this.questionText = questionText;
	}

	public void setAnswerOptions(Vector<String> answerOptions)
	{
		this.answerOptions = answerOptions;
	}

	public void setAnswers(String answers)
	{
		this.answers = answers;
	}

	public String toString()
	{
		return questionText + " \n " + answerOptions + " \n " + answers; 
	}
}