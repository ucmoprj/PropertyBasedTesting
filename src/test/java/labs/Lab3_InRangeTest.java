package labs;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * LAB 3 - Constraining Values with @InRange
 *
 * Sometimes a property only makes sense for a restricted range of values
 * (e.g. "positive numbers only", or numbers small enough that arithmetic
 * on them can't overflow). Instead of writing a whole custom Generator
 * class for that, annotate the parameter with @InRange.
 *
 * HOW TO USE THIS FILE:
 *   Run:  mvn test -Dtest=Lab3_InRangeTest
 *   Uncomment one STEP at a time, save, and re-run.
 */
@RunWith(JUnitQuickcheck.class)
public class Lab3_InRangeTest {

    Calculator calculator = new Calculator();

    // A class annotated with @RunWith(JUnitQuickcheck.class) must have at
    // least one @Property method, or the run fails before you've even
    // uncommented anything. This placeholder keeps the file runnable from
    // the start - delete it once you've uncommented a real step below.
    @Property
    public void keepThisFileRunnable(int ignored) {
    }

    // STEP 1: Without a range, n can be ANY int - including huge negative
    // numbers close to Integer.MIN_VALUE, where -n overflows back to the
    // same negative number instead of becoming positive. Uncomment this
    // and run it a few times; it will occasionally fail.
    // 4 bit −8, 7, two's complement
    /*
    @Property
    public void addingNegationGivesZero_unconstrained(int n) {
        assertEquals(0, calculator.add(n, -n));
    }
    */

    // STEP 2: Add @InRange to keep n away from the overflow edge, and the
    // exact same property now passes reliably, every run.
    /*
    @Property
    public void addingNegationGivesZero_constrained(
            @InRange(minInt = -1_000_000, maxInt = 1_000_000) int n) {
        assertEquals(0, calculator.add(n, -n));
    }
    */

    // STEP 3: @InRange also works for "only positive numbers" style
    // constraints on individual parameters - no custom PositiveIntGenerator
    // class required. You can put a different range on each parameter.
    /*
    @Property
    public void addingAPositiveNumberIncreasesTheResult(
            @InRange(minInt = -1_000_000, maxInt = 1_000_000) int n,
            @InRange(minInt = 1, maxInt = 1_000_000) int positive) {
        assertTrue(calculator.add(n, positive) > n);
    }
    */
}
