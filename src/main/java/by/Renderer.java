package by;

public final class Renderer {
    private final static String[] GALLOWS = {
            """

        
         
         
         
        

------------------
""",
            """
|
|        \s
|        \s
|        \s
|        \s
|       \s
|
|------------------
""",
            """
|----------------
|        \s
|        \s
|        \s
|        \s
|       \s
|
|------------------
""",
            """
|----------------
|         |
|        \s
|        \s
|        \s
|       \s
|
|------------------
""",
            """
|----------------
|         |
|         O
|        \s
|        \s
|       \s
|
|------------------
""",
            """
|----------------
|         |
|         O
|         |
|         |
|       \s
|
|------------------
""",
            """
|----------------
|         |
|         O
|        /|
|         |
|       \s
|
|------------------
""",
            """
|----------------
|         |
|         O
|        /|\\
|         |
|       \s
|
|------------------
""",
            """
|----------------
|         |
|         O
|        /|\\
|         |
|        /\s
|
|------------------
""",
            """
|----------------
|         |
|         O
|        /|\\
|         |
|        / \\
|
|------------------
"""};

  private Renderer() {

  };

    public static void printError(int numberOfErr) {
        System.out.println("Вы ошиблись");
        System.out.println(GALLOWS[numberOfErr]);
    }

    public static void printStart(StringBuilder guessedLetters) {
        System.out.println("**************\n" +
                "Игра началась!\n" +
                "**************");
       System.out.println("Вы будете отгадывать слово: " + guessedLetters);
    }

    public static void printInfoStep(String word, Player player) {
        StringBuilder usedLetters = new StringBuilder();
        for (Step step : player.getSteps()) {
            usedLetters.append(step.getStep());
        }

        System.out.println("Введенные буквы:" + usedLetters);
        System.out.println("Слово: " + word);
    }

    public static void printLose(String word) {
        System.out.println("Вы проиграли!");
        System.out.println("Вы отгадывали слово: " + word);
    }

    public static void printWin(String word) {
        System.out.println("Вы выйграли!");
        System.out.println("Вы отгадали слово: " + word);
    }
}
