package labs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * LAB 0 - Plain JUnit Basics
 *
 * Before property-based testing, make sure you're comfortable with plain
 * JUnit. If you already know it, skim this lab and move on to Lab 1.
 *
 * HOW TO USE THIS FILE:
 *   Run:  mvn test -Dtest=Lab0_JUnitBasicsTest
 *   Uncomment the next STEP block, save, and re-run to see what changes.
 *   Do this one step at a time, in order.
 */
public class Lab0_JUnitBasicsTest {

    Calculator calculator;

    // @Before runs before EVERY @Test method below, so each test starts
    // with a fresh Calculator instead of sharing state with the others.
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    // A basic passing test: one specific input, one specific expected result.
    @Test
    public void fourIsEven() {
        assertTrue(calculator.isEven(4));
    }

    // STEP 1: Uncomment this test. It's wrong on purpose - 5 is odd, not
    // even. Run the tests and read the red failure message JUnit prints.
    /*
    @Test
    public void fiveIsEvenWrong() {
        assertTrue(calculator.isEven(5));
    }
    */

    // STEP 2: assertEquals compares two values instead of checking one
    // boolean condition.
    /*
    @Test
    public void twoPlusTwoIsFour() {
        assertEquals(4, calculator.add(2, 2));
    }
    */

    // STEP 3: One test method = one example. To check add() with different
    // kinds of numbers, you write MORE example-based tests, one per case.
    // Notice the repetition - that's the itch property-based testing
    // (starting in Lab 1) scratches.
    /*
    @Test
    public void addNegativeNumbers() {
        assertEquals(-3, calculator.add(-1, -2));
    }

    @Test
    public void addWithZero() {
        assertEquals(7, calculator.add(7, 0));
    }
    */
}
