package selenium.pageObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.data.dataReader;
public class submitOrder {


		@Test(dataProvider="getData")
	public void submitOrder() throws InterruptedException {	
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
String productName="ZARA COAT 3";
landingPage land=new landingPage(driver);
land.goTo("https://rahulshettyacademy.com/client");
land.loginApplication("ramsita12@gmail.com","Ramsita@1234");
Thread.sleep(3000);
productCatalog productcatalog=new productCatalog(driver);
productcatalog.getProductList();
productcatalog.getProductByName(productName);
productcatalog.addProductToCart(productName);
productcatalog.gotToCart();
cartPage cartpage=new cartPage(driver);
boolean match=cartpage.verifyDisplay(productName);
Assert.assertTrue(match);
cartpage.goToCheckout();
checkoutPage checkoutpage = new checkoutPage(driver);
checkoutpage.selectCountry("India");
checkoutpage.submitOrder();

	}
	@DataProvider
		public Object[][] getData() throws IOException{
		dataReader read=new dataReader();
		List<HashMap<String,String>> data = read.getJsonDataToMap();
		
		return new Object[][] {{data.get(0)}};
	
	}
	public File getScreenshot(String testCaseName) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return file;
		
	}
}



