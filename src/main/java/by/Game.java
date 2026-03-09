package by;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private StringBuilder word;
    private StringBuilder wordForShow;
    private final DictionaryOfGame dictionaryOfGame;
    private int mistakeOfCurrentGame;
    private StringBuilder doneMistakeList;
    private int countOfUnsolvedLetters = 0;
    private final static int COUNT_MISTAKES_STEP = 10;

    public Game() {
      dictionaryOfGame = new DictionaryOfGame();
    }

    public void startGame() {
        this.word = new StringBuilder(dictionaryOfGame.getWord());
        this.countOfUnsolvedLetters = word.length();
        this.mistakeOfCurrentGame = COUNT_MISTAKES_STEP;
        this.wordForShow = new StringBuilder("_".repeat(this.word.length()));
        System.out.println(this.wordForShow);
        this.doneMistakeList = new StringBuilder();

    }

    public boolean validationOfStep(String step) {
        if (step.isEmpty()) {
            return false;
        }

        if (step.length() != 1) {
            return false;
        }

        if(doneMistakeList.indexOf(step) != -1) {
            return false;
        }

        String regexp = "[а-яА-ЯёЁ]";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(step);
        return matcher.find();
    }

    public void doStep(String step) {
        int index = this.word.indexOf(step);
        if (index != -1) {
            this.countOfUnsolvedLetters--;
            this.word.replace(index, index + 1,"_");
            wordForShow.replace(index, index + 1,step);
            System.out.println(this.wordForShow);
        } else {
            this.mistakeOfCurrentGame--;
            GallowsTree.PrintGallowsTree(COUNT_MISTAKES_STEP - this.mistakeOfCurrentGame - 1);
            this.doneMistakeList.append(step);
        }
    }

    public boolean isFinishGameLose() {
        return this.mistakeOfCurrentGame == 0;
    }

    public boolean isFinishGameWin() {
        return this.countOfUnsolvedLetters == 0;
    }
}
