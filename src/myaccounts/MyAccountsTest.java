package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> options= driver.findElements(By.linkText(option));
        for (WebElement element: options)
        {
            element.click();
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        //1.1 Click  on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(1000);

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        Thread.sleep(1000);

        //1.3 Verify the text “Register Account”.
        String expectedText1 = "Register Account";
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]"));
        Assert.assertEquals("text is not displayed",expectedText1,actualText1);
        Thread.sleep(1000);
   }
        @Test
        public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
            //2.1 Click on My Account Link.
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            Thread.sleep(1000);

            //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
            selectMyAccountOptions("Login");
            Thread.sleep(1000);

            //2.3 Verify the text “Returning Customer”.
            String expectedText1 = "Returning Customer";
            String actualText1 = getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
            Assert.assertEquals("text is not displayed",expectedText1,actualText1);
            Thread.sleep(1000);
        }

        @Test
        public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
            //3.1 Click on My Account Link.
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            Thread.sleep(1000);

            //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
            selectMyAccountOptions("Register");

            //3.3 Enter First Name
            sendKeyToElement(By.xpath("//input[@id='input-firstname']"),"Poonam");

            //3.4 Enter Last Name
            sendKeyToElement(By.xpath("//input[@id='input-lastname']"),"ramavat");

            //3.5 Enter Email
            sendKeyToElement(By.xpath("//input[@id='input-email']"),"poonam12345@gmail.com");

            //3.6 Enter Telephone
            sendKeyToElement(By.xpath("//input[@id='input-telephone']"),"741658983");

            //3.7 Enter Password
            sendKeyToElement(By.xpath("//input[@id='input-password']"),"poonam123");

            //3.8 Enter Password Confirm
            sendKeyToElement(By.xpath("//input[@id='input-confirm']"),"poonam123");

            //3.9 Select Subscribe Yes radio button
            clickOnElement(By.xpath("//input[@type='radio'][@name='newsletter'][@value='1']"));

            //3.10 Click on Privacy Policy check box
            clickOnElement(By.xpath("//input[@name='agree']"));

            //3.11 Click on Continue button
            clickOnElement(By.xpath("//input[@type='submit']"));

            //3.12 Verify the message “Your Account Has Been Created!”

            String expectedText1 = "Your Account Has Been Created!";
            String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
            Assert.assertEquals("text is not displayed",expectedText1,actualText1);
            Thread.sleep(1000);

            //3.13 Click on Continue button
            clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

            //3.14 Click on My Account Link.
            clickOnElement(By.xpath("//div[@class='list-group']//a[text()='My Account']"));
            //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
            selectMyAccountOptions("Logout");

            //3.16 Verify the text “Account Logout”
            String expectedText2 = "Account Logout";
            String actualText2 = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
            Assert.assertEquals("text is not displayed",expectedText2,actualText2);
            Thread.sleep(1000);

            //3.17 Click on Continue button
            clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        }

        @Test
        public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
            //4.1 Click on My Account Link.
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            Thread.sleep(1000);

            //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
            selectMyAccountOptions("Login");
            Thread.sleep(1000);

            //4.3 Enter Email address
            sendKeyToElement(By.xpath("//input[@id='input-email']"),"poonam12345@gmail.com");
            Thread.sleep(1000);

            //4.5 Enter Password
            sendKeyToElement(By.xpath("//input[@id='input-password']"),"poonam123");
            Thread.sleep(1000);

            //4.6 Click on Login button
            clickOnElement(By.xpath("//input[@type='submit']"));

            //4.7 Verify text “My Account”
            String expectedText2 = "My Account";
            String actualText2 = getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]"));
            Assert.assertEquals("text is not displayed",expectedText2,actualText2);
            Thread.sleep(1000);

            //4.8 Click on My Account Link.
            clickOnElement(By.xpath("//div[@class='list-group']//a[text()='My Account']"));

            //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
            selectMyAccountOptions("Logout");

            //4.10 Verify the text “Account Logout”
            String expectedText3 = "Account Logout";
            String actualText3 = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
            Assert.assertEquals("text is not displayed",expectedText3,actualText3);
            Thread.sleep(1000);

            //4.11 Click on Continue button
            clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        }
        @After
        public void tearDown () {
//        closeBrowser();
        }

}
