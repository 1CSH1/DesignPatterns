package com.liebrother.designpatterns.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 * @date 2019/3/11
 */
public class InterpreterTest {
    public static void main(String[] args) {
        Context context = new Context();
        context.setTableName("user");

        // Insert SQL
        Map<String, Object> params = new HashMap<>();
        params.put("name", "小明");
        params.put("job", "Java 工程师");
        context.setParams(params);
        SQLExpression sqlExpression = new InsertSQLExpression();
        String sql = sqlExpression.interpret(context);

        // Delete SQL
        Map<String, Object> wheres = new HashMap<>();
        wheres.put("name", "小明");
        context.setParams(null);
        context.setWheres(wheres);
        sqlExpression = new DeleteSQLExpression();
        sql = sqlExpression.interpret(context);

        // Update SQL
        params = new HashMap<>();
        params.put("job", "Java 高级工程师");
        wheres = new HashMap<>();
        wheres.put("name", "小明");
        context.setParams(params);
        context.setWheres(wheres);
        sqlExpression = new UpdateSQLExpression();
        sql = sqlExpression.interpret(context);

        // Select SQL
        wheres = new HashMap<>();
        wheres.put("name", "小明");
        context.setParams(null);
        context.setWheres(wheres);
        sqlExpression = new SelectSQLExpression();
        sql = sqlExpression.interpret(context);
    }

}


/**
 * SQL 解释器
 */
abstract class SQLExpression {

    public abstract String interpret(Context context);

}

/**
 * 上下文
 */
class Context {
    private String tableName;
    private Map<String, Object> params = new HashMap<>();
    private Map<String, Object> wheres = new HashMap<>();

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

/**
 * Insert SQL 解释器
 */
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

/**
 * Update SQL 解释器
 */
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

/**
 * Select SQL 解释器
 */
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

/**
 * Delete SQL 解释器
 */
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
