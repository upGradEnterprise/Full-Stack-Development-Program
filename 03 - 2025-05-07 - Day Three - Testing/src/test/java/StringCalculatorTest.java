import com.zeta.testing.bean.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    // Red Phase
    @Test void testEmptyStringReturnsZero() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    // Green Phase
    @Test void testSingleNumberReturnsThatNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
        assertEquals(2, calculator.add("2"));
    }

    // Refactor Phase
    @Test void testMultipleNumbersReturnsThatNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }

}