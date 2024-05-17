package ru.inno.tasks;

import lombok.Getter;

import java.util.*;

public class Account {
    @Getter
    String name;
    private Map<Currency, Integer> values = new HashMap<>();
    Deque<Action> deque = new ArrayDeque<>();


    private class Save {
        @Getter String name;
        @Getter private Map<Currency, Integer> values;

        public Save(String name, Map<Currency, Integer> values) {
            this.name = name;
            this.values = values;
        }

        @Override
        public String toString() {
            return "Save{" +
                    "name='" + name + '\'' +
                    ", values=" + values +
                    '}';
        }
    }

    public Save Save() {
        return new Save(name, values);
    }

    public void load(Save save) {
        name = save.name;
        values = save.values;
    }


    public Account(String name) {
        if (name.isBlank())
            throw new IllegalArgumentException("The name cannot be empty");
        this.name = name;
    }

    public void setName(String name) {
        if (name.isBlank())
            throw new IllegalArgumentException("The name cannot be empty");
        String tmp = this.name;
        deque.push(() -> Account.this.name = tmp);
        this.name = name;

    }

    public Map<Currency, Integer> getValues() {
        return new HashMap<>(values);
    }

    public void addCur(Currency cur, int val) {
        if (val < 0)
            throw new IllegalArgumentException("The val cannot be < 0");
        int tmp;
        if (values.get(cur) != null) {
            tmp = values.get(cur);
        } else {
            tmp = 0;
        }
        deque.push(() -> Account.this.values.put(cur, tmp));
        values.put(cur, val);
    }

    public void undo() {
        if (!deque.isEmpty()) {
            deque.pop().make();
        }
    }

}
