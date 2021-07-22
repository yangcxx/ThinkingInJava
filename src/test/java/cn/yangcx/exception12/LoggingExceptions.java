package cn.yangcx.exception12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author YANGCX
 * @date 2021/7/8 7:34
 */
public class LoggingExceptions {

    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }

}


class LoggingException extends Exception {
    private static final Logger LOGGER = Logger.getLogger("LoggingException");
    private static final long serialVersionUID = -8902936196723893766L;

    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        LOGGER.severe(trace.toString());
    }

    @Override
    public String getMessage() {
        return "Detail Message: 对于异常来说，getMessage()相当于toString()方法";
    }
}
