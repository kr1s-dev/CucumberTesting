package CucumberTesting.AutomationSalesforceTesting.util;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	protected static WebDriver driver;
	protected File file; 
	protected PropertyReader reader;
	
	public DriverFactory(){
		reader = new PropertyReader();
		initializeDriver();
	}
	
	public void initializeDriver(){
		if(driver==null)
			createNewDriverInstance();
	}

	private void createNewDriverInstance() {
		String os = System.getProperty("os.name");
		String path = "src/test/resources/driver/";
		String browser = reader.readProperty("browser");
		if(os.toLowerCase().equals("windows")){
			path+="windows/";
		}else if(os.toLowerCase().equals("linux")){
			path+="linux/";
		}
		
		path+= (browser.equals("chrome")?
				"chromedriver":
					browser.equals("firefox")?
						"firefoxdriver"
							:"") + (os.toLowerCase().equals("windows")?".exe":"");
		
		file = new File(path);
		
		switch (browser.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.firefox.driver", file.getAbsolutePath());
				driver = new FirefoxDriver();
				break;
		}	
	}
	
	public WebDriver getDriver() {
        return driver;
    }

    public void destroyDriver() {
        driver.quit();
        driver = null;
    }
}
