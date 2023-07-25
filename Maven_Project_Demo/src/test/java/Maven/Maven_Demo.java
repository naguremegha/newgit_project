package Maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Maven_Demo {
	
	@Test
	public void testmaven()
	{
		ExtentReports reports = new ExtentReports();
		ExtentHtmlReporter report = new ExtentHtmlReporter("./test-output/old/extentreport.html");
		reports.attachReporter(report);
		ExtentTest test = reports.createTest("demo extent report generation").assignAuthor("Megha");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.quit();
	}

}
