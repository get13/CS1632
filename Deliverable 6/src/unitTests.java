/**
 * Created by George Totolos on 4/12/2016.
 */


/*
    NOTES:
    - Edited Player.java to use public variables instead of private
      EX) private boolean _hasSugar = false; --> public boolean _hasSugar = false;
    - Edited CoffeeMaker.java
          private int runGameLoop() --> public int runGameLoop()
          private int runArgs(String arg) -- > public int runArgs(String arg)
    - Some tests should fail because coffeemaker is flawed by nature. we'll note that in our summary

    Requirement completion status
    FUN-ITERATION
    FUN-UNKNOWN-COMMAND
    FUN-INPUT-CAPS
    FUN-MOVE
XXX FUN-WIN
XXX FUN-LOSE
XXX FUN-INVENTORY
XXX FUN-LOOK
    FUN-HELP
XXX FUN-UNIQ-ROOM
    FUN-UNIQ-ROOM-FURNISHING
*/


import org.junit.*;
import static org.junit.Assert.*;
import org.mockito.*;
import java.io.*;
import java.util.*;

public class unitTests
{

/*
******************************************************************************
    FUN-LOOK
    Upon entering "L" for Look, the player shall collect any
    items in the room and those items will be added to the
    player's inventory.
*/

    // Test that if the player looks in an empty room that no
    // items will be added to their inventory
    @Test
    public void test_FUN_LOOK_emptyRoom()
    {
        // Generate player and house objects
        Player p = new Player();
        House h = new House();
        h.moveNorth();                  // The second room is known to contain no items
        h.look(p);                      // Look for items - none should be found

        // See if player has anything in their inventory
        boolean hasItem = false;
        if (p._hasSugar || p._hasCream || p._hasCoffee)
        {
            hasItem = true;
        }
        assertFalse(hasItem);           // Assert that player has empty inventory
    }

    // Test that if the player looks in a room with an item,
    // that item will be added to their inventory
    @Test
    public void test_FUN_LOOK_RoomWithCream()
    {
        // Generate player and house objects
        Player p = new Player();
        House h = new House();          // First room is known to contain cream
        h.look(p);                      // Look for items - cream should be found
        boolean hasCream = p._hasCream; // True if player has cream
        assertTrue(hasCream);           // Assert that player has cream in their inventory
    }

    // Test that if the player looks in all 6 rooms that their
    // inventory will be full
    @Test
    public void test_FUN_LOOK_allRoomItems()
    {
        // Generate player and house objects
        Player p = new Player();
        House h = new House();          // First room is known to contain cream
        h.look(p);                      // Look for items - cream should be found
        h.moveNorth();
        h.look(p);
        h.moveNorth();                  // The third room is known to have coffee
        h.look(p);                      // Look for items - coffee should be found
        h.moveNorth();
        h.look(p);
        h.moveNorth();
        h.look(p);
        h.moveNorth();                  // The sixth room is known to have sugar
        h.look(p);                      // Look for items - sugar should be found

        boolean hasAllItems = p.hasAllItems(); // True if all items exist in inventory
        assertTrue(hasAllItems);        // Assert that player has a full inventory
    }


/*
******************************************************************************
    FUN-LOSE
    The player shall lose the game if and only if the player
    Drinks but has not collected all of the items (Coffee, Sugar,
    and Cream).

    FUN-WIN
    The player shall win the game if and only if Coffee, Sugar,
    and Cream have been collected by the player and then drunk.
*/

    // Test to see if a player drinks on an empty inventory they
    // will lose the game
    @Test
    public void test_FUN_WIN_LOSE_emptyInventory()
    {
        // Declare player object - empty inventory by default
        Player player = new Player();
        boolean won = player.drink();   // Should return false if player lost
        assertFalse(won);               // Assert that player has lost the game
    }

    // Test to see if a player drinks on an full inventory they
    // will not lose the game
    @Test
    public void test_FUN_WIN_LOSE_fullInventory()
    {
        // Declare player object - empty inventory by default
        Player player = new Player();
        // Set player's inventory to have all items (coffee, sugar, cream)
        player.getSugar();
        player.getCream();
        player.getCoffee();
        boolean won = player.drink();   // Should return true if player won
        assertTrue(won);                // Assert that player has won the game
    }

