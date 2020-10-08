import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class CustomReports implements ITestListener {

	public void onTestFailure(ITestResult result) {
		ITestContext context = result.getTestContext();
	    WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
	    try 
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, 0)");
		TakesScreenshot ts=(TakesScreenshot)driver;

		File source=ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(source, new File("/home/sit/eclipse-workspace/Selenium Task/test-output/Screenshots/"+result.getName()+".png"));

		driver.quit();
		} 
		catch (Exception e)
		{

		System.out.println("Exception while taking screenshot "+e.getMessage());
		}
	}

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		
		for (ISuite suite : suites) {
			String suiteName = suite.getName();
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();
				System.out.println("Passed tests for suite " + suiteName + " is: " + tc.getPassedTests().getAllMethods().size());
				System.out.println("Failed tests for suite " + suiteName + " is: " + tc.getFailedTests().getAllMethods().size());
				System.out.println("Skipped tests for suite " + suiteName + " is: " + tc.getSkippedTests().getAllMethods().size());
			}
		}
	}
	
	
}
