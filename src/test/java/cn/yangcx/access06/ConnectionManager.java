package cn.yangcx.access06;

import java.util.Arrays;

/**
 * @author YANGCX
 * @date 2021/5/24 21:55
 */
public class ConnectionManager {

    public static Connection[] conn = new Connection[5];

    static {
        for (int i = 0; i < conn.length; i++) {
            conn[i] = Connection.getInstance();
        }
    }

    public static Connection getConnection() {
        int l = conn.length;
        if (l > 0) {
            // cxy 获取原数组元素并“删除”
            Connection con = conn[--l];
            conn = Arrays.copyOf(conn, l);
            return con;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            Connection con = ConnectionManager.getConnection();
            System.out.println(i + "' ==> " + con);
        }
    }

}


class Connection {

    private Connection() {
    }

    private static final Connection conn = new Connection();

    public static Connection getInstance() {
        return conn;
    }

}