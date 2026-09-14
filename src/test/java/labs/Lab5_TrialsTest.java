package labs;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * LAB 5 - Trials: How Many Random Cases Is Enough?
 *
 * @Property(trials = N) controls how many random inputs junit-quickcheck
 * tries before declaring the property holds. More trials means more
 * confidence, but a rare bug can still slip through a small number of
 * trials purely by chance.
 *
 * buggyAdd() below is broken ONLY when a is between 900 and 1000 - a
 * narrow window inside the [-1000, 1000] range used by the properties.
 *
 * HOW TO USE THIS FILE:
 *   Run:  mvn test -Dtest=Lab5_TrialsTest
 *   Uncomment one STEP at a time, save, and re-run SEVERAL times.
 */
@RunWith(JUnitQuickcheck.class)
public class Lab5_TrialsTest {

    // A method with a bug that only appears for a narrow slice of inputs.
    static int buggyAdd(int a, int b) {
        if (a >= 900 && a <= 1000) {
            return a + b + 1; // off-by-one, but only in this narrow window
        }
        return a + b;
    }

    // A class annotated with @RunWith(JUnitQuickcheck.class) must have at
    // least one @Property method, or the run fails before you've even
    // uncommented anything. This placeholder keeps the file runnable from
    // the start - delete it once you've uncommented a real step below.
    @Property
    public void keepThisFileRunnable(int ignored) {
    }

    // STEP 1: Only 5 trials. Run this several times in a row. Notice it
    // usually passes - 5 random samples out of [-1000, 1000] rarely land
    // inside the narrow [900, 1000] window where the bug lives.
    /*
    @Property(trials = 5)
    public void addNegationIsZero_fewTrials(
            @InRange(minInt = -1000, maxInt = 1000) int n) {
        assertEquals(0, buggyAdd(n, -n));
    }
    */

    // STEP 2: The exact same property, but 500 trials. Now it fails almost
    // every run, because with enough random samples the [900, 1000] window
    // eventually gets hit.
    /*
    @Property(trials = 500)
    public void addNegationIsZero_manyTrials(
            @InRange(minInt = -1000, maxInt = 1000) int n) {
        assertEquals(0, buggyAdd(n, -n));
    }
    */
}
