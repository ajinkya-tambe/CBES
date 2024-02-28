package dto;

public class ExamDTO 
{
	private PersonalDetailsDTO personalDetailsDTO;
	private ExamEnrolmentDTO examEnrolmentDTO;
	private QADTO qaDTO;
	
	public ExamDTO(PersonalDetailsDTO personalDetailsDTO, ExamEnrolmentDTO examEnrolmentDTO, QADTO qaDTO)
	{
		this.personalDetailsDTO = personalDetailsDTO;
		this.examEnrolmentDTO = examEnrolmentDTO;	
		this.qaDTO = qaDTO;
	}

	public PersonalDetailsDTO getPersonalDetailsDTO()
	{
		return personalDetailsDTO;
	}
	
	public ExamEnrolmentDTO getExamEnrolmentDTO()
	{
		return examEnrolmentDTO;
	}
	
	public QADTO getQADTO()
	{
		return qaDTO;
	}

	public void setPersonalDetailsDTO(PersonalDetailsDTO personalDetailsDTO)
	{
		this.personalDetailsDTO = personalDetailsDTO;
	}
	
	public void setExamEnrolmentDTO(ExamEnrolmentDTO examEnrolmentDTO)
	{
		this.examEnrolmentDTO = examEnrolmentDTO;
	}
	
	public void setQADTO(QADTO qaDTO)
	{
		this.qaDTO = qaDTO;
	}

	public String toString()
	{
		return personalDetailsDTO.toString() + " \n " + examEnrolmentDTO.toString() + " \n " + qaDTO.toString(); 
	}
}