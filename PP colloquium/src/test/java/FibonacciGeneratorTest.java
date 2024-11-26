import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciGeneratorTest {

    //private final FibonacciGenerator generator = new FibonacciGenerator();

    @Test
    public void testGenerateFibonacciWithPositiveInput() {
        List<Integer> result = FibonacciGenerator.generateFibonacci(10);
        assertEquals(List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34), result);
    }

    @Test
    public void testGenerateFibonacciWithSingleElement() {
        List<Integer> result = FibonacciGenerator.generateFibonacci(1);
        assertEquals(List.of(0), result);
    }

    @Test
    public void testGenerateFibonacciWithTwoElements() {
        List<Integer> result = FibonacciGenerator.generateFibonacci(2);
        assertEquals(List.of(0, 1), result);
    }

    @Test
    public void testGenerateFibonacciWithZeroInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> FibonacciGenerator.generateFibonacci(0));
        assertEquals("n должно быть натуральным числом (n > 0).", exception.getMessage());
    }

    @Test
    public void testGenerateFibonacciWithNegativeInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> FibonacciGenerator.generateFibonacci(-5));
        assertEquals("n должно быть натуральным числом (n > 0).", exception.getMessage());
    }
}