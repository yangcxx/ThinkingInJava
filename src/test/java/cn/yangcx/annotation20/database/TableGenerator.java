package cn.yangcx.annotation20.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author YANGCX
 * @date 2021/9/6 21:31
 */
public class TableGenerator {

    public static void main(String[] args) throws Exception {
        String[] newArgs = {"cn.yangcx.annotation20.database.Member"};
        for (String className : newArgs) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getDeclaredAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            // If the name is empty, use the Class name
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase(Locale.CHINA);
            }
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue;
                }
                Annotation annotation = anns[0];
                if (annotation instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) annotation;
                    // Use field name if name not specified
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase(Locale.CHINA);
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                } else if (annotation instanceof SQLString) {
                    SQLString sString = (SQLString) annotation;
                    // Use field name if name not specified
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase(Locale.CHINA);
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
                }
            }

            StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
            for (String columnDef : columnDefs) {
                createCommand.append("\n    ")
                        .append(columnDef)
                        .append(",");
            }
            // Remove trailing comma
            String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
            System.out.println("Table Creation SQL for " + className + " is:\n " + tableCreate);
        }
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += "NOT NULL";
        }
        if (con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }

}
