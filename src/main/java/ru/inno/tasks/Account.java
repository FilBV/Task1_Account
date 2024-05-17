package ru.inno.tasks;

import lombok.Getter;

import java.util.*;

public class Account {
    @Getter
    String name;
    private Map<Currency, Integer> values = new HashMap<>();
    Deque<Action> deque = new ArrayDeque<>();

    public Account(String name) {
        if (name.isBlank())
            throw new IllegalArgumentException("The name cannot be empty");
        this.name = name;
    }

    public void setName(String name) {
        if (name.isBlank())
            throw new IllegalArgumentException("The name cannot be empty");
        deque.push(new SetData(this.name));
        this.name = name;
    }

    private class SetData implements Action {
        String name_tmp;
        Currency cur_tmp;
        int val_tmp;

        public SetData(String name_tmp) {
            this.name_tmp = name_tmp;
        }

        public SetData(Currency cur_tmp, int val_tmp) {
            this.cur_tmp = cur_tmp;
            this.val_tmp = val_tmp;
        }

        @Override
        public void make() {
            if (name_tmp != null) {
                name = name_tmp;
            }
            if (cur_tmp != null) {
                values.put(cur_tmp, val_tmp);
            }
        }
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
        deque.push(new SetData(cur, tmp));
        values.put(cur, val);

    }
    public void undo() {
        deque.pop().make();
    }


}
