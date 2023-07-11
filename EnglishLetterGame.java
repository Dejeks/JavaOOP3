package org.example.Homework.HW9;

import java.util.*;
public class EnglishLetterGame extends AbstractGame {
    @Override
    protected String generateWord() {
        List<Character> charList = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            charList.add(c);
        }
        Collections.shuffle(charList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(charList.get(i));
        }
        return sb.toString();
    }
}
