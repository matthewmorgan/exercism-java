import java.util.*;
import java.util.stream.Collectors;

public class Allergies {

    int code;
    public Allergies(int code){
        this.code=code;
    }

    public Boolean isAllergicTo(Allergen allergen){
        return (code & allergen.getScore())>0;
    }

    public List<Allergen> getList(){
        return Arrays.stream(Allergen.values())
                        .filter(this::isAllergicTo)
                        .collect(Collectors.toList());
    }
}