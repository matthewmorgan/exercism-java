import java.util.Arrays;
import java.util.Objects;

public class Scrabble {
    long score;
    String[] input;

    private static enum SCORE {
        A(1), E(1), I(1), O(1), U(1), L(1), N(1), R(1), S(1), T(1),
        D(2), G(2),
        B(3), C(3), M(3), P(3),
        F(4), H(4), V(4), W(4), Y(4),
        K(5),
        J(8), X(8),
        Q(10), Z(10);

        public long s;
        SCORE(long s){this.s=s;}
        public static long get(String tile){
            return SCORE.valueOf(tile).s;
        }
    }

    public Scrabble(String input){
        if (Objects.isNull(input)){ input="";}
        this.input=input.toUpperCase().replaceAll("[^A-Z]", "").split("");
        scoreWord();
    }

    private void scoreWord(){
        Arrays.stream(input).forEach((tile)->{
            score+=tile.isEmpty() ? 0 : SCORE.get(tile);
        });
    }

    public long getScore(){
        return score;
    }
};

