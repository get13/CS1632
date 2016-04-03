/**
 * Created by George Totolos on 3/29/2016.
 */

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.*;


/*
ALL TESTS ASSUME A 15 x 15 SIZED WORLD
*/
public class PinningTests
{
    /*
    Automated Pinning tests for convertToInt method in the MainPanel.java class.
    Manual testing shows that the output of this method should the exact
    same as the input value.
     */
    @Test
    public void test_convertToInt_baseCase()
    {
        int x = 5;
        int result = MainPanel.convertToInt(x);
        assertEquals(result,x);
    }

    @Test
    public void test_convertToInt_caseZero()
    {
        int x = 0;
        int result = MainPanel.convertToInt(x);
        assertEquals(result,x);
    }

    @Test
    public void test_convertToInt_caseHigh()
    {
        int x = 100000000;
        int result = MainPanel.convertToInt(x);
        assertEquals(result,x);
    }


    /*
    Manual Pinning tests for runContinuous method in the MainPanel.java class.
    Manual testing shows that all this method does is run backup()
    and calculateNextIteration() methods in an infinite loop

    Test 1:
    Assuming a fresh start of the program, when I click on only the top-left
    cell then click the "Run Continuous" button, the message "Calculating..
    Displaying..." should repeat for the duration of the program's execution.

    Preconditions:   All cells are greyed out and no menu buttons have been pushed.
    Execution Steps: Click on the top-left cell in the window then press the
                     "Run Continuous" button. Wait 10 seconds then exit program.
    Postconditions:  Top-left cell turns green and the output should repeat
                     "Calculating...
                     Displaying..."
                     until program is exited.

    Test 2:
    Assuming a fresh start of the program, when I click on only the top-left
    cell then click the "Run Continuous" button, the message "Calculating..
    Displaying..." should stop displaying when the "Stop" button is clicked.

    Preconditions:   All cells are greyed out and no menu buttons have been pushed.
    Execution Steps: Click on the top-left cell in the window then press the
                     "Run Continuous" button. Wait 10 seconds then click the "Stop"
                     button.
    Postconditions:  Top-left cell turns green and the output should repeat
                     "Calculating...
                     Displaying..."
                     then stop repeating after "Stop" is clicked.

    Test 3:
    Assuming a fresh start of the program, when only 3 adjacent vertical cells
    are selected then the "Run Continuous" button is clicked, the cells should
    oscillate in a pattern until the "Stop" button is clicked.

    Preconditions:   All cells are greyed out and no menu buttons have been pushed.
    Execution Steps: Click on the cells at row 2 column 8, row 3 column 8, and
                     row 4 column 8. Then click the "Run Continuous" button.
                     Observe the GUI screen for 10 seconds then click the "Stop"
                     button.
    Postconditions:  Output will continuously flip between 2 states:
                     State 1) Green: row 1/col 8, row 4/col 8
                              Red: row 3/col 7, row 3/col 8, row 3/col 9
                     State 2) Green: row 3/col 7, row 3/col 9
                              Red: row 2/col 8, row 3/col 8, row 4/col 8
                     Then stops/holds the current state of the cells when the
                     "Stop" button is clicked.
    */



    /*
    Manual Pinning tests for toString method in the Cell.java class.
    Manual testing shows that this method finds and returns the String
    value of the cell being analyzed ( "X" or "."). toString() is called
    when the "Write" button is clicked.

    Test 1:
    Assuming a red cell exist on each corner of the grid (everything else
    is gray), then the "Write" button is clicked, any further alterations
    to the grid will be undone after the "Load" button is clicked.

    Preconditions:   All cells are grayed out and no menu buttons have been pushed.
    Execution Steps: Click on the cells at each corner of the grid creating a total of
                     4 red cells. Then click on the "Write" button. Then click all
                     of the untouched cells on the top row to make the entire top
                     row red. Now click on the "Load" button.
    Postconditions:  All of the cells are gray except for the cells at each of the
                     four corners.

    Test 2:
    Assuming a fresh start of the program, when no cells are clicked and the "Write"
    button is clicked, pressing load will make no changes to the grid.

    Preconditions:   All cells are grayed out and no menu buttons have been pushed.
    Execution Steps: Press the "Write" button then press the "Load button".
    Postconditions:  No changes to the grid have been displayed and all of the
                     cells are gray.

    Test 3:
    Assuming a fresh start of the program with only 3 adjacent vertical cells
    selected. Pressing the "Run" button should create two green cells. Pressing
    "Write" then "Load" should remove those green cells, leaving only the red.

    Preconditions:   All cells are greyed out and no menu buttons have been pushed.
    Execution Steps: Click on the cells at row 2 column 8, row 3 column 8, and
                     row 4 column 8. Then click the "Run" button once and observe
                     the red and green cells that display. Click "Write" then "Load".
    Postconditions:  The green cells should disappear, leaving only three adjacent
                     red cells displayed on the grid.
    */
}









