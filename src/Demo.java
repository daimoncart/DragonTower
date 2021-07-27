public class Demo {
    public static void main(String[] args) {
        var game = Game.getInstance();
        var dragon1 = new Dragon("Fluffy");
        game.join(dragon1);
        game.clashDragons();

        dragon1.save();

        var dragon2 = new Dragon("Bimbo");
        game.join(dragon2);

        game.clashDragons();

        System.out.println(dragon1);
        dragon1.restore();
        System.out.println(dragon1);

    }
}
