package automation.utils;


import org.apache.log4j.Logger;

public class LoggerUtils {
    private static final Logger logger=Logger.getLogger(String.valueOf(LoggerUtils.class));
    public static void logInfo(String message)
    {
        logger.info(message);
    }
    public static void logError(String message)
    {
        logger.error(message);
    }
    public static void logDebug(String message)
    {
        logger.debug(message);
    }

}


