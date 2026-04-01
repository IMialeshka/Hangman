package by;

import java.util.Scanner;

public class Game {
    private Player player;

    private final static String START = "ДА";
    private final static String QUIT = "НЕТ";
    private Dictionary dictionary;
    private String word;
    StringBuilder guessedLetters;
    private final static int COUNT_MISTAKES_STEP = 10;


    public Game(Dictionary dictionary, Player player) {
        this.dictionary  = dictionary;
        this.player = player;
    }

    public void play(Scanner  inputScanner) {
        boolean state = false;
        while (true) {
            System.out.printf("Для начала игры введите '%s'. Для выхода введите '%s' %n", START, QUIT);
            String command  = inputScanner.nextLine();

            if (command .equalsIgnoreCase(QUIT)) {
                break;
            } else if (command.equalsIgnoreCase(START)) {
                state = true;
                word = this.dictionary.getWord();
                this.guessedLetters = new StringBuilder("_".repeat(this.word.length()));
                Renderer.printStart(this.guessedLetters);
                break;
            }
        }

        if (state) {
            while (!isLose() && !isWin()) {
                System.out.println("Ввведите маленькую букву рус. алфавита:");
                String inputStep = inputScanner.nextLine();
                Step newStep = new Step(inputStep, true);
                if (newStep.validateStep()) {
                    if (!chekPresenceLetter(newStep)) {
                        Renderer.printError(this.player.getErrorCounter());
                    }
                    this.player.addStep(newStep);
                    Renderer.printInfoStep(String.valueOf(guessedLetters), this.player);
                }
            }


            if (isLose()) {
                Renderer.printLose(this.word);
            }
            if (isWin()) {
                Renderer.printWin(this.word);
            }
            this.player.clean();
            play(inputScanner);
        }
    }


    private boolean chekPresenceLetter(Step step) {
        int symbolIndex = word.indexOf(step.getStep());
        boolean presenceLetterFound = false;
        while (symbolIndex >= 0) {
            if (step.isError()) {
                step.setError(false);
            }
            presenceLetterFound = true;
            this.guessedLetters.replace(symbolIndex, symbolIndex + 1, step.getStep());
            symbolIndex = word.indexOf(step.getStep(), symbolIndex + 1);
        }
        if (this.player.getSteps().contains(step)) {
            presenceLetterFound = true;
        }
        return presenceLetterFound;
    }

    private boolean isLose() {
        return this.player.getErrorCounter() == COUNT_MISTAKES_STEP;
    }

    private boolean isWin() {
        return this.guessedLetters.indexOf("_") == -1;
    }
}
