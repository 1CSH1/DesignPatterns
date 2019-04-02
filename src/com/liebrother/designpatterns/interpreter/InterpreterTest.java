package com.liebrother.designpatterns.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 * @date 2019/3/11
 */
public class InterpreterTest {
    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "小明");
        params.put("job", "Java 工程师");
        Context context = new Context("user", params, null);
        SQLExpression insert = new InsertSQLExpression();
        String insertSql = insert.interpret(context);

        Map<String, Object> wheres = new HashMap<>();
        wheres.put("name", "小明");
        Context context1 = new Context("user", null, wheres);
        SQLExpression delete = new DeleteSQLExpression();
        String deleteSql = delete.interpret(context1);

        Map<String, Object> params2 = new HashMap<>();
        params2.put("job", "Java 高级工程师");
        Map<String, Object> wheres2 = new HashMap<>();
        wheres2.put("name", "小明");
        Context context2 = new Context("user", params2, wheres2);
        SQLExpression update = new UpdateSQLExpression();
        String updateSql = update.interpret(context2);

        Map<String, Object> wheres3 = new HashMap<>();
        wheres3.put("name", "小明");
        Context context3 = new Context("user", null, wheres3);
        SQLExpression select = new SelectSQLExpression();
        String selectSql = select.interpret(context3);

    }

}


/**
 * SQL 解释器
 */
abstract class SQLExpression {
    public abstract String interpret(Context context);
}

class Context {
    private String tableName;
    private Map<String, Object> params = new HashMap<>();
    private Map<String, Object> wheres = new HashMap<>();

    public Context(String tableName, Map<String, Object> params, Map<String, Object> wheres) {
        this.tableName = tableName;
        if (null != params) {
            this.params = params;
        }
        if (null != wheres) {
            this.wheres = wheres;
        }
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Map<String, Object> getWheres() {
        return wheres;
    }

    public void setWheres(Map<String, Object> wheres) {
        this.wheres = wheres;
    }
}

class InsertSQLExpression extends SQLExpression {

    @Override
    public String interpret(Context context) {
        StringBuilder insert = new StringBuilder();
        insert.append("insert into ")
                .append(context.getTableName());

        // 解析 key value
        StringBuilder keys = new StringBuilder();
        StringBuilder values = new StringBuilder();
        keys.append("(");
        values.append("(");
        for (String key : context.getParams().keySet()) {
            keys.append(key).append(",");
            values.append("'").append(context.getParams().get(key)).append("',");
        }
        keys = keys.replace(keys.length() - 1, keys.length(), ")");
        values = values.replace(values.length() - 1, values.length(), ")");

        // 拼接 keys values
        insert.append(keys)
                .append(" values ")
                .append(values);

        System.out.println("Insert SQL : " + insert.toString());
        return insert.toString();
    }
}


class UpdateSQLExpression extends SQLExpression {

    @Override
    public String interpret(Context context) {
        StringBuilder update = new StringBuilder();
        update.append("update ")
                .append(context.getTableName())
                .append(" set ");

        StringBuilder values = new StringBuilder();
        for (String key : context.getParams().keySet()) {
            values.append(key)
                    .append(" = '")
                    .append(context.getParams().get(key))
                    .append("',");
        }

        StringBuilder wheres = new StringBuilder();
        wheres.append(" 1 = 1 ");
        for (String key : context.getWheres().keySet()) {
            wheres.append(" and ")
                    .append(key)
                    .append(" = '")
                    .append(context.getWheres().get(key))
                    .append("'");
        }

        update.append(values.substring(0, values.length() - 1))
                .append(" where ")
                .append(wheres);

        System.out.println("Update SQL : " + update.toString());
        return update.toString();
    }
}

class SelectSQLExpression extends SQLExpression {

    @Override
    public String interpret(Context context) {
        StringBuilder select = new StringBuilder();
        select.append("select * from ")
                .append(context.getTableName())
                .append(" where ")
                .append(" 1 = 1 ");
        for (String key : context.getWheres().keySet()) {
            select.append(" and ")
                    .append(key)
                    .append(" = '")
                    .append(context.getWheres().get(key))
                    .append("'");
        }
        System.out.println("Select SQL : " + select.toString());
        return select.toString();
    }
}

class DeleteSQLExpression extends SQLExpression {

    @Override
    public String interpret(Context context) {
        StringBuilder delete = new StringBuilder();
        delete.append("delete from ")
                .append(context.getTableName())
                .append(" where ")
                .append(" 1 = 1");
        for (String key : context.getWheres().keySet()) {
            delete.append(" and ")
                    .append(key)
                    .append(" = '")
                    .append(context.getWheres().get(key))
                    .append("'");
        }
        System.out.println("Delete SQL : " + delete.toString());

        return delete.toString();
    }
}
