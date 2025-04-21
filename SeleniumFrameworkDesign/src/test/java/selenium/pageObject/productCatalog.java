package selenium.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.abstractComponents;

public class productCatalog extends abstractComponents {
	WebDriver driver;
	public productCatalog(WebDriver driver) {
		super(driver);
this.driver=driver;
		PageFactory.initElements(driver, this);
		}
@FindBy(xpath="//div[contains(@class, \"mb-3\")]")
List<WebElement>products;
By productBy=By.xpath("//div[contains(@class, \"mb-3\")]");
By addToCart=By.xpath("(//button[@class='btn w-10 rounded'][normalize-space()='Add To Cart'])[1]");
public List<WebElement> getProductList() {
	waitForElementToAppear(productBy);
	return products;
}
public WebElement getProductByName(String productName) {
	WebElement prod = products.stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	return prod;
}
public void addProductToCart(String productName) {
	WebElement prod=getProductByName(productName);
	prod.findElement(addToCart).click();
	
}

}

