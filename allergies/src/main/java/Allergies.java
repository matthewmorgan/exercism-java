import java.util.Arrays;
import java.util.List;
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
                .filter(allergen -> (allergen.getScore() & code) > 0)
                .collect(Collectors.toList());
    }
}