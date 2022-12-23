package EmirSeho.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import EmirSeho.TestComponents.BaseTest;
import EmirSeho.pageobjects.CartPage;
import EmirSeho.pageobjects.CheckoutPage;
import EmirSeho.pageobjects.ConfirmationPage;
import EmirSeho.pageobjects.ProductCatalogue;

public class ErrorValidationsTestEmirSeho extends BaseTest{

	//@Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
	@Test(groups = {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException, InterruptedException
	{
		String productName = "ZARA COAT 3";
		
		landingPage.loginApplication("sehoemir@gmail.com", "VeryINsecureone1");
		
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());	
	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{
		
		
		String productName = "ZARA COAT 3";
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("sehoemir@gmail.com", "Verysecureone1");
		//ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		
		List<WebElement> products = productCatalogue.getProductList();	
		productCatalogue.addProductToCart(productName);
		
		CartPage cartPage = productCatalogue.goToCartPage();
			
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33333");	
		Assert.assertFalse(match);
		
		
	}
		
	

}
