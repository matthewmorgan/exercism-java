public class Raindrops {
    public static String convert(Integer num) {
        StringBuilder result = new StringBuilder();
        result.append(num % 3 == 0 ? "Pling" : "");
        result.append(num % 5 == 0 ? "Plang" : "");
        result.append(num % 7 == 0 ? "Plong" : "");
        result = result.length() == 0 ? result.append(num) : result;
        return result.toString();
    }
}
