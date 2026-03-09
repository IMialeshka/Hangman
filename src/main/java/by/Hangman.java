package by;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner inputScanner = new Scanner(System.in);
        while(true) {
            boolean isStartGame = false;

            while (true) {
                System.out.println("Для начала игры введите Да. Для выхода введите Нет");
                String answerForStart = inputScanner.nextLine();

                if (answerForStart.equalsIgnoreCase("нет")) {
                    break;
                } else if (answerForStart.equalsIgnoreCase("да")) {
                    isStartGame = true;
                    break;
                }
            }

            if (isStartGame) {
                game.startGame();
                while (!game.isFinishGameLose() && !game.isFinishGameWin()) {
                    String inputStep = inputScanner.nextLine();
                    if (game.validationOfStep(inputStep)) {
                        game.doStep(inputStep);
                    }
                }


                if (game.isFinishGameLose()) {
                    System.out.println("Вы проигралли");
                }
                if (game.isFinishGameWin()) {
                    System.out.println("Вы выйграли");
                }
            } else {
                break;
            }
        }
    }


}