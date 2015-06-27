import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {
    public Map transform(Map<Integer, List<String>> oldMap){
        HashMap<String, Integer> newMap=new HashMap<>();
        oldMap.keySet().stream().forEach((score)->{
           oldMap.get(score).stream().forEach((letter)->{
               newMap.put(letter.toLowerCase(), score);
           });
        });
        return newMap;
    }
}