# Property-Based Testing Labs

Eight small labs, in order, teaching property-based testing with
[junit-quickcheck](https://github.com/pholser/junit-quickcheck) on top of
plain JUnit 4.

## Setup

You need JDK 11+ and Maven installed.

```
mvn test
```

This compiles the project and runs every lab's *currently uncommented*
code. Right after cloning, most `@Test`/`@Property` methods are commented
out on purpose — you'll uncomment them step by step.

## How each lab works

Every test file under `src/test/java/labs/` has a doc comment at the top
explaining the concept, followed by one or more `STEP` blocks wrapped in
`/* ... */`. Work through a lab like this:

1. Open the file.
2. Uncomment the next `STEP` block only.
3. Run just that file: `mvn test -Dtest=<ClassName>`
4. Read the console output — especially failures. They're often
   intentional.
5. Move to the next `STEP`.

## Lab order

| # | File | Concept |
|---|------|---------|
| 0 | `Lab0_JUnitBasicsTest` | Plain JUnit: `@Test`, `@Before`, `assertEquals`/`assertTrue` — start here if JUnit is new to you |
| 1 | `Lab1_MinimalPropertyTest` | The smallest property test: `@RunWith(JUnitQuickcheck.class)` + `@Property` |
| 2 | `Lab2_BuiltInGeneratorsTest` | Built-in generators for `int`, `String`, `boolean`, `List<Integer>` |
| 3 | `Lab3_InRangeTest` | Constraining generated values with `@InRange` instead of writing a custom generator |
| 4 | `Lab4_CustomGeneratorTest` | Writing your own `Generator<T>` and selecting it with `@From` |
| 5 | `Lab5_TrialsTest` | How the `trials` count affects the odds of catching a rare bug |
| 6 | `Lab6_AssertionsTest` | Property methods use the exact same assertions as regular JUnit |
| 7 | `Lab7_ShrinkingTest` | Reading a shrunk counterexample when a property fails |

## The two classes under test

- `Calculator` (`isEven`, `add`) — used in Labs 0, 1, 2, 3, 5, 6.
- `DataSanitizer` (`sanitizeInput`) — contains a real bug (escapes a quote
  by doubling it instead of removing it). Labs 4 and 7 use property-based
  testing to find that bug the way it would surface in practice.

## File layout note

`InputGenerator` lives under `src/test/java/labs/generators/`, not
`src/main`, because it depends on junit-quickcheck, which is a
test-scoped dependency — a custom `Generator<T>` is test infrastructure,
not production code.

## Why some properties are written to fail

A few `STEP`s are deliberately broken (e.g. Lab 3 Step 1, Lab 5 Step 1,
Lab 7 Step 1). Property-based testing is as much about learning to read
and shrink a *failure* as it is about writing a *passing* test — don't
skip past a red run without reading what it printed.
