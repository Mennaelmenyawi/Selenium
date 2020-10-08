package Pages;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import configurations.config;

public class RegistrationPage extends PageBase{
	public config configreader;
	public WebElement Signup;
	public WebElement Signupbutton;
	public WebElement First_Name;
	public WebElement lastName1;
	public WebElement MobileNumber;
	public WebElement EmailField;
	public WebElement Password1;
	public WebElement ConfirmPassword;
	public WebElement First_name1;
	public WebElement Last_name;
	public WebElement Mobile;
	public WebElement Email_Signup;
	public WebElement Pass;
	public WebElement Pass_confirm;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		driver.get("https://www.phptravels.net/register");
		// TODO Auto-generated constructor stub
		configreader = new config("Registerationpaths.properties");
		getelements();
	}
	
public void getelements (){  	
	try {
		Signup = driver.findElement(By.xpath(configreader.Getproperities("Signup")));
		First_name1 = driver.findElement(By.xpath(configreader.Getproperities("First_name1")));
		First_Name = driver.findElement(By.xpath(configreader.Getproperities("First_Name")));
		Last_name = driver.findElement(By.xpath(configreader.Getproperities("Last_name")));
		lastName1 = driver.findElement(By.xpath(configreader.Getproperities("lastName")));
		Mobile = driver.findElement(By.xpath(configreader.Getproperities("Mobile")));
		MobileNumber = driver.findElement(By.xpath(configreader.Getproperities("MobileNumber")));
		Email_Signup = driver.findElement(By.xpath(configreader.Getproperities("Email_Signup")));
		EmailField = driver.findElement(By.xpath(configreader.Getproperities("EmailField")));
		Pass = driver.findElement(By.xpath(configreader.Getproperities("Pass")));
		Password1 = driver.findElement(By.xpath(configreader.Getproperities("Password")));
		Pass_confirm = driver.findElement(By.xpath(configreader.Getproperities("Pass_confirm")));
		ConfirmPassword = driver.findElement(By.xpath(configreader.Getproperities("ConfirmPassword")));
		Signupbutton =  driver.findElement(By.xpath(configreader.Getproperities("Signupbutton")));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	public void UserCan_Register(String FirstName, String LastName , String Mobileno , String Email ,String password  ) throws InterruptedException {
	{
		First_name1.click();
		First_Name.sendKeys(FirstName);
		Last_name.click();
		lastName1.sendKeys(LastName);
		Email_Signup.click();
		EmailField.sendKeys(Email);
		Thread.sleep(3000);
		Mobile.click();
		MobileNumber.sendKeys(Mobileno);
		Pass.click();
		Password1.sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Pass_confirm.click();
		ConfirmPassword.sendKeys(password);
		Signupbutton.click();

ExpectedCondition<Boolean> pageLoadCondition = new
ExpectedCondition<Boolean>() {
    public Boolean apply(WebDriver driver) {
        return "https://www.phptravels.net/account/".equals(driver.getCurrentUrl());
    }
};
WebDriverWait wait = new WebDriverWait(driver, 5);
wait.until(pageLoadCondition);
if ("https://www.phptravels.net/account/".equals(driver.getCurrentUrl())) {
	try {
		WebElement MyAccount = driver.findElement(By.xpath(configreader.Getproperities("MyAccount")));
		WebElement MyAccountDropDown = driver.findElement(By.xpath(configreader.Getproperities("MyAccountDropDown")));
		WebElement Logout = driver.findElement(By.xpath(configreader.Getproperities("Logout")));
		MyAccount.click();
		wait.until(ExpectedConditions.visibilityOf(MyAccountDropDown));
		Logout.click();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	}
}
	
	
}



