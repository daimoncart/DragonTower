public class Demo {
    public static void main(String[] args) {
        var game = new GameFacade(5);
        game.saveDragons();
        game.threeMoreClashes();
        game.printStats();
        game.restoreDragons();
    }
}
