package ru.inno.tasks;

public class Main {
    public static void main(String[] args) {

        Account acc = new Account("Устинов Сергей Иванович");
        System.out.println(acc.getName());

        acc.addCur(Currency.RUB, 59);
        acc.addCur(Currency.EUR, 25);
        acc.setName("Иванов Петр Сергеевич");

        acc.addCur(Currency.RUB, 74);
        acc.addCur(Currency.USD, 62);
        System.out.println(acc.getValues());


//        Save save = acc.save();
//        acc.undo();
//        Date date = new Date();
//        System.out.println(date);

    }
}