package ui;

import java.io.*;
import java.util.*;
import dto.*;
import ui.*;

public class CBESUI
{
	public static void main(String args[]) throws IOException, FileNotFoundException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome!!");
		System.out.println("Please choose appropriate option: ");
		System.out.println("1 - Signup");
		System.out.println("2 - Login.");
		System.out.print("Enter your choice: ");
		int task = sc.nextInt();
		sc.nextLine();
		switch(task)
		{
			case 1:
				RegistrationUI.registerUser();		
				break;
			case 2:
				CredentialsDTO credentialsDTO = new CredentialsDTO(null, null); //creating this null obj to get username which we will use while taking Exam
				boolean result = LoginUI.login(credentialsDTO);			//passing the null obj
				if(result)
				{
					System.out.print("\nAre you ready to take up an exam[0/1]: ");
					int choice = sc.nextInt();
					if(choice == 1)
					{
						ExamUI.attendExam(credentialsDTO.getUserName());
					}
				}
				break;
			default:
				System.out.print("Invalid choice!");
		}
	}
}