package ru.inno.tasks;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SaveManager {

    public Map<Date, List<Save>> map;
    void loadTo (Date date){
        for (Save s:map.get(date))
            s.load();
    }

    @Override
    public String toString() {
        return "SaveManager{" +
                "map=" + map +
                '}';
    }
}

