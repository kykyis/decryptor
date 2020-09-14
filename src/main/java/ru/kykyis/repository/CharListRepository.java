package ru.kykyis.repository;
import java.util.List;

public class CharListRepository {

    private final List<Character> list;


    public CharListRepository(List<Character> list) {
        this.list = list;
    }
    public List<Character> getList() {
        return this.list;
    }
    public void printList() {
        for (char symbol: list) {
            System.out.print(symbol);
        }
    }
}
