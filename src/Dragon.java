import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Dragon implements Iterable<Integer>, Comparable<Dragon> {
    private Game game;
    private String name;
    private int [] stats = new int[3];
    private int [] copy = new int[3];
    private final int intelligence = 0;
    private final int flight = 1;
    private final int firebreathing = 2;

    public Dragon(String name){
        this.name = name.toUpperCase();
        this.stats[intelligence] = 25;
        this.stats[firebreathing] = 25;
        this.stats[flight] = 25;
    }

    public String getName() { return name; }

    public int getIntelligence() { return stats[intelligence]; }
    public void setIntelligence(int value)
    {
        stats[intelligence] = value;
    }

    public int getFlight() { return stats[flight]; }
    public void setFlight(int value)
    {
        stats[flight] = value;
    }

    public int getFirebreathing() { return stats[firebreathing]; }
    public void setFirebreathing(int value)
    {
        stats[firebreathing] = value;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return String.format("%s : %s (%s, %s, %s)", name, round(average()),
                stats[intelligence], stats[flight], stats[firebreathing]);
    }

    public double average()
    {
        return IntStream.of(stats).average().getAsDouble();
    }

    public double max()
    {
        return IntStream.of(stats).max().getAsInt();
    }

    public void save()
    {
        System.arraycopy(stats, 0, copy, 0, 3);
        System.out.println("✔ " + this.name + " has its stats safely stored.");
    }

    public void restore(){
        System.arraycopy(copy, 0, stats, 0, 3);
        System.out.println("✔ " + this.name + " has its stats safely restored.");
    }

    private static double round(double value) {
        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    @Override
    public void forEach(Consumer<? super Integer> action)
    {
        for (int x : stats)
            action.accept(x);
    }

    @Override
    public int compareTo(Dragon other) {
        return Double.compare(this.average(), other.average());
    }

    @Override
    public Spliterator<Integer> spliterator()
    {
        return Arrays.spliterator(stats);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return IntStream.of(stats).iterator();
    }
}
