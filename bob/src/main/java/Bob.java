import java.util.regex.Pattern;

public class Bob {
    Pattern alphaOnly= Pattern.compile("[a-zA-Z]+");

    public String hey(String input){
        input = (input instanceof String ? input.trim() : "");
        if (isSilent(input)){
            return "Fine. Be that way!";
        }
        if (isShouting(input)){
            return "Whoa, chill out!";
        }
        if (isQuestion(input)){
            return "Sure.";
        }
        return "Whatever.";
    }

    private Boolean isSilent(String input){
        return input.length()<1;
    }

    private Boolean isShouting(String input){
        return input.toUpperCase().equals(input) && alphaOnly.matcher(input).find();
    }

    private Boolean isQuestion(String input){
        return !isSilent(input) ? input.charAt(input.length()-1)=='?' : false;
    }

}
