import java.util.*;

public class School {
    private final HashMap<Integer, List<String>> db = new HashMap<>();

    public void add(String name, Integer grade) {
        db.computeIfAbsent(grade, key -> new ArrayList<>()).add(name);
    }

    public Map<Integer, List<String>> db() {
        return Collections.unmodifiableMap(db);
    }

    public List<String> grade(Integer grade){
        return Collections.unmodifiableList(db.computeIfAbsent(grade, key -> new ArrayList<>()));
    }

    public Map<Integer, List<String>> sort(){
        db.keySet().stream().forEach(key -> Collections.sort(db.get(key)));
        return db();
    }
}
