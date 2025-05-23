package selenium.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.abstractComponents;

public class cartPage extends abstractComponents {
	WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
this.driver=driver;
		PageFactory.initElements(driver, this);
		}
@FindBy(xpath="//div[@class=\\\"cartSection\\\"] //h3")
List<WebElement>cartProducts;
@FindBy(xpath="//button[contains(@class, \\\"btn btn-primary\\\") and contains(text(), \\\"Checkout\\\")]")
WebElement checkOut;
public boolean verifyDisplay(String productName) {
	boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	return match;
}
public void goToCheckout() {
	checkOut.click();
}


}

