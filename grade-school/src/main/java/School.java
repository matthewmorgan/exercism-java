import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class School {
    HashMap<Integer, List<String>> db = new HashMap<>();

    public void add(String name, Integer grade) {
        if (db.containsKey(grade)){
            db.get(grade).add(name);
        } else {
            ArrayList<String> newRoster=new ArrayList<>();
            newRoster.add(name);
            db.put(grade, newRoster);
        }
    }

    public HashMap<Integer, List<String>> db(){
        return db;
    }
    public List<String> grade(Integer grade){
        return db.containsKey(grade) ? db.get(grade) : new ArrayList<String>();
    }

    public HashMap<Integer, List<String>> sort(){
        for (Integer grade: db.keySet()){
            Collections.sort(db.get(grade));
        }
        return db;
    }
}