    // Test to see if a player drinks with only coffee in their
    // inventory they will lose the game
    @Test
    public void test_FUN_WIN_LOSE_hasOnlyCoffee()
    {
        // Declare player object - empty inventory by default
        Player player = new Player();
        player.getCoffee();             // Set player to have only coffee
        boolean won = player.drink();   // Should return false if player lost
        assertFalse(won);               // Assert that player has lost the game
    }


/*
******************************************************************************
    FUN-INVENTORY
    Upon entering "I" for inventory, the player shall be informed
    of the items that he/she has collected (consisting of Coffee,
    Sugar, and Cream).
*/

    // Test that the terminal output will inform the user that they have
    // no items when the player has an empty inventory
    @Test
    public void test_FUN_INVENTORY_empty()
    {
        // Declare player object - empty inventory by default
        Player p = new Player();

        // Save current System.out
        PrintStream oldOut = System.out;
        // Create a ByteArrayOutputStream so that we can get the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        // Change System.out to point out to outContent stream
        System.setOut(new PrintStream(outContent));

        p.showInventory();  // Print out contents of inventory

        // Reset the System.out
        System.setOut(oldOut);
        // outContent contains content from the last print statements
        String output = new String(outContent.toByteArray());

        // Assert that output informs player that their inventory is empty
        assertTrue(output.contains("YOU HAVE NO COFFEE!"));
        assertTrue(output.contains("YOU HAVE NO CREAM!"));
        assertTrue(output.contains("YOU HAVE NO SUGAR!"));

        // Flush System.out
        System.out.println(output);
    }

    // Test that the terminal output will inform the user that they have
    // no items when the player has an empty inventory
    @Test
    public void test_FUN_INVENTORY_onlyCream()
    {
        // Generate player and house objects
        Player p = new Player();
        House h = new House();          // First room is known to contain cream
        h.look(p);                      // Look for items - cream should be found

        // Save current System.out
        PrintStream oldOut = System.out;
        // Create a ByteArrayOutputStream so that we can get the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        // Change System.out to point out to outContent stream
        System.setOut(new PrintStream(outContent));

        p.showInventory();  // Print out contents of inventory

        // Reset the System.out
        System.setOut(oldOut);
        // outContent contains content from the last print statements
        String output = new String(outContent.toByteArray());

        // Assert that output informs player that they have cream in their inventory
        assertTrue(output.contains("You have some fresh cream."));

        // Flush System.out
        System.out.println(output);
    }

    // Test that the terminal output will inform the user that they have
    // all items when the player hs a full inventory
    @Test
    public void test_FUN_INVENTORY_allItems()
    {
        Player p = new Player();        // Generate player object
        // Set player's inventory to have all items (coffee, sugar, cream)
        p.getSugar();
        p.getCream();
        p.getCoffee();

        // Save current System.out
        PrintStream oldOut = System.out;
        // Create a ByteArrayOutputStream so that we can get the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        // Change System.out to point out to outContent stream
        System.setOut(new PrintStream(outContent));

        p.showInventory();  // Print out contents of inventory

        // Reset the System.out
        System.setOut(oldOut);
        // outContent contains content from the last print statements
        String output = new String(outContent.toByteArray());

        // Assert that output informs player that they have a full inventory
        assertTrue(output.contains("You have a cup of delicious coffee."));
        assertTrue(output.contains("You have some fresh cream."));
        assertTrue(output.contains("You have some tasty sugar."));

        // Flush System.out
        System.out.println(output);
    }


/*
******************************************************************************
    FUN-UNIQ-ROOM
    Each room in the house shall have a unique adjective describing it.
*/

    // Loop through all rooms and compare all adjectives
    @Test
    public void test_FUN_UNIQ_ROOM()
    {
        int numRooms = 6;
        String output = null;
        String prevOutput = null;
        House h = new House();

        // Solo out room adjective
        prevOutput = h.getCurrentRoomInfo();
        prevOutput = prevOutput.replace("You see a ", "");
        prevOutput = prevOutput.substring(0, prevOutput.indexOf(" "));

        // Loop through all 6 rooms comparing adjectives
        for (int i = 0; i < numRooms-1; i ++)
        {
            h.moveNorth();
            output = h.getCurrentRoomInfo();
            output = output.replace("You see a ", "");
            output = output.substring(0, output.indexOf(" "));

            assertNotEquals(prevOutput,output); // Ensure that adjs are different

            prevOutput = output;
        }
    }

    

}


















