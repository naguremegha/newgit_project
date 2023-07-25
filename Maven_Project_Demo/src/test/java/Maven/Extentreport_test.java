package Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extentreport_test {
	
	@Test
	public void extentreportTest()
	{
		
		ExtentReports reports = new ExtentReports();
		ExtentHtmlReporter report = new ExtentHtmlReporter("./test-output/old/extentreport.html");
		reports.attachReporter(report);
		ExtentTest test = reports.createTest("demo extent report generation").assignAuthor("Megha");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com");
		driver.findElement(By.cssSelector("input[placeholder = 'Search']")).sendKeys("kannada songs");
		driver.findElement(By.cssSelector("button[class='style-scope ytd-searchbox']")).click();
		driver.findElement(By.className("style-scope ytd-video-preview")).click();
		test.log(Status.FAIL, "song play");
		reports.flush();
	}

}
