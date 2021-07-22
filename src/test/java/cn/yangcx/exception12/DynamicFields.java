package cn.yangcx.exception12;

/**
 * @author YANGCX
 * @date 2021/7/12 7:05
 */
public class DynamicFields {

    // 二维数组
    private Object[][] fields;

    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[]{null, null};
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Object[] field : fields) {
            builder.append(field[0]);
            builder.append(": ");
            builder.append(field[1]);
            builder.append("\n");
        }
        return builder.toString();
    }

    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++) {
            // 只比较了第1个元素
            if (id.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }

    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if (fieldNum == -1) {
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }

    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }
        // No empty fields, add one
        Object[][] tmp = new Object[fields.length + 1][2];
        System.arraycopy(fields, 0, tmp, 0, fields.length);
        for (int i = fields.length; i < tmp.length; i++) {
            // 初始化新增的元素
            tmp[i] = new Object[]{null, null};
        }
        fields = tmp;
        // Recursive call with expanded fields
        return makeField(id);
    }

    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(String id, Object value) throws DynamicFieldsException {
        if (value == null) {
            DynamicFieldsException dfe = new DynamicFieldsException();
            // todo 绝大多数异常没有含 cause 的构造函数，其子类要想保留原异常必须使用 initCause 方法
            //  里面的东西就是 Caused by 信息
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber = hasField(id);
        if (fieldNumber == -1) {
            fieldNumber = makeField(id);
        }
        Object result;
        try {
            result = getField(id);
        } catch (NoSuchFieldException e) {
            // 含 cause 的构造
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields dfs = new DynamicFields(3);
        System.out.println(dfs);
        try {
            dfs.setField("d", "A value for d");
            dfs.setField("number", 47);
            dfs.setField("number2", 48);
            System.out.println(dfs);
            dfs.setField("d", "A new value for d");
            dfs.setField("number3", 11);
            System.out.println("dfs: " + dfs);

            System.out.println("dfs.getField(\"d\"): " + dfs.getField("d"));
            Object field = dfs.setField("d", null);
        } catch (DynamicFieldsException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}

class DynamicFieldsException extends Exception {

    private static final long serialVersionUID = 7324181989824585710L;
}
