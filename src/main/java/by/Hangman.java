package by;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary("/dictionary.txt");
        Scanner inputScanner = new Scanner(System.in);
        Player player = new Player();
        Game game = new Game(dictionary, player);
        game.play(inputScanner);
    }


}