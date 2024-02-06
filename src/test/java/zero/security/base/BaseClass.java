package zero.security.base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {

	public static WebDriver webDriver;
	FileReader fileReader;
	protected static Properties properties = new Properties();
	

	@BeforeTest()
	public void setUp() throws IOException {
		// TODO Auto-generated method stub
		if (webDriver == null) {
			String path = System.getProperty("user.dir") + "\\src\\test\\resources\\Configuration\\zerosecurityconfiguration.properties";
			FileReader file = new FileReader(path);
			properties.load(file);
		}
		if (properties.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			webDriver = new EdgeDriver();
		} else if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			webDriver = new ChromeDriver();
		} else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			webDriver = new FirefoxDriver();
		}
		webDriver.manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		webDriver.close();

	}

}
