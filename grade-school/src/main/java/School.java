import java.util.*;

public class School {
    HashMap<Integer, List<String>> db = new HashMap<>();

    public void add(String name, Integer grade) {
        db.computeIfAbsent(grade, key -> new ArrayList<>()).add(name);
    }

    public HashMap<Integer, List<String>> db() {
        return db;
    }

    public List<String> grade(Integer grade){
        return db.computeIfAbsent(grade, key -> new ArrayList<>());
    }

    public HashMap<Integer, List<String>> sort(){
        db.keySet().stream().forEach(key -> Collections.sort(db.get(key)));
        return db;
    }
}
