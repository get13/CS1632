import java.io.PrintStream;

public class House
{
    private int _numRooms = 6;
    private Room[] _rooms = new Room[this._numRooms];
    private int _currentRoom = 0;

    public House()
    {
        generateRooms();
    }

    public String getCurrentRoomInfo()
    {
        if ((this._currentRoom < 0) || (this._currentRoom >= this._numRooms))
        {
            this._currentRoom = 0;
            return "You are in a magical land!  But you are returned to the beginning!";
        }
        return this._rooms[this._currentRoom].getDescription();
    }

    public void moveNorth()
    {
        this._currentRoom += 1;
    }

    public void moveSouth()
    {
        this._currentRoom -= 1;
    }

    public void look(Player player)
    {
        Room room = this._rooms[this._currentRoom];
        if (room.hasItem())
        {
            System.out.println("There might be something here...");
            if (room.hasCoffee()) {
                player.getCoffee();
            }
            if (room.hasCream()) {
                player.getCream();
            }
            if (room.hasSugar()) {
                player.getSugar();
            }
        }
        else
        {
            System.out.println("You don't see anything out of the ordinary.");
        }
    }

    private void generateRooms()
    {
        boolean northDoor = true;
        boolean southDoor = true;
        boolean hasCoffee = false;
        boolean hasCream = false;
        boolean hasSugar = false;
        for (int j = 0; j < this._numRooms; j++)
        {
            if (j == 0) {
                hasCream = true;
            } else {
                hasCream = false;
            }
            if (j == 2) {
                hasCoffee = true;
            } else {
                hasCoffee = false;
            }
            if (j == this._numRooms - 1) {
                hasSugar = true;
            } else {
                hasSugar = false;
            }
            if (j == 0) {
                southDoor = false;
            } else {
                southDoor = true;
            }
            if (j == this._numRooms - 1) {
                northDoor = false;
            } else {
                northDoor = true;
            }
            this._rooms[j] = new Room(hasCoffee, hasCream, hasSugar, northDoor, southDoor);
        }
    }
}
