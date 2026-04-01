package by;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private static List<String> dictionary = new ArrayList<>();


    Dictionary(String filepath) {
        try {
            URL resourceUrl = Dictionary.class.getResource(filepath);
            dictionary = Files.readAllLines(Paths.get(resourceUrl.toURI()));
        } catch (Exception e) {
            System.out.println("Не удалось прочесть файл словаря" + e.getMessage());
        }
    }

    public String getWord() {
        Random random = new Random();
        return dictionary.get(random.nextInt(0, dictionary.size()-1));
    }

}
