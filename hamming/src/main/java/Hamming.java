public class Hamming {
    public static Integer compute(String a, String b){
        if (a.length()!=b.length()) throw (new IllegalArgumentException());
        String[] left=a.split("");
        String[] right=b.split("");
        Integer count=0;
        for (int ii=0;ii<left.length;ii++){
            count+=(left[ii].equals(right[ii]) ? 0 : 1);
        }
        return count;
    }
}
