package tests;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Data.ExcelReader;
import Pages.LoginPage;
import Pages.RegistrationPage;

public class User_RegisterSuccessfullyTest extends TestBase {
	RegistrationPage    Create_AccountObj ; 
	LoginPage   Login_Object ;
	String Mail ;
	String Mob ;
	String first_Name ;
	String last_Name;
	String Pass ; 
	
	@DataProvider(name="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		ExcelReader ER=new ExcelReader();
		return ER.getExcelData();
	}
	
	@Test(dataProvider="ExcelData" )
	public void user_SignupSuccessfully (String first_Name , String last_Name , String Mob ,String Mail ,String Pass) throws InterruptedException 
	{
		Create_AccountObj= new RegistrationPage(driver);
        Create_AccountObj.UserCan_Register(first_Name, last_Name, Mob, Mail, Pass);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
	}
	
	@Test(dependsOnMethods = {"user_SignupSuccessfully"}, dataProvider="ExcelData" )
	public void user_Login (String first_Name , String last_Name , String Mob ,String Mail ,String Pass) throws InterruptedException
	{
		Login_Object = new LoginPage(driver);
		Login_Object.UserCan_Login(first_Name, last_Name, Mob, Mail, Pass);	
	}
}
	
	
	

