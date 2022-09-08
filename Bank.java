import java.sql.SQLException;
import java.util.Scanner;

public class Bank 
{

	public static void main(String[] args)throws ClassNotFoundException, SQLException
	{
		int Option=1;
		String UserName;
		Scanner SC = new Scanner(System.in);
		Data AmdocsBank = new Data();		
		while(Option!=0)
		{
		System.out.println("1.New User");
		System.out.println("2.Existing USer");
		System.out.println("0.Exit");
		Option = Integer.parseInt(SC.nextLine());
			if(Option==1)//New User
			{
				UserName="";
				System.out.println("New Account Creation.");
				System.out.println("Enter Your Name To Open Account.");
				UserName = SC.nextLine();
				if(UserName!=null)
				{
				AmdocsBank.AccountCreation(UserName);
				Option=0;
				System.out.println("Thank You...");
				}
				
			}
			else //Existing User
			{
				System.out.println("1.Check Balance");
				System.out.println("2.Desposit");
				System.out.println("3.Withdrawal");
				
				Option = Integer.parseInt(SC.nextLine());
				if(Option==1)
				{
					//Check Balance
					System.out.print("Enter your Account Number: ");
					String AccNum = SC.nextLine();
					AmdocsBank.ShowBalance(AccNum);
					
					
				}
				else if(Option==2)
				{
					
					//Deposit
					System.out.print("Enter your Account Number: ");
					String AccNum = SC.nextLine();
					System.out.print("Enter the Amount: ");
					int Amount = Integer.parseInt(SC.nextLine());
					AmdocsBank.Deposit(AccNum,Amount);
					
				}
				else if(Option==3)
				{
					//Withdrawal
					System.out.println("Enter your Account Number:");
					String AccNum = SC.nextLine();
					System.out.println("Enter the Amount:");
					int Amount = Integer.parseInt(SC.nextLine());
					AmdocsBank.Withdrawal(AccNum,Amount);
				}
				else
				{
					System.out.println("Try Again...");
				}
				
			}//else Ending
			
		}//While Ending

	}
}
