package labs;

/**
 * Intentionally contains a realistic bug: it ESCAPES a single quote by
 * doubling it (the standard SQL-escaping technique) rather than removing
 * it. That's fine for preventing SQL injection when the result is used
 * inside a parameterized query context, but it means the output can still
 * legitimately contain a quote character. Lab 7 uses property-based
 * testing to surface exactly that mismatch between what this method does
 * and what a naive test might assume it does.
 */
public class DataSanitizer {

    public String sanitizeInput(String input) {
        return input.replaceAll("'", "''").replaceAll("--", "");
    }
}
