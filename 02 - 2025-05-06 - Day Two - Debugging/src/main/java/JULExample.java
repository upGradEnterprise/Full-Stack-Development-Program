import java.util.logging.Level;
import java.util.logging.Logger;

public class JULExample {
    private static final Logger logger = Logger.getLogger(JULExample.class.getName());

    public static void main(String[] args) {
        logger.setLevel(Level.FINEST);

        logger.finest("Finest Message"); // will not be printed by default
        logger.finer("Finer Message"); // will not be printed by default
        logger.fine("Fine Message"); // will not be printed by default

        logger.config("Config Message");
        logger.warning("Warning");
        logger.severe("Severe Message");
        logger.info( "Info Message");
    }
}
