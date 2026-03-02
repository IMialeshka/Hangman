package by;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class DictionaryOfGame {
    private static final List<String> dictionary;

    static {
        try {
            URL resourceUrl = DictionaryOfGame.class.getResource("/dictionary.txt");
            dictionary = Files.readAllLines(Paths.get(resourceUrl.toURI()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public String getWord() {
        Random random = new Random();
        return dictionary.get(random.nextInt(0, dictionary.size()-1));
    }

}
