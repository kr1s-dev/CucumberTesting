package CucumberTesting.AutomationSalesforceTesting.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
	protected WebDriver driver;
	protected String baseURL;
	
	public AbstractPage(WebDriver driver,String baseURL){
		this.driver = driver;
		this.baseURL = baseURL;
		PageFactory.initElements(driver, this);
	}
	
	public String getCurrUrl(){
		return driver.getCurrentUrl();
	}
}
