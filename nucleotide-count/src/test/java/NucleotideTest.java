import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.entry;

import org.junit.Test;

import java.util.stream.IntStream;

public class NucleotideTest {
  @Test
  public void testEmptyDnaStringHasNoAdenosine() {
    DNA dna = new DNA("");
    assertThat(dna.count('A')).isEqualTo(0);
  }

  @Test
  public void testEmptyDnaStringHasNoNucleotides() {
    DNA dna = new DNA("");
    assertThat(dna.nucleotideCounts()).hasSize(4).contains(
            entry('A', 0),
            entry('C', 0),
            entry('G', 0),
            entry('T', 0)
    );
  }

  @Test
  public void testRepetitiveCytidineGetsCounted() {
    DNA dna = new DNA("CCCCC");
    assertThat(dna.count('C')).isEqualTo(5);
  }

  @Test
  public void testRepetitiveSequenceWithOnlyGuanosine() {
    DNA dna = new DNA("GGGGGGGG");
    assertThat(dna.nucleotideCounts()).hasSize(4).contains(
            entry('A', 0),
            entry('C', 0),
            entry('G', 8),
            entry('T', 0)
    );
  }

  @Test
  public void testCountsOnlyThymidine() {
    DNA dna = new DNA("GGGGGTAACCCGG");
    assertThat(dna.count('T')).isEqualTo(1);
  }

  @Test
  public void testCountsANucleotideOnlyOnce() {
    DNA dna = new DNA("CGATTGGG");
    dna.count('T');
    assertThat(dna.count('T')).isEqualTo(2);
  }

  @Test
  public void testDnaCountsDoNotChangeAfterCountingAdenosine() {
    DNA dna = new DNA("GATTACA");
    dna.count('A');
    assertThat(dna.nucleotideCounts()).hasSize(4).contains(
            entry('A', 3),
            entry('C', 1),
            entry('G', 1),
            entry('T', 2)
    );
  }

  @Test(expected = IllegalArgumentException.class)
  public void testValidatesNucleotides() {
    DNA dna = new DNA("GACT");
    dna.count('X');
  }

  @Test
  public void testCountsAllNucleotides() {
    String s = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
    DNA dna = new DNA(s);
    assertThat(dna.nucleotideCounts()).hasSize(4).contains(
            entry('A', 20),
            entry('C', 12),
            entry('G', 17),
            entry('T', 21)
    );
  }
    @Test
    public void testHandlesReallyReallyReallyLongStrands() {
        int cores = Runtime.getRuntime().availableProcessors();
        String smallStrand = "CTGTAACTCGCGTTAATCACTCTCGTGGTTTACGTACCGGGTGTGTGT"; // 7 A's, 11 C's, 13 G's, 17 T's = 48
        int numOfCopies = 1_000;
        int numOfSamples = 10_000;
        int sizeOfTargetDNAStrand = numOfCopies * smallStrand.length();
        double portionOfEachCPUTimeDoingCounting = 0.3;
        double observedDurationPer1000Copies = 1.7;
        double expectedAverageDuration = (numOfCopies / 1000 * observedDurationPer1000Copies) / (cores * portionOfEachCPUTimeDoingCounting);

        long startTime = System.currentTimeMillis();
        StringBuilder petriDish = new StringBuilder(sizeOfTargetDNAStrand);
        IntStream.range(0, numOfCopies).forEach(__ -> petriDish.append(smallStrand));
        String bigStrand = petriDish.toString();
        long buildTime = System.currentTimeMillis() - startTime;

        double averageDuration = IntStream.range(0, numOfSamples).mapToLong(__ -> {
            long countStartTime = System.currentTimeMillis();
            DNA dna = new DNA(bigStrand);
            long duration = System.currentTimeMillis() - countStartTime;
            assertThat(dna.nucleotideCounts()).contains(
                    entry('A', numOfCopies * 7),
                    entry('C', numOfCopies * 11),
                    entry('G', numOfCopies * 13),
                    entry('T', numOfCopies * 17)
            );
            return duration;
        }).average().getAsDouble();

        System.out.println("Build: " + buildTime + "ms");
        System.out.println("Average sequencing: " + averageDuration + "ms  (expected " + expectedAverageDuration + "ms.)");
        assertThat(averageDuration).isLessThan(expectedAverageDuration);
    }
}
