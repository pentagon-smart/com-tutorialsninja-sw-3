package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        //1.2 Click on “Show All Laptops & Notebooks”
        mouseHover(By.xpath("//a[text()='Laptops & Notebooks']"),By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        Thread.sleep(1000);

        //1.3 Select Sort By "Price (High > Low)"
        selectByValueFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (Low > High)");
        //1.4 Verify the Product price will arrange in High to Low order.
        List<WebElement> product = driver.findElements(By.xpath("//div[@class='caption']"));
        for (WebElement productName: product)
        {
            System.out.println(productName.getText());
        }
        Thread.sleep(1000);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        //2.2 Click on “Show All Laptops & Notebooks”
        mouseHover(By.xpath("//a[text()='Laptops & Notebooks']"),By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        Thread.sleep(1000);

        //2.3 Select Sort By "Price (High > Low)"
        selectByValueFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (Low > High)");
        Thread.sleep(1000);

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[text()='MacBook']"));
        Thread.sleep(1000);

        //2.5 Verify the text “MacBook”
        String expectedText1 = "MacBook";
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        Assert.assertEquals("text is not displayed",expectedText1,actualText1);
        Thread.sleep(1000);

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Thread.sleep(1000);

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedT1 = "Success: You have added MacBook to your shopping cart!\n×";
        String actualT2 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("text is not displayed",expectedT1,actualT2);
        Thread.sleep(1000);

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(1000);

        //2.9 Verify the text "Shopping Cart"
        String expectedText2 = "Shopping Cart";
        String actualText2 = getTextFromElement(By.xpath("//a[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals("text is not displayed",expectedText2,actualText2);
        Thread.sleep(1000);

        //2.10 Verify the Product name "MacBook"
        String expectedProduct = "MacBook";
        String actualProduct = getTextFromElement(By.xpath("//a[contains(text(),'MacBook')]"));
        Assert.assertEquals("Product is not displayed",expectedText1,actualText1);
        Thread.sleep(1000);

        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//div[@class='input-group btn-block']//input[@class='form-control']")).clear();
        sendKeyToElement(By.xpath("//div[@class='input-group btn-block']//input[@class='form-control']"),"2");
        Thread.sleep(1000);

        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//button[@type='submit']"));
        Thread.sleep(1000);

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String expectedMsg = "Success: You have modified your shopping cart!\n×";
        String actualMsg = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Msg is not displayed",expectedMsg,actualMsg);
        Thread.sleep(1000);

        //2.14 Verify the Total $1,204.00
        String expectedTotal = "$1,204.00";
        String actualTotal = getTextFromElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']//td[text()='$1,204.00']"));
        Assert.assertEquals("Total is not displayed",expectedTotal,actualTotal);

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        Thread.sleep(1000);

        //2.16 Verify the text “Checkout”
        String expectedTxt = "Checkout";
        String actualTxt = getTextFromElement(By.xpath("//h1[contains(text(),'Checkout')]"));
        Assert.assertEquals("Model is not displayed",expectedTxt,actualTxt);
        Thread.sleep(1000);

        //2.17 Verify the Text “New Customer”
        String expectedTxt1 = "New Customer";
        String actualTxt1 = getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));
        Assert.assertEquals("Model is not displayed",expectedTxt1,actualTxt1);
        Thread.sleep(1000);

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        Thread.sleep(1000);

        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        Thread.sleep(1000);

        //2.20 Fill the mandatory fields
        sendKeyToElement(By.xpath("//input[@id='input-payment-firstname']"),"Poonam");
        sendKeyToElement(By.xpath("//input[@id='input-payment-lastname']"),"Ramavat");
        sendKeyToElement(By.xpath("//input[@id='input-payment-email']"),"poonam@gmail.com");
        sendKeyToElement(By.xpath("//input[@id='input-payment-telephone']"),"7894561369");
        sendKeyToElement(By.xpath("//input[@id='input-payment-address-1']"),"alconbury close");
        sendKeyToElement(By.xpath("//input[@id='input-payment-city']"),"warrington");
        sendKeyToElement(By.xpath("//input[@id='input-payment-postcode']"),"wa12jl");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-country']"),"India");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-zone']"),"Goa");
        Thread.sleep(1000);

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        Thread.sleep(1000);

        //2.22 Add Comments About your order into text area
        sendKeyToElement(By.xpath("//textarea[@name='comment']"),"thank you!");
        Thread.sleep(1000);

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        Thread.sleep(1000);

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        Thread.sleep(1000);

        //2.25 Verify the message “Warning: Payment method required!”
//        String expectedMsg1 = "Warning: You must agree to the Terms & Conditions!\n×";
//        String actualMsg1 = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
//        Assert.assertEquals("Total is not displayed",expectedMsg1,actualMsg1);
//        Thread.sleep(1000);
    }

    @After
    public void tearDown(){
//        closeBrowser();
    }
}
