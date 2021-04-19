package MavenTest.MavenSubProject;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.ExtentReports;


public class ExtentReportTest {
	

	ExtentReports extent;

	@BeforeTest

	public void config()

	{

	// ExtentReports , ExtentSparkReporter
		// path variable will setup a reports folder under current project and will create index.html file

	String path =System.getProperty("user.dir")+"\\reports\\index.html";
	
	//ExtentSparkReported will configure report like, report name, document title, etc.

	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	
	reporter.config().setReportName("Web Automation Results");

	reporter.config().setDocumentTitle("Test Results");
	
	// ExternReports will execute the report for testcase

	extent =new ExtentReports();
	// attachReporter will add report to reporter object

	extent.attachReporter(reporter);

	extent.setSystemInfo("Tester", "Chandrakant Thakkar");

	}
	
	
	@Test
	public void driverinit() {
		
		ExtentTest test= extent.createTest("Initial Demo");

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get("https://demoqa.com/login");
	    driver.close();
	  //test.fail("Result do not match");
	    //Flush method is used to erase any previous data on the report and create a new report

	    extent.flush();

	}
	

}
