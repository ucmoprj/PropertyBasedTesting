package labs;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import labs.generators.InputGenerator;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;

/**
 * LAB 7 - Reading a Shrunk Failure
 *
 * Uncomment the property below and run:
 *   mvn test -Dtest=Lab7_ShrinkingTest
 *
 * It WILL fail - that's the point. junit-quickcheck first finds some
 * random failing string (maybe 15+ characters long, full of noise), then
 * automatically "shrinks" it: it keeps trying smaller, simpler variants
 * that still fail, until it can't shrink any further.
 *
 * Read through the console/failure output for the sample value junit-
 * quickcheck settled on after shrinking - it should be dramatically
 * shorter than a typical generated string (often just a handful of
 * characters, sometimes a lone quote). That's the shrunk counterexample,
 * not the original messy one it happened to find first.
 *
 * This is the exact bug you can find in DataSanitizer.java: escaping a
 * quote by doubling it does not remove it.
 */
@RunWith(JUnitQuickcheck.class)
public class Lab7_ShrinkingTest {

    DataSanitizer sanitizer = new DataSanitizer();

    // A class annotated with @RunWith(JUnitQuickcheck.class) must have at
    // least one @Property method, or the run fails before you've even
    // uncommented anything. This placeholder keeps the file runnable from
    // the start - delete it once you've uncommented a real step below.
    @Property
    public void keepThisFileRunnable(int ignored) {
    }

    // STEP 1: Uncomment and run. Read the shrunk sample in the failure
    // output before you scroll past it.
    /*
    @Property(trials = 20)
    public void sanitizedInputNeverContainsAQuote(
            @From(InputGenerator.class) String input) {
        String sanitized = sanitizer.sanitizeInput(input);
        assertFalse(
                "Sanitized input should never contain a raw quote character",
                sanitized.contains("'")
        );
    }
    */

    // STEP 2: Now open DataSanitizer.java and change sanitizeInput() so it
    // actually REMOVES quotes instead of doubling them (e.g. replace "'"
    // with "" instead of "''"). Re-run this same test and confirm it now
    // passes across all 20 trials, with nothing to shrink.
}
