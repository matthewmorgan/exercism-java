import java.util.ArrayList;
import java.util.List;

public class Crypto {

    private String plain;
    private List<String> plainSegs;
    private StringBuilder crypto = new StringBuilder();
    private List<String> cryptoSegs;
    private int squareSize;

    public Crypto(String input) {
        plain = input.toLowerCase().replaceAll("[^\\w]", "");
        squareSize = new Double(Math.ceil(Math.sqrt(plain.length()))).intValue();
        plainSegs = makeSegments(plain);
        cryptoSegs = makeSegments(buildCipherText());
    }

    public int getSquareSize() {
        return squareSize;
    }

    public String getNormalizedPlaintext() {
        return plain;
    }

    public List<String> getPlaintextSegments() {
        return plainSegs;
    }

    public String getCipherText() {
        return crypto.toString();
    }

    public String getNormalizedCipherText() {
        return cryptoSegs.stream().reduce("", (seg, nextSeg) -> seg += " " + nextSeg).trim();
    }

    private List<String> makeSegments(String str) {
        int pos = 0;
        List<String> segs = new ArrayList<>();
        while (pos < str.length()) {
            int segSize = Math.min(squareSize, str.length() - pos);
            segs.add(str.substring(pos, pos + segSize));
            pos += squareSize;
        }
        return segs;
    }

    private String buildCipherText() {

        for (int ii = 0; ii < squareSize; ii++) {
            for (int jj = 0; jj < plainSegs.size(); jj++) {
                crypto.append(plainSegs.get(jj).length() <= ii ? ""
                        : plainSegs.get(jj).substring(ii, ii + 1));
            }
        }
        return crypto.toString();
    }
}


