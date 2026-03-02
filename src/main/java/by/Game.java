package by;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private StringBuilder word;
    private StringBuilder wordForPrint;
    private final DictionaryOfGame dictionaryOfGame;
    private int error;
    private StringBuilder errorList;
    private int sizeOfWord = 0;
    private final static int errCount = 10;

    public Game() {
      dictionaryOfGame = new DictionaryOfGame();
    }

    public void startGame() {
        this.word = new StringBuilder(dictionaryOfGame.getWord());
        this.sizeOfWord = word.length();
        this.error = errCount;
        this.wordForPrint = new StringBuilder("_".repeat(this.word.length()));
        System.out.println(this.wordForPrint);
        this.errorList = new StringBuilder();

    }

    public boolean validationStep(String step) {
        if (step.isEmpty()) {
            return false;
        }

        if (step.length() != 1) {
            return false;
        }

        if(errorList.indexOf(step) != -1) {
            return false;
        }

        String regexp = "[а-яА-ЯёЁ]";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(step);
        return matcher.find();
    }

    public void doStep(String step) {
        int index = word.indexOf(step);
        if (index != -1) {
            sizeOfWord--;
            word.replace(index, index + 1,"_");
            wordForPrint.replace(index, index + 1,step);
            System.out.println(this.wordForPrint);
        } else {
            error--;
            GallowsTree.PrintGallowsTree(errCount - error - 1);
            errorList.append(step);
        }
    }

    public boolean isFinishGameLose() {
        return this.error == 0;
    }

    public boolean isFinishGameWin() {
        return sizeOfWord == 0;
    }
}
