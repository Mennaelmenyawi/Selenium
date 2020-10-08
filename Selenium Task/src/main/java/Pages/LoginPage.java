package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.config;

public class LoginPage extends PageBase{
	public config configreader;
	public WebElement EmailInput;
	public WebElement Password;
	public WebElement loginbutton;

	public LoginPage(WebDriver driver) {
		super(driver);

		// TODO Auto-generated constructor stub
		configreader = new config("loginPagePaths.properties");
		getelements();
	}

	public void getelements ()
	{  	
		try {
			EmailInput = driver.findElement(By.xpath(configreader.Getproperities("Email")));
			Password = driver.findElement(By.xpath(configreader.Getproperities("Password")));
			loginbutton =  driver.findElement(By.xpath(configreader.Getproperities("loginbutton")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void UserCan_Login(String FirstName, String LastName , String Mobileno , String Email ,String password) throws InterruptedException
	{
		System.out.println(Email + " " + password);
		EmailInput.sendKeys(Email);
		Password.sendKeys(password);
		loginbutton.click();
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
				    public Boolean apply(WebDriver driver) {
				        return "https://www.phptravels.net/account/".equals(driver.getCurrentUrl().toString());
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
