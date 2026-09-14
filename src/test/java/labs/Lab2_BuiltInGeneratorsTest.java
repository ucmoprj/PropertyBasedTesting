package labs;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * LAB 2 - Built-in Generators
 *
 * junit-quickcheck ships with generators for most common Java types: int,
 * long, double, boolean, String, char, and even List<T>/Set<T> of any type
 * it already knows how to generate. You only write your OWN generator
 * (Lab 4) when the built-in ones can't express what you need.
 *
 * HOW TO USE THIS FILE:
 *   Run:  mvn test -Dtest=Lab2_BuiltInGeneratorsTest
 *   Uncomment one STEP at a time, save, and re-run.
 */
@RunWith(JUnitQuickcheck.class)
public class Lab2_BuiltInGeneratorsTest {

    // A class annotated with @RunWith(JUnitQuickcheck.class) must have at
    // least one @Property method, or the run fails before you've even
    // uncommented anything. This placeholder keeps the file runnable from
    // the start - delete it once you've uncommented a real step below.
    @Property
    public void keepThisFileRunnable(int ignored) {
    }

    // STEP 1: int - you already saw this in Lab 1.
    /*
    @Property
    public void everyIntEqualsItself(int n) {
        assertEquals(n, n);
    }
    */

    // STEP 2: String - junit-quickcheck generates random (often unreadable,
    // sometimes empty, sometimes unicode-heavy) strings. Add -Dtest with
    // -q removed, or just check target/surefire-reports, to see the
    // println output, or run with `mvn test -Dtest=Lab2_BuiltInGeneratorsTest`
    // and watch the console.
    /*
    @Property
    public void everyStringHasNonNegativeLength(String s) {
        System.out.println("Generated string: [" + s + "]");
        assertTrue(s.length() >= 0);
    }
    */

    // STEP 3: boolean - only two possible values, but still randomly picked
    // on each of the default 100 trials.
    /*
    @Property
    public void booleanNegatedTwiceIsItself(boolean b) {
        assertEquals(b, !(!b));
    }
    */

    // STEP 4: List<Integer> - junit-quickcheck generates lists of varying,
    // random length, filled with random ints.
    /*
    @Property
    public void reversingTwiceGivesOriginalList(List<Integer> numbers) {
        List<Integer> once = new ArrayList<>(numbers);
        Collections.reverse(once);
        List<Integer> twice = new ArrayList<>(once);
        Collections.reverse(twice);
        assertEquals(numbers, twice);
    }
    */
}
