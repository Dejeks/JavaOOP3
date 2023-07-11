package org.example.Homework.HW9;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGame implements Game {
    protected String secretWord;
    protected int maxAttempts;
    protected int currentAttempt;
    protected GameStatus gameStatus;

    public AbstractGame() {
        this.maxAttempts = 5;
        this.currentAttempt = 1;
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    protected abstract String generateWord();

    protected List<Character> generateCharList() {
        List<Character> charList = new ArrayList<>();
        for (char c = '0'; c <= '9'; c++) {
            charList.add(c);
        }
        return charList;
    }

    protected Answer evaluateGuess(String guess) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secretWord.length(); i++) {
            char secretChar = secretWord.charAt(i);
            char guessChar = guess.charAt(i);
            if (secretChar == guessChar) {
                bulls++;
            } else if (secretWord.contains(String.valueOf(guessChar))) {
                cows++;
            }
        }
        return new Answer(bulls, cows);
    }

    @Override
    public void start() {
        secretWord = generateWord();
        System.out.println("Игра \"Быки и Коровы\" началась!");
        System.out.println("Попробуйте угадать число. Введите свой вариант:");
    }

    @Override
    public void inputValue(String guess) {
        Answer answer = evaluateGuess(guess);
        System.out.println(answer.getBulls() + " быка(ов), " + answer.getCows() + " коров(ы)");

        if (answer.getBulls() == secretWord.length()) {
            gameStatus = GameStatus.WON;
            System.out.println("Вы угадали число! Поздравляю с победой!");
        } else if (currentAttempt >= maxAttempts) {
            gameStatus = GameStatus.LOST;
            System.out.println("Попытки закончились. Вы проиграли. Загаданное число: " + secretWord);
        } else {
            currentAttempt++;
            System.out.println("Попробуйте еще раз:");
        }
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    @Override
    public void restart() {
        secretWord = generateWord();
        currentAttempt = 1;
        gameStatus = GameStatus.IN_PROGRESS;
        System.out.println("Игра перезапущена. Попробуйте угадать число. Введите свой вариант:");
    }
}
