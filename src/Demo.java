public class Demo {
    public static void main(String[] args) {
        var game = Game.getInstance();
        var dragon1 = new Dragon("Fluffy");
        game.join(dragon1);
        dragon1.setFirebreathing(67);
        System.out.println(dragon1);
        dragon1.save();
        dragon1.setFlight(1);
        System.out.println(dragon1);
        dragon1.restore();
        System.out.println(dragon1);

    }
}
