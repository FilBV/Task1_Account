package ru.inno.tasks;

import lombok.Getter;

import java.util.*;

@Getter
public class Account {
    private String name;
    Map<Currency, Integer> values = new HashMap<>();

    public Account(String name) {
        if (name.isBlank())
            throw new IllegalArgumentException("The name cannot be empty");
        this.name = name;
    }

    public void setName(String name) {
        if (name.isBlank())
            throw new IllegalArgumentException("The name cannot be empty");
        this.name = name;
    }

    public void addCur(Currency cur, int val) {
        values.put(cur, val);
    }


}
