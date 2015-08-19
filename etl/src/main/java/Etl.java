import java.util.*;
import java.util.stream.*;

public class Etl {
    public static Map<String, Integer> transform(Map<Integer, List<String>> old) {
        return splitIntoPairs(old)
                .map(Pair::getPairWithLowerCaseLetter)
                .collect(toMapFromLetterToScore());
    }

    private static Stream<Pair> splitIntoPairs(Map<Integer, List<String>> scoreLists) {
        return scoreLists.entrySet().parallelStream()
                .flatMap(scoreList -> splitIntoPairs(scoreList.getKey(), scoreList.getValue()));
    }

    private static Stream<Pair> splitIntoPairs(Integer score, List<String> letters) {
        return letters.parallelStream()
                .map(letter -> new Pair(score, letter));
    }

    private static Collector<Pair, ?, Map<String, Integer>> toMapFromLetterToScore() {
        return Collectors.toMap(Pair::getLetter, Pair::getScore);
    }

    private static class Pair {
        Integer score;
        String letter;

        Pair(Integer score, String letter){
            this.score=score;
            this.letter=letter;
        }

        String getLetter(){
            return letter;
        }

        Pair getPairWithLowerCaseLetter(){
            return new Pair(score, letter.toLowerCase());
        }

        Integer getScore(){
            return score;
        }
    }
}