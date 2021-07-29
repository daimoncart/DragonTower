import java.util.ArrayList;
import java.util.List;

public class GameFacade {
    Game game;
    private List<Dragon> dragons = new ArrayList<>();
    private NameGenerator generator = new NameGenerator();

    public GameFacade(int dragonCount) {
        if (dragonCount < 2 || dragonCount > 30) {
            System.out.println("Dragon count out of bounds.");
            return;
        }
        game = Game.getInstance();

        drawDottedLine();

        for (int i = 0; i < dragonCount; i++) {
            var dragon = new Dragon(generator.get());
            dragons.add(dragon);
            game.join(dragon);
        }

        drawDottedLine();

        for (int i = 0; i < 5; i++) {
            game.clashDragons();
        }

        drawDottedLine();
        printStats();
        drawDottedLine();
    }

    public void saveDragons()
    {
        for (Dragon dragon: dragons)
        {
            dragon.save();
        }
        drawDottedLine();
    }

    public void restoreDragons()
    {
        for (Dragon dragon: dragons)
        {
            dragon.restore();
        }
        drawDottedLine();
    }

    public void threeMoreClashes(){
        for (int i = 0; i < 3; i++) {
            game.clashDragons();
        }
    }

    public void printStats(){
        System.out.println();
        drawStatsLine();
        game.printStats();
        drawDottedLine();
    }

    private void drawDottedLine()
    {
        System.out.println("······································");
    }

    private void drawStatsLine()
    {
        System.out.println("···············STATISTICS·············");
    }

}
