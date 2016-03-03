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
I want to be able to use Know Your Meme's search functionality
So that I can find exactly the memes I'm looking for
*/

public class KYM_Search
{
    WebDriver driver = new FirefoxDriver();

    // Start at the home page for Know Your Meme for each test
    @Before
    public void setUp() throws Exception
    {
        driver.get("http://knowyourmeme.com/");
    }


    // Given that I am on the main page
    // When I view the Search box form
    // Then I should see that it gives me the option to search the site
    @Test
    public void testHasSearchBox()
    {
        // Check that there is a search box
        // If not found, fail the test
        try {
            driver.findElement(By.id("search_box"));
        } catch (NoSuchElementException nseex) {
            fail();
        }
    }

    // Given that I am on the main page
    // When I click on the "Advanced Search Protips" link
    // Then I should be redirected to a Search Operators page
    @Test
    public void testAdvancedSearchLink()
    {
        // find the "advanced search protips" link and click on it
        // The page URL should be http://knowyourmeme.com/blog/kym-database-search-operators
        driver.findElement(By.linkText("Advanced Search Protips")).click();
        assertTrue(driver.getCurrentUrl().contains("http://knowyourmeme.com/blog/kym-database-search-operators"));
    }


    // Given that I am on the main page
    // When I submit a search
    // Then I am given a page of search results
    @Test
    public void testSearchValidInput()
    {
        // Enter "cats" into the search box
        driver.findElement(By.id("search_box")).sendKeys("cats");
        // Look for the submit button and click
        driver.findElement(By.id("search-submit")).click();

        // find keyword in question excerpt body
        WebElement header = driver.findElement(By.id("section_header"));
        assertTrue(header.getText().contains("Search Results"));
    }

}
