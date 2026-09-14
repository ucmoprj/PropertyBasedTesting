package labs;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * LAB 6 - Assertions Inside a Property Are Just... JUnit Assertions
 *
 * There's no special "property assertion" API to learn. Everything from
 * Lab 0 - assertTrue, assertEquals, assertFalse, assertNotNull - works
 * exactly the same way inside a @Property method.
 *
 * HOW TO USE THIS FILE:
 *   Run:  mvn test -Dtest=Lab6_AssertionsTest
 *   Uncomment one STEP at a time, save, and re-run.
 */
@RunWith(JUnitQuickcheck.class)
public class Lab6_AssertionsTest {

    Calculator calculator = new Calculator();

    // A class annotated with @RunWith(JUnitQuickcheck.class) must have at
    // least one @Property method, or the run fails before you've even
    // uncommented anything. This placeholder keeps the file runnable from
    // the start - delete it once you've uncommented a real step below.
    @Property
    public void keepThisFileRunnable(int ignored) {
    }

    // STEP 1: assertTrue / assertFalse
    /*
    @Property
    public void isEvenOrIsOdd(int n) {
        assertTrue(calculator.isEven(n) || !calculator.isEven(n));
        assertFalse(calculator.isEven(n) && !calculator.isEven(n));
    }
    */

    // STEP 2: assertEquals with a helpful failure message - same signature
    // as plain JUnit: assertEquals(message, expected, actual).
    /*
    @Property
    public void addIsCommutative(int a, int b) {
        assertEquals(
                "add(a,b) should equal add(b,a) for a=" + a + ", b=" + b,
                calculator.add(a, b),
                calculator.add(b, a)
        );
    }
    */

    // STEP 3: assertNotNull - properties can check more than arithmetic.
    /*
    @Property
    public void stringValueOfIntIsNeverNull(int n) {
        assertNotNull(String.valueOf(n));
    }
    */
}
