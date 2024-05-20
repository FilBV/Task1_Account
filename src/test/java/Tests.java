import org.junit.jupiter.api.Test;
import ru.inno.tasks.*;


public class Tests {
    @Test
    public void SecondTest() {

        AccTest acc = new AccTest("Устинов Сергей Иванович");
        acc.setName("Иванов Петр Сергеевич");
        acc.addCur(Currency.RUB, 59);
        acc.setName("Петров Петр Сергеевич");
        acc.save();
        acc.addCur(Currency.RUB, 74);
        acc.addCur(Currency.EUR, 25);
        acc.undo();
        acc.addCur(Currency.EUR, 58);
        acc.setName("Иванов Петр Сергеевич");
        acc.save();
        acc.addCur(Currency.USD, 62);
        acc.addCur(Currency.USD, 35);
        acc.undo();
        acc.undo();
        acc.undo();
    }

}
