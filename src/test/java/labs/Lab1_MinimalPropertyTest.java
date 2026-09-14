package labs;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * LAB 1 - The Smallest Possible Property Test
 *
 * Two things turn a normal JUnit test class into a property-based one:
 *   1. @RunWith(JUnitQuickcheck.class) on the class
 *   2. @Property (instead of @Test) on the method
 *
 * junit-quickcheck already knows how to generate plain ints, so nothing
 * extra is needed to get started - no generator class, no annotation.
 *
 * HOW TO USE THIS FILE:
 *   Run:  mvn test -Dtest=Lab1_MinimalPropertyTest
 *   Uncomment one STEP at a time, save, and re-run.
 */
@RunWith(JUnitQuickcheck.class)
public class Lab1_MinimalPropertyTest {

    Calculator calculator = new Calculator();

    // A class annotated with @RunWith(JUnitQuickcheck.class) must have at
    // least one @Property method, or the run fails before you've even
    // uncommented anything. This placeholder keeps the file runnable from
    // the start - delete it once you've uncommented a real step below.
    @Property
    public void keepThisFileRunnable(int ignored) {
    }

    // STEP 1: Uncomment this. junit-quickcheck will call it 100 times (the
    // default trial count) with a different random a and b each time.
    /*
    @Property
    public void additionIsCommutative(int a, int b) {
        assertEquals(calculator.add(a, b), calculator.add(b, a));
    }
    */

    // STEP 2: Uncomment this one too. Compare how little code this took
    // versus writing addNegativeNumbers / addWithZero / ... by hand,
    // the way Lab 0 did.
    /*
    @Property
    public void isEvenMatchesModulo(int n) {
        assertEquals(n % 2 == 0, calculator.isEven(n));
    }
    */
}
