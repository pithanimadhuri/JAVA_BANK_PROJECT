import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;



public class Data 
{
	Connection con;
	public Data()throws ClassNotFoundException, SQLException
	{
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "123456");
	    
	}
	
	//Account Creation
	public void AccountCreation(String AccName) throws SQLException
	{
		Random rnd = new Random();
	    String AccNum = Integer.toString(rnd.nextInt(999999));
	    int Balance=0;   
	    PreparedStatement stmt=con.prepareStatement("insert into BANK values(?,?,?)");  
	    stmt.setString(1,AccNum);
	    stmt.setString(2,AccName);
	    stmt.setInt(3,Balance);
	    int i=stmt.executeUpdate();
	    System.out.println("Account Successfully Created...");
	    System.out.println("Your Account Number: " +AccNum);
	}
	
	
	//Show Balance
	public void ShowBalance(String AccNum)throws SQLException
	{
		java.sql.Statement  st =  con.createStatement();    
        ResultSet rs = st.executeQuery("select balance from BANK where accnum = "+AccNum+" ");
        
        if(rs.next())
        {
        	System.out.println("Your Account(" +AccNum +") Balance: " +rs.getString(1));
        }
        else
        {
        	System.out.println("Enter Valid Account Number");
        }
	}
	
	//Deposit
	public void Deposit(String AccNum, int Amount) throws SQLException
	{
		java.sql.Statement  st =  con.createStatement();    
        ResultSet rs = st.executeQuery("select balance from BANK where accnum = "+AccNum+" ");
        rs.next();
        int Balance = rs.getInt(1);
        Balance = Balance + Amount;
        //Update Balance
        int rows = st.executeUpdate("update BANK set balance = "+ Balance+" where accnum = "+ AccNum +" ");
        System.out.println("Successfully Deposited");
        System.out.println("Updated Balance:" +Balance);
        
		
	}
	
	//Withdrawal
	public void Withdrawal(String AccNum, int Amount)throws SQLException
	{
		java.sql.Statement  st =  con.createStatement();    
        ResultSet rs = st.executeQuery("select balance from BANK where accnum = "+AccNum+" ");
        rs.next();
        int Balance = rs.getInt(1);
        if(Amount<=Balance)
        {
        Balance = Balance - Amount;
        //Update Balance
        int rows = st.executeUpdate ("update BANK set balance = "+ Balance+" where accnum = "+ AccNum +" ");
        System.out.println("Updated Balance:" +Balance);
        System.out.println("Successfully Withdrawn");
        }
        else
        {
        	System.out.println("Insufficient Balance");
        }
	}
	
}
