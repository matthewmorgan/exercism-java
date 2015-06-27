import java.util.HashSet;

public class Robot {
    String name;
    static HashSet<String> usedNames=new HashSet<>();
    public Robot(){
        reset();
    }

    public String getName(){
        return name;
    };

    public void reset(){
        name="";
        while (name.isEmpty()){
            String test=generateName();
            if (!usedNames.contains(test)){
                usedNames.add(test);
                name=test;
            }
        }
    };

    private String generateName(){
        int l1=((Double)(Math.floor(Math.random()*26)+65)).intValue();
        int l2=((Double)(Math.floor(Math.random()*26)+65)).intValue();
        Integer n=((Double)Math.floor(Math.random()*1000)).intValue();
        String nString=n.toString();
        String gName=Character.toString((char)l1)
                +Character.toString((char)l2)
                +(("000"+nString).substring(nString.length()));
        return gName;
    };

}
