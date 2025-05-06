import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {
    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

    public int sum(int first, int second) {
        logger.debug("Adding {} to {}", first, second);
        return first + second;
    }

    public int subtract(int first, int second) {
        logger.debug("Subtracting {} from {}", second, first);
        return first - second;
    }

    public int divide(int first, int second) throws ArithmeticException {
        if (second == 0) {
            logger.error("Dividing by zero");
            throw new ArithmeticException("Dividing by zero");
        }
        logger.debug("Dividing {} by {}", first, second);
        return first / second;
    }
}