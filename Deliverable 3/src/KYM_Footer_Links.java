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
I want to have access to the footer links
So that I can explore a different functions of the website beyond memes
*/

public class KYM_Footer_Links
{
    WebDriver driver = new FirefoxDriver();

    // Start at the home page for Know Your Meme for each test
    @Before
    public void setUp() throws Exception
    {
        driver.get("http://knowyourmeme.com/");
    }


    // Given that I am on the main page
    // When I click on the "Cheezburger blog" link
    // Then I should be redirected to the "blog" page
    @Test
    public void testBlogLink()
    {
        // find the "Cheezburger blog" link and click on it
        // The page URL should be http://blog.cheezburger.com/
        driver.findElement(By.linkText("Cheezburger Blog")).click();
        assertTrue(driver.getCurrentUrl().contains("http://blog.cheezburger.com/"));
    }


    // Given that I am on the main page
    // When I click on the "Advertising" link
    // Then I should be redirected to the "Advertising" page
    @Test
    public void testAdvertisingLink()
    {
        // find the "Advertising" link and click on it
        // The page URL should be http://advertising.cheezburger.com/
        driver.findElement(By.linkText("Advertising")).click();
        assertTrue(driver.getCurrentUrl().contains("http://advertising.cheezburger.com/"));
    }


    // Given that I am on the main page
    // When I click on the "Developers" link
    // Then I should be redirected to the "Developers" page
    @Test
    public void testDevelopersLink()
    {
        // find the "Developers" link and click on it
        // The page URL should be http://sites.cheezburger.com/support/
        driver.findElement(By.linkText("Developers")).click();
        assertTrue(driver.getCurrentUrl().contains("http://sites.cheezburger.com/support/"));
    }


    // Given that I am on the main page
    // When I click on the "Contact Us" link
    // Then I should be redirected to the "Contact Us" page
    @Test
    public void testContactLink()
    {
        // find the "Contact Us" link and click on it
        // The page URL should be http://support.cheezburger.com/support/home
        driver.findElement(By.linkText("Contact Us")).click();
        assertTrue(driver.getCurrentUrl().contains("http://support.cheezburger.com/support/home"));
    }


}
