import java.util.ArrayList;
import java.util.List;

public class NameGenerator {
    private final String[] firstParts = {"armaet", "dag", "darng", "dia", "drago", "eborreg", "erro", "eust", "falko",
            "firn", "ghido", "hakkh", "kat", "malef", "mushe", "rhaego", "shen", "uru"};
    private final String[] secondParts = {"anhn", "ahraa", "smoke", "vahl", "nite", "olla", "ace", "en", "enna",
            "orahch", "than", "thoth", "shuu", "asha", "auh", "lokih", "erion"};
    private final int firsts = firstParts.length;
    private final int seconds = secondParts.length;
    private final List<String> usedNames = new ArrayList<>();
    private String randomName;


    public String get()
    {
        while (usedNames.contains(randomName) || randomName == null){
            randomName = firstParts[(int) (Math.random()* firsts)] + secondParts[(int) (Math.random()* seconds)];
        }
        usedNames.add(randomName);
        return randomName;
    }
}
