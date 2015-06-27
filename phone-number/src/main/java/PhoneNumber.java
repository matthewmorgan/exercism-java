public class PhoneNumber {
    String phoneNumber="";
    public PhoneNumber(String input){
        input=input.replaceAll("[^0-9]", "");
        if (input.length()<10 | input.length()>11 | (input.length()==11 && input.charAt(0)!='1')){
            phoneNumber="0000000000";
        } else if (input.length()==11){
            phoneNumber=input.substring(1,11);
        } else {
            phoneNumber=input;
        }
    }

    public String getNumber(){
        return phoneNumber;
    }

    public String getAreaCode(){
        return phoneNumber.substring(0,3);
    }

    public String pretty(){
        return "("+getAreaCode()+") "+phoneNumber.substring(3,6)+"-"+phoneNumber.substring(6,10);
    }

}
