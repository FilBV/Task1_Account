import org.junit.jupiter.api.Test;
import ru.inno.tasks.*;


public class Tests {
    @Test
    public void SecondTest() {

        Account acc = new Account("Устинов Сергей Иванович");
        acc.addCur(Currency.RUB, 59);
        acc.addCur(Currency.EUR, 25);
        acc.setName("Иванов Петр Сергеевич");
        acc.addCur(Currency.RUB, 74);
        acc.addCur(Currency.USD, 62);

        System.out.println(acc.getName());
        System.out.println(acc.getValues());

        //Save save = acc.save();
        acc.undo();

        System.out.println(acc.getName());
        System.out.println(acc.getValues());
    }

}
