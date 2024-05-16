package ru.inno.tasks;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Account {
    @Setter
    String name;
    Map<Currency, Integer> values = new HashMap<>();

    public Account(String name) {
        this.name = name;
    }

    public void addCur(Currency cur, int val) {
        values.put(cur, val);
    }


}
