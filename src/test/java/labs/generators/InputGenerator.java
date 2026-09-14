package labs.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

/**
 * A custom generator that mixes ordinary letters/digits with
 * SQL-injection-style tokens ( ' and -- ) on purpose. The built-in String
 * generator (see Lab 2) produces arbitrary text and rarely happens to
 * include these specific characters — this generator biases toward them
 * so the property tests in Lab 4 and Lab 7 actually get a chance to catch
 * the bug in DataSanitizer.
 */
public class InputGenerator extends Generator<String> {

    private static final String SAFE_CHARS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
    private static final String[] UNSAFE_TOKENS = {"'", "--"};

    public InputGenerator() {
        super(String.class);
    }

    @Override
    public String generate(SourceOfRandomness random, GenerationStatus status) {
        int length = random.nextInt(3, 30);
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            if (random.nextInt(0, 3) == 0) {
                sb.append(UNSAFE_TOKENS[random.nextInt(0, UNSAFE_TOKENS.length - 1)]);
            } else {
                sb.append(SAFE_CHARS.charAt(random.nextInt(0, SAFE_CHARS.length() - 1)));
            }
        }
        return sb.toString();
    }
}
