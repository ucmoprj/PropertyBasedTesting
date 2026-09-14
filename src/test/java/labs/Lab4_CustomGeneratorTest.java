package labs;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import labs.generators.InputGenerator;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;

/**
 * LAB 4 - Writing Your Own Generator
 *
 * The built-in String generator (Lab 2) produces arbitrary strings - great
 * for general fuzzing, but it rarely happens to include specific patterns
 * like an apostrophe or "--". When you need inputs biased toward a
 * particular shape, write a custom Generator<T> and select it with @From.
 *
 * See src/test/java/labs/generators/InputGenerator.java - it mixes
 * ordinary letters/digits with SQL-injection-style tokens ( ' and -- )
 * on purpose.
 *
 * HOW TO USE THIS FILE:
 *   Run:  mvn test -Dtest=Lab4_CustomGeneratorTest
 *   Uncomment one STEP at a time, save, and re-run.
 */
@RunWith(JUnitQuickcheck.class)
public class Lab4_CustomGeneratorTest {

    DataSanitizer sanitizer = new DataSanitizer();

    // A class annotated with @RunWith(JUnitQuickcheck.class) must have at
    // least one @Property method, or the run fails before you've even
    // uncommented anything. This placeholder keeps the file runnable from
    // the start - delete it once you've uncommented a real step below.
    @Property
    public void keepThisFileRunnable(int ignored) {
    }

    // STEP 1: Without @From, you get the generic built-in String generator.
    // Run this a bunch of times - it rarely contains a real apostrophe, so
    // it usually passes even though the sanitizer has a real bug.
    /*
    @Property(trials = 20)
    public void sanitizedInputNeverContainsQuote_genericStrings(String input) {
        String sanitized = sanitizer.sanitizeInput(input);
        System.out.println("[generic]  " + input + "  ->  " + sanitized);
        assertFalse(sanitized.contains("'"));
    }
    */

    // STEP 2: With @From(InputGenerator.class), unsafe characters show up
    // constantly, because that's exactly what this generator is built to
    // do. Now the same property fails, reliably.
    /*
    @Property(trials = 20)
    public void sanitizedInputNeverContainsQuote_customGenerator(
            @From(InputGenerator.class) String input) {
        String sanitized = sanitizer.sanitizeInput(input);
        System.out.println("[custom]   " + input + "  ->  " + sanitized);
        assertFalse(sanitized.contains("'"));
    }
    */
}
