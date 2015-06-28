public class RomanNumeral {

    private String[] ONES={"I","X","C","M"};
    private String[] FIVES={"V","L","D"};
    private String[] arabic;
    private StringBuilder romanNumeral=new StringBuilder();

    public RomanNumeral (Integer input){
        arabic=input.toString().split("");
        int arabicLength=arabic.length;
        for (int ii=arabicLength; ii>0; ii--){
            String digit=arabic[arabicLength-ii];
            romanNumeral.append(getRomanDigit(digit, ii-1));
        }
    }

    public String getRomanNumeral(){
        return romanNumeral.toString();
    }

    private String getRomanDigit(String arabic, int pow){
        switch (arabic) {
            case "9": {
                return ONES[pow]+ONES[pow+1];
            }
            case "8": {
                return FIVES[pow]+ONES[pow]+ONES[pow]+ONES[pow];
            }
            case "7": {
                return FIVES[pow]+ONES[pow]+ONES[pow];
            }
            case "6": {
                return FIVES[pow]+ONES[pow];
            }
            case "5": {
                return FIVES[pow];
            }
            case "4": {
                return ONES[pow]+FIVES[pow];
            }
            case "3": {
                return ONES[pow]+ONES[pow]+ONES[pow];
            }
            case "2": {
                return ONES[pow]+ONES[pow];
            }
            case "1": {
                return ONES[pow];
            }
        }
        return "";
    };
}
