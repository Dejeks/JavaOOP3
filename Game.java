package org.example.Homework.HW9;

public interface Game {
    void start();
    void inputValue(String guess);
    GameStatus getGameStatus();
    void restart();
}
