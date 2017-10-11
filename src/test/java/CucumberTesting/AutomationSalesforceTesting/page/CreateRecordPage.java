package CucumberTesting.AutomationSalesforceTesting.page;

import org.openqa.selenium.WebDriver;

public class CreateRecordPage extends AbstractPage {

	public CreateRecordPage(WebDriver driver,String baseURL) {
		super(driver,baseURL);
	}
	
	public void navigateToRecordCreationObject(String object){
		driver.navigate().to(baseURL+"&retURL="+object+"/e");
	}	

}
