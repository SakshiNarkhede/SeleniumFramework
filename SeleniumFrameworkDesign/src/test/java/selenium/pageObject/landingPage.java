package selenium.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.abstractComponents;


public class landingPage extends abstractComponents
{
	WebDriver driver;
	public landingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
@FindBy(id="userEmail")
WebElement userEmail;

@FindBy(id="userPassword")
WebElement userPassword;

@FindBy(id="login")
WebElement submit;

public void loginApplication(String email,String password) {
	userEmail.sendKeys(email);
	userPassword.sendKeys(password);
	submit.click();
}
public void goTo(String url) {
	driver.get(url);
}
}
