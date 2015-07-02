package logger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italobruno
 */
public class SystemLogger {

    private static final Logger logger = Logger.getLogger(SystemLogger.class.getName());

    public static void save(Level lvl, String msg) {
        logger.log(lvl, msg);
    }
}