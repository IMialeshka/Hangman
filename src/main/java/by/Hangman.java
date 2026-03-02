package by;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner input = new Scanner(System.in);
        while(true) {
            boolean isStartGame = false;

            while (true) {
                System.out.println("Для начала игры введите Да. Для выхода введите Нет");
                String inStr = input.nextLine();

                if (inStr.equalsIgnoreCase("нет")) {
                    break;
                } else if (inStr.equalsIgnoreCase("да")) {
                    isStartGame = true;
                    break;
                }
            }

            if (isStartGame) {
                game.startGame();
                while (!game.isFinishGameLose() && !game.isFinishGameWin()) {
                    String inStr = input.nextLine();
                    if (game.validationStep(inStr)) {
                        game.doStep(inStr);
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