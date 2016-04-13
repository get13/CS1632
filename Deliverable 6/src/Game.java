
import java.io.PrintStream;
import java.util.Scanner;

public class Game
{
    private Player _player = null;
    private House _house = null;

    public Game(Player p, House h)
    {
        this._player = p;
        this._house = h;
    }

    public int run()
    {
        int toReturn = 0;

        Scanner in = new Scanner(System.in);
        String move = null;

        boolean gameOver = false;
        boolean win = false;
        while (!gameOver)
        {
            System.out.println(this._house.getCurrentRoomInfo());
            System.out.println(" INSTRUCTIONS (N,S,L,I,D) > ");
            move = in.nextLine();
            if (move.equals("N"))
            {
                this._house.moveNorth();
            }
            else if (move.equalsIgnoreCase("S"))
            {
                this._house.moveSouth();
            }
            else if (move.equalsIgnoreCase("L"))
            {
                this._house.look(this._player);
            }
            else if (move.equalsIgnoreCase("I"))
            {
                this._player.showInventory();
            }
            else if (move.equalsIgnoreCase("D"))
            {
                win = this._player.drink();
                gameOver = true;
            }
            else
            {
                System.out.println("What?");
            }
        }
        if (win)
        {
            System.out.println("You win!");
            toReturn = 0;
        }
        else
        {
            System.out.println("You lose!");
            toReturn = 1;
        }
        return toReturn;
    }
}
