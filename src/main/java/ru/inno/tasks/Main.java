package ru.inno.tasks;

public class Main {
    public static void main(String[] args) {

        Account acc = new Account("Устинов Сергей Иванович");

        acc.setName("Иванов Петр Сергеевич");

        acc.addCur(Currency.RUB, 59);
        acc.setName("Петров Петр Сергеевич");
        acc.addCur(Currency.RUB, 74);
        acc.addCur(Currency.EUR, 25);
        acc.addCur(Currency.EUR, 58);
//
//        acc.setName("Иванов Петр Сергеевич");

//
//        acc.addCur(Currency.USD, 62);
//        acc.addCur(Currency.USD, 35);
//
        System.out.println(acc.getName());
        System.out.println(acc.getValues());
        //System.out.println(acc.deque);

//        acc.undo();
//        acc.undo();
       acc.undo();
        acc.undo();
        acc.undo();
        acc.undo();
        acc.undo();
        acc.undo();


        System.out.println(acc.getName());
        System.out.println(acc.getValues());
       // System.out.println(acc.deque);


//        Save save = acc.save();
//        acc.undo();
//        Date date = new Date();
//        System.out.println(date);

    }
}