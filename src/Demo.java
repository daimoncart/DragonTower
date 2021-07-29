public class Demo {
    public static void main(String[] args) {
//        var game = Game.getInstance();
//        var dragon1 = new Dragon("Fluffy");
//        game.join(dragon1);
//        game.clashDragons();
//
//        dragon1.save();
//
//        var dragon2 = new Dragon("Bimbo");
//        game.join(dragon2);
//
//        game.clashDragons();
//
//        System.out.println(dragon1);
//        dragon1.restore();
//        System.out.println(dragon1);
//
//        var dragon3 = new Dragon("Forget-Me-Not");
//        game.join(dragon3);
//        game.clashDragons();
        NameGenerator generator = new NameGenerator();
        System.out.println(generator.get());
        System.out.println(generator.get());
        System.out.println(generator.get());
        System.out.println(generator.get());
    }
}
