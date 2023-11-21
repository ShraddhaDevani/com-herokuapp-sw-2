package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    static String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter the email to email field
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        // //Enter the password field
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //Click on login button
        driver.findElement(By.xpath("//form[@id='login']/button/i")).click();

        //Verify the text “Secure Area”
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter the email to email field
        driver.findElement(By.id("username")).sendKeys("tomsmith1");

        // //Enter the password field
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        //Click on login button
        driver.findElement(By.xpath("//form[@id='login']/button/i")).click();

        //Verify the text “Secure Area”
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter the email to email field
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        // //Enter the password field
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

        //Click on login button
        driver.findElement(By.xpath("//form[@id='login']/button/i")).click();

        //Verify the text “Secure Area”
        String expectedErrorMessage = "Your username is valid!";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}