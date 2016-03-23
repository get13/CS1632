/**
 * Created by George Totolos
 * JUnt-based property-based test to check Arrays.sort(int[] arr)
 */


import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class testArraySort
{
    /*
    Test that the output array has the same number of indices as the passed-in array
    */
    @Test
    public void testNumIndices()
    {
        int [] arr;
        int unsortedLength;
        int sortedLength;
        // Perform test on 100 randomly generated arrays
        for (int i = 0; i < 100; i ++)
        {
            arr = generateArray.randArray();    // Generate an array of rand length and values
            unsortedLength = arr.length;        // Get array length
            Arrays.sort(arr);                   // Use Java's built in sort method
            sortedLength = arr.length;          // Get sorted array length
            assertEquals(unsortedLength, sortedLength);
        }
    }


    /*
    Test that values at one index are always lower than values in the next subsequent index
    */
    @Test
    public void testValueIncreasing()
    {
        int [] arr;
        int numIndices;
        boolean sorted;
        // Perform test on 100 randomly generated arrays
        for (int i = 0; i < 100; i ++)
        {
            sorted = true;
            arr = generateArray.randArray();    // Generate an array of rand length and values
            Arrays.sort(arr);                   // Use Java's built in sort method
            numIndices = arr.length;            // Get array length

            // If there are two or more indices
            if (numIndices > 1)
            {
                // Compare each index
                for (int j = 0; j < (numIndices - 1); j ++)
                {
                    if(arr[j] > arr[j+1])   // If the higher index has a value that's lower than the lower index's value
                        sorted = false;     // Everything is wrong
                }
            }
            assertTrue(sorted);
        }
    }


    /*
    Test that sorting an already sorted array returns the same values
    */
    @Test
    public void testSortSortedArray()
    {
        int [] arr;
        int [] tempArr;
        int numIndices;
        // Perform test on 100 randomly generated arrays
        for (int i = 0; i < 100; i ++)
        {
            arr = generateArray.randArray();    // Generate an array of rand length and values
            Arrays.sort(arr);                   // Use Java's built in sort method
            numIndices = arr.length;            // Get array length
            tempArr = new int[numIndices];      // Declare temporary array of same length

            // Save the values of the sorted array for later comparison
            for (int j = 0; j < numIndices; j++) {
                tempArr[j] = arr[j];
            }

            Arrays.sort(arr);                   // Sort again
            assertArrayEquals(arr, tempArr);
        }
    }

}















