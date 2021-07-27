import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private static Game instance;
    private List<Dragon> dragons = new ArrayList<>();
    private Encounter encounter = new Encounter();
    private Game()
    {
        System.out.println("Game is initializing...");
    }

    public static Game getInstance()
    {
        if (instance==null){
            instance = new Game();
        }
        return instance;
    }

    public void join(Dragon d)
    {
        System.out.println("• " + d.getName() + " joins the game");
        d.setGame(this);
        dragons.add(d);
    }

    public void clashDragons()
    {
        System.out.println();
        printDashes();
        if (dragons.size()<2)
        {
            System.out.println("Clashes are not possible. Not enough dragons in the game.");
        } else
        {
            Collections.shuffle(dragons);
            encounter.clash(dragons.get(0), dragons.get(1));
        }
        printDashes();
    }

    private static void printDashes() {
        System.out.println("---------------------------");
    }

}
