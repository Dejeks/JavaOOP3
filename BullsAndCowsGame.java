package org.example.Homework.HW9;

import java.util.Scanner;

public class BullsAndCowsGame {
    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            Game game = new NumberGame();
            game.start();

            while (game.getGameStatus() == GameStatus.IN_PROGRESS) {
                String guess = scanner.nextLine();
                game.inputValue(guess);
            }

            if (game.getGameStatus() == GameStatus.LOST) {
                System.out.println("Попытки закончились. Вы проиграли. Загаданное число: " + ((AbstractGame) game).secretWord);
            }

            System.out.println("Хотите сыграть еще раз? (да/нет)");
            String playAgainResponse = scanner.nextLine();
            playAgain = playAgainResponse.equalsIgnoreCase("да");
        }

        System.out.println("Спасибо за игру. До свидания!");
    }
}
