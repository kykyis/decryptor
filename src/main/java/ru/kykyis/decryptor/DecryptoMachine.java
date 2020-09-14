package ru.kykyis.decryptor;

import ru.kykyis.repository.AlphabetListRepository;

import java.util.ArrayList;
import java.util.List;

public class DecryptoMachine {

    static Shift direction = Shift.RIGHT;

    public static List<Character> encrypt(AlphabetListRepository alphabet, List<Character> list, int shift) {
        List<Character> encryptedList = new ArrayList<Character>();
        for (Character symbol: list) {
            Character newSymbol = shiftSymbol(alphabet, symbol, shift);
            encryptedList.add(newSymbol);
        }
        return encryptedList;
    }

    private static char shiftSymbol(AlphabetListRepository alphabet, Character symbol, int shift) {
        if (symbol.equals(' ') || symbol.equals('.') || symbol.equals(',') || symbol.equals('\r') || symbol.equals('\n')) {
            return symbol;
        }

        int number = -1;
        Case symbolCase = Case.LOW;

        for (Character search : alphabet.getLowerCaseAlphabet()) {
            if (search.equals(symbol)) {
                number = alphabet.getLowerCaseAlphabet().indexOf(search);
            }
        }
        if (number == -1) {
            for (Character search : alphabet.getUpperCaseAlphabet()) {
                if (search.equals(symbol)) {
                    number = alphabet.getUpperCaseAlphabet().indexOf(search);
                    symbolCase = Case.UP;
                }
            }
        }

        number += shift;
        while (number > 32) {
            number = number - 33;
            }
        while (number < 0) {
            number = 33 + number;
        }


        if (Case.UP.equals(symbolCase)) {
            return alphabet.getUpperCaseAlphabet().get(number);
        }
        return alphabet.getLowerCaseAlphabet().get(number);
    }

}
