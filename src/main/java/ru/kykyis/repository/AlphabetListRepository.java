package ru.kykyis.repository;

import java.util.ArrayList;
import java.util.List;

public class AlphabetListRepository {

    private List<Character> lowerCaseAlphabet = new ArrayList<Character>();
    private List<Character> upperCaseAlphabet = new ArrayList<Character>();

    public AlphabetListRepository() {
        for (int i = 1040; i <= 1071; i++) {
            upperCaseAlphabet.add((char) i);
            if (i == 1045) {
                upperCaseAlphabet.add((char) 1025);
            }
        }
        for (int i = 1072; i <= 1103; i++) {
            lowerCaseAlphabet.add((char) i);
            if (i == 1077) {
                lowerCaseAlphabet.add((char) 1105);
            }
        }
    }

    public List<Character> getLowerCaseAlphabet() {
        return lowerCaseAlphabet;
    }

    public List<Character> getUpperCaseAlphabet() {
        return upperCaseAlphabet;
    }
}
