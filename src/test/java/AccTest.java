import lombok.Getter;
import ru.inno.tasks.Action;
import ru.inno.tasks.Currency;
import ru.inno.tasks.Save;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class AccTest {
    public int count_undo;
    public int count_save;
    @Getter
    private String name;
    private Map<ru.inno.tasks.Currency, Integer> values = new HashMap<>();
    Deque<Action> deque = new ArrayDeque<>();

    private class SaveImpl implements Save {

        private String name = AccTest.this.name;
        private Map<ru.inno.tasks.Currency, Integer> values = new HashMap<>(AccTest.this.values);

        public void load() {
            AccTest.this.name = name;
            AccTest.this.values = new HashMap<>(values);
        }
    }

    public SaveImpl save() {
        count_save++;
        return new SaveImpl();
    }

    public AccTest(String name) {
        if (name.isBlank())
            throw new IllegalArgumentException("The name cannot be empty");
        this.name = name;
    }

    public void setName(String name) {
        if (name.isBlank())
            throw new IllegalArgumentException("The name cannot be empty");
        String tmp = this.name;
        deque.push(() -> AccTest.this.name = tmp);
        this.name = name;

    }

    public Map<ru.inno.tasks.Currency, Integer> getValues() {
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
        deque.push(() -> AccTest.this.values.put(cur, tmp));
        values.put(cur, val);
    }

    public void undo() {
        count_undo++;
        if (!deque.isEmpty()) {
            deque.pop().make();
        }
    }

}
