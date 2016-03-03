/**
 * Created by George Totolos
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
As a user,
I want to be able to join and log in to Know Your Meme
So that I can customize my meme browsing experience
*/

public class KYM_Login_And_Join
{
    WebDriver driver = new FirefoxDriver();

    // Start at the home page for Know Your Meme for each test
    @Before
    public void setUp() throws Exception
    {
        driver.get("http://knowyourmeme.com/");
    }


    // Given that I am on the main page
    // When I click on the "login" link
    // Then I should be redirected to the "login" page
    @Test
    public void testLoginLink()
    {
        // find the "login" link and click on it
        // The page URL should be http://knowyourmeme.com/login
        driver.findElement(By.linkText("Login")).click();
        assertTrue(driver.getCurrentUrl().contains("http://knowyourmeme.com/login"));
    }


    // Given that I am on the main page
    // When I click on the "signup" link
    // Then I should be redirected to the "sign up" page
    @Test
    public void testSignUpLink()
    {
        // find the "signup" link and click on it
        // The page URL should be http://knowyourmeme.com/signup
        driver.findElement(By.linkText("signup")).click();
        assertTrue(driver.getCurrentUrl().contains("http://knowyourmeme.com/signup"));
    }


    // Given that I am on the login
    // And I am not logged in
    // When I try to login with an invalid username and password
    // Then I am prompted of an error
    @Test
    public void testBadLoginInfo()
    {
        driver.findElement(By.linkText("Login")).click();
        // Enter username "wrong", password "wrong"
        driver.findElement(By.name("session_login")).sendKeys("wrong");
        driver.findElement(By.name("session_password")).sendKeys("wrong");

        // Look for the Login button and click to attempt to login
        driver.findElement(By.name("commit")).click();

        // Check that user remains on the login page
        assertTrue(driver.getCurrentUrl().contains("http://knowyourmeme.com/memes"));
    }

    // Given that I am on the signup page
    // When I click on the "terms of service" link
    // Then I should be redirected to the "terms of service" page
    @Test
    public void testTermsOfService()
    {
        // find the "terms of service" link and click on it
        // The page URL should be http://corp.cheezburger.com/legal/terms-of-service/
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.linkText("Terms of Service")).click();
        assertTrue(driver.getCurrentUrl().contains("http://corp.cheezburger.com/legal/terms-of-service/"));
    }





}
