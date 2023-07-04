package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1 Mouse hover on Desktops Tab.and click
        //1.2 Click on “Show All Desktops”
        mouseHover(By.xpath("//a[text()='Desktops']"),By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        Thread.sleep(1000);

        //1.3 Select Sort By position "Name: Z to A"
        selectByValueFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='caption']"));
        System.out.println("Products list in decending order :");
        for (WebElement productsName : products)
        {
            System.out.println(productsName.getText());
        }
    }

    @Test
    public  void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        //2.2 Click on “Show All Desktops”
        mouseHover(By.xpath("//a[text()='Desktops']"),By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        Thread.sleep(1000);

        //2.3 Select Sort By position "Name: A to Z"
        selectByValueFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (A - Z)");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));

        //2.5 Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        Assert.assertEquals("Product not displayed", expectedText, actualText);

        //2.6 Select Delivery Date "2022-11-30"
        WebElement deliveryDateInput = driver.findElement(By.id("input-option225"));
        deliveryDateInput.clear();
        deliveryDateInput.sendKeys("2022-11-30");
        Thread.sleep(2000);

        //2.7.Enter Qty "1” using Select class.
        WebElement quantity= driver.findElement(By.xpath("//input[@id='input-quantity']"));
        quantity.clear();
        quantity.sendKeys("1");
        Thread.sleep(1000);

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!\n×";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Message is not displayed",expectedMessage,actualMessage);

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));
        Thread.sleep(1000);
        //2.11 Verify the text "Shopping Cart"
        String expectedText1 = "Shopping Cart";
        String actualText1 = getTextFromElement(By.xpath("//a[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals("text is not displayed",expectedText1,actualText1);
        Thread.sleep(1000);

        //2.12 Verify the Product name "HP LP3065"
        String expectedProduct = "HP LP3065";
        String actualProduct = getTextFromElement(By.xpath("//div[@class='table-responsive']//a[text()='HP LP3065']"));
        Assert.assertEquals("Product is not displayed",expectedProduct,actualProduct);
        Thread.sleep(1000);

        //2.13 Verify the Delivery Date "2022-11-30"
        String expectedDate = "Delivery Date:2022-11-30";
        String actualDate = getTextFromElement(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]"));
        Assert.assertEquals("Product is not displayed",expectedDate,actualDate);
        Thread.sleep(1000);

        //2.14 Verify the Model "Product21"
        String expectedModel = "Product 21";
        String actualModel = getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        Assert.assertEquals("Model is not displayed",expectedModel,actualModel);
        Thread.sleep(1000);

        //2.15 Verify the Total "$122.00"
        String expectedTotal = "$122.00";
        String actualTotal = getTextFromElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']//td[text()='$122.00']"));
        Assert.assertEquals("Total is not displayed",expectedTotal,actualTotal);
        Thread.sleep(1000);
    }
    @After
    public void tearDown(){
//        closeBrowser();
    }
}
