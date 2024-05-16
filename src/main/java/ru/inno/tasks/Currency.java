package ru.inno.tasks;

public enum Currency {

    RUB("Рубли"), EUR("Евро"), USD("Доллары");

    final private String name;

    Currency(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
