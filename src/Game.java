import java.util.ArrayList;
import java.util.List;

public class Game {
    private static Game instance;
    private List<Dragon> dragons = new ArrayList<>();
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
        System.out.println(d.getName() + " the dragon joins the game");
        d.setGame(this);
        dragons.add(d);
    }


}
