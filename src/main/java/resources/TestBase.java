package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class TestBase {

public static WebDriver driver;
	
	public static Properties prop;
	public static int i=0;
	
	public WebDriver initializeDriver() throws IOException
	{
	    prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\priyanka.limaye\\eclipse-workspace\\Fox_qaclass_assignment\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if (browserName.equals("chrome"))
				{/*System.setProperty("webdriver.chrome.driver", "F:\\Chromedriver\\chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().window().maximize();*/
				//execute in chromedriver
				}
				
		else if(browserName.equals("IE"))
		{
		//execute in Internet explorer
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			//execute in firefox
	    }
		
		/*driver.get(prop.getProperty("url"));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);*/
		return driver;
	
	}

	public void getscreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile (src, new File ("C://Users//priyanka.limaye//eclipse-workspace//Fox_qaclass_assignment//Test//Screenshot.png"));
		Files.copy(src,new File("C://Users//priyanka.limaye//eclipse-workspace//Fox_qaclass_assignment//Test//"+result+i+"Screenshot.png"));
		i++;
		
	}
	/*@AfterTest
	public void tearDownTest() {
		//driver.quit();
	}*/

	

	
}
