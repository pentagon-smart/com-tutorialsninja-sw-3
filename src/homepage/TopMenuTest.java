package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    public void selectMenu(String menu){

    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverToElement(By.xpath("//a[text()='Desktops']"));
        Thread.sleep(1000);

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");
        clickOnElement(By.xpath("//a[contains(text(),'Show AllDesktops')]"));

        //1.3 Verify the text ‘Desktops’
        String expectedText = "Desktops";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]"));
        Assert.assertEquals("text is not displayed",expectedText,actualText);

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click

        mouseHoverToElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        Thread.sleep(1000);

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));

        //2.3 Verify the text ‘Laptops & Notebooks’
        String expectedText = "Laptops & Notebooks";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
        Assert.assertEquals("text is not displayed",expectedText,actualText);

    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        //3.1 Mouse hover on “Components” Tab and click
        mouseHoverToElement(By.xpath("//a[text()='Components']"));
        Thread.sleep(1000);

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");
        clickOnElement(By.xpath("//a[contains(text(),'Show AllComponents')]"));

        //3.3 Verify the text ‘Components’
        String expectedText = "Components";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Components')]"));
        Assert.assertEquals("text is not displayed",expectedText,actualText);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
