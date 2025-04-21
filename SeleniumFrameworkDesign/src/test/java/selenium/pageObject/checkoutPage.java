package selenium.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.abstractComponents;

public class checkoutPage extends abstractComponents {
	WebDriver driver;
	public checkoutPage(WebDriver driver) {
		super(driver);
this.driver=driver;
		PageFactory.initElements(driver, this);
		}
@FindBy(xpath="//input[@class=\\\"input txt text-validated\\\"]")
WebElement country;
@FindBy(xpath="(//button[@class=\\\"ta-item list-group-item ng-star-inserted\\\"])[2]")
WebElement selectCountry ;
@FindBy(xpath="//a[@class=\\\"btnn action__submit ng-star-inserted\\\"]")
WebElement submit ;
By results=By.xpath("//section[@class=\\\"ta-results list-group ng-star-inserted\\\"]");

public void selectCountry(String countryName) {
	Actions a = new Actions(driver);
	a.sendKeys(country, countryName);
	waitForElementToAppear(By.xpath("//section[@class=\\\\\\\"ta-results list-group ng-star-inserted\\\\\\\"]"));
	selectCountry.click();
}
public void submitOrder() {
	submit.click();
}
}

