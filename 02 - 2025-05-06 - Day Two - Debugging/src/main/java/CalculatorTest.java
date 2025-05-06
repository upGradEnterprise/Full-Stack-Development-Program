import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorTest {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorTest.class);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int first = 26;
        int second = 0;

        logger.info("Starting Calculations with first={}, second={}", first, second);

        int sum = calculator.sum(first, second);
        logger.info("Sum: {}", sum);

        int difference = calculator.subtract(first, second);
        logger.info("Difference: {}", difference);

        try {
            int division = calculator.divide(first, second);
            logger.info("Division: {}", division);
        } catch (ArithmeticException ae) {
            logger.error(ae.getMessage());
        }

        logger.info("Calculations Completed!");
    }
}
