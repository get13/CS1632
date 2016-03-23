/**
 * Created by George Totolos
 */
import java.util.*;

public class generateArray
{

    public static int[] randArray()
    {
        // Declare variables
        int numIndices;
        int [] arr;
        Random randNum = new Random();

        // Create array of random number of indices
        numIndices = randNum.nextInt(100);
        arr = new int[numIndices];

        // Fill array with randomly generated numbers
        for (int i = 0; i < numIndices; i ++)
        {
            arr[i] = randNum.nextInt(100);
        }
        return arr;
    }

    public void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i ++)
        {
            System.out.println(i + " " + arr[i]);
        }
        System.out.println("NUM INDICES " + arr.length);
    }


}
