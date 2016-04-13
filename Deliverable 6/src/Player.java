import java.io.PrintStream;

public class Player
{
    public boolean _hasSugar = false;
    public boolean _hasCream = false;
    public boolean _hasCoffee = false;

    public void getSugar()
    {
        System.out.println("You found some sweet sugar!");
        this._hasSugar = true;
    }

    public void getCream()
    {
        System.out.println("You found some creamy cream!");
        this._hasCream = true;
    }

    public void getCoffee()
    {
        System.out.println("You found some caffeinated coffee!");
        this._hasCoffee = true;
    }

    public boolean hasAllItems()
    {
        return (this._hasCoffee) && (this._hasCream) && (this._hasSugar);
    }

    public void showInventory()
    {
        if (this._hasCoffee) {
            System.out.println("You have a cup of delicious coffee.");
        } else {
            System.out.println("YOU HAVE NO COFFEE!");
        }
        if (this._hasCream) {
            System.out.println("You have some fresh cream.");
        } else {
            System.out.println("YOU HAVE NO CREAM!");
        }
        if (this._hasSugar) {
            System.out.println("You have some tasty sugar.");
        } else {
            System.out.println("YOU HAVE NO SUGAR!");
        }
    }

    public boolean drink()
    {
        boolean win = false;

        showInventory();

        System.out.println();
        if ((this._hasCoffee) && (this._hasCream) && (this._hasSugar))
        {
            System.out.println("You drink the beverage and are ready to study!");
            win = true;
        }
        else if (this._hasCoffee)
        {
            if (!this._hasCream) {
                System.out.println("Without cream, you get an ulcer and cannot study.");
            } else {
                System.out.println("Without sugar, the coffee is too bitter.  You cannot study.");
            }
        }
        else if (this._hasCream)
        {
            if (!this._hasSugar) {
                System.out.println("You drink the cream, but without caffeine, you cannot study.");
            } else {
                System.out.println("You drink the sweetened cream, but without caffeine, you cannot study.");
            }
        }
        else if (this._hasSugar)
        {
            System.out.println("You eat the sugar, but without caffeine, you cannot study.");
        }
        else
        {
            System.out.println("You drink the air, as you have no coffee, sugar, or cream.\nThe air is invigorating, but not invigorating enough.  You cannot study.");
        }
        return win;
    }
}
