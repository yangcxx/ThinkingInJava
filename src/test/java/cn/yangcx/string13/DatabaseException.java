package cn.yangcx.string13;

/**
 * @author YANGCX
 * @date 2021/7/18 18:59
 */
public class DatabaseException extends Exception {

    private static final long serialVersionUID = 6161967532183350893L;

    public DatabaseException(int transactionID, int queryID, String message) {
        // String.format 方法内部实现也是使用 java.util.Formatter 实现的
        super(String.format("(t%d, q%d) %s", transactionID, queryID, message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3, 4, "Write failed");
        } catch (DatabaseException e) {
            System.out.println(e);
        }
    }
}
