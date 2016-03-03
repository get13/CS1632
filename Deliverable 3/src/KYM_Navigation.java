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
I want to see links that allow me to navigate throughout the website
So that I can explore a variety of memes in different ways
*/

public class KYM_Navigation
{
    WebDriver driver = new FirefoxDriver();

    // Start at the home page for Know Your Meme for each test
    @Before
    public void setUp() throws Exception
    {
        driver.get("http://knowyourmeme.com/");
    }


    // Given that I am on the main page
    // When I view the title
    // Then I see that it contains the words "Know Your Meme"
    @Test
    public void testDisplaysCorrectTitle()
    {
        // Simply check that the title contains the word "Know Your Meme"
        String title = driver.getTitle();
        assertTrue(title.contains("Know Your Meme"));
    }


    // Given that I am on the main page
    // When I view the header
    // Then I see that it contains links for about, rules, char, random, and activity
    @Test
    public void testHasCorrectNavLinks()
    {
        // Check for links losted above.
        // If any of these is not found, fail the test
        try {
            driver.findElement(By.linkText("About"));
            driver.findElement(By.linkText("Rules"));
            driver.findElement(By.linkText("Chat"));
            driver.findElement(By.linkText("Random"));
            driver.findElement(By.linkText("Activity"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }


    // Given that I am on the main page
    // When I click on the "Memes" link
    // Then I should be redirected to the "memes" page
    @Test
    public void testMemesLink()
    {
        // find the "memes" link and click on it
        // The page URL should be http://knowyourmeme.com/memes
        driver.findElement(By.linkText("Memes")).click();
        assertTrue(driver.getCurrentUrl().contains("http://knowyourmeme.com/memes"));
    }


    // Given that I am on the Memes page
    // When I look at the header
    // It should contain the title "Meme Database"
    @Test
    public void testMemeHeader()
    {
        driver.findElement(By.linkText("Memes")).click();
        try
        {
            WebElement header = driver.findElement(By.id("section_header"));
            assertTrue(header.getText().contains("Meme Database"));
        }
        catch (NoSuchElementException exception)
        {
            fail();
        }
    }


    // Given that I am on the main page
    // When I click on the Know You Meme logo
    // Then I should be redirected to the homepage
    @Test
    public void testLogoLink()
    {
        // find the "Know Your Meme" logo and click on it
        // you should be redirected back to the home page
        try
        {
            WebElement logo = driver.findElement(By.id("logo"));
            logo.click();
            assertTrue(driver.getCurrentUrl().contains("http://knowyourmeme.com/"));
        } catch (NoSuchElementException nseex)
        {
            fail();
        }
    }


}




















