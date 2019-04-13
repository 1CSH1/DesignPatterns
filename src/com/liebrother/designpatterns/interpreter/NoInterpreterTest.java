package com.liebrother.designpatterns.interpreter;

import java.util.HashMap;
import java.util.Map;

public class NoInterpreterTest {

    public static void main(String[] args) {
        String tableName = "user";
        Map<String, Object> params = new HashMap<>();
        params.put("name", "小明");
        params.put("job", "Java 工程师");

        String sql = SQLUtil.insert(tableName, params);

        Map<String, Object> wheres = new HashMap<>();
        wheres.put("name", "小明");
        sql = SQLUtil.delete(tableName, wheres);

        params = new HashMap<>();
        params.put("job", "Java 高级工程师");
        wheres = new HashMap<>();
        wheres.put("name", "小明");
        sql = SQLUtil.update(tableName, params, wheres);

        sql = SQLUtil.select(tableName, wheres);
    }

}


class SQLUtil {

    public static String insert(String tableName, Map<String, Object> params) {
        StringBuilder insert = new StringBuilder();
        insert.append("insert into ")
                .append(tableName);

        // 解析 key value
        StringBuilder keys = new StringBuilder();
        StringBuilder values = new StringBuilder();
        keys.append("(");
        values.append("(");
        for (String key : params.keySet()) {
            keys.append(key).append(",");
            values.append("'").append(params.get(key)).append("',");
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

    public static String update(String tableName, Map<String, Object> params, Map<String, Object> wheres) {
        StringBuilder update = new StringBuilder();
        update.append("update ")
                .append(tableName)
                .append(" set ");

        StringBuilder values = new StringBuilder();
        for (String key : params.keySet()) {
            values.append(key)
                    .append(" = '")
                    .append(params.get(key))
                    .append("',");
        }

        StringBuilder wheresStr = new StringBuilder();
        wheresStr.append(" 1 = 1 ");
        for (String key : wheres.keySet()) {
            wheresStr.append(" and ")
                    .append(key)
                    .append(" = '")
                    .append(wheres.get(key))
                    .append("'");
        }

        update.append(values.substring(0, values.length() - 1))
                .append(" where ")
                .append(wheresStr);

        System.out.println("Update SQL : " + update.toString());
        return update.toString();
    }

    public static String select(String tableName, Map<String, Object> wheres) {
        StringBuilder select = new StringBuilder();
        select.append("select * from ")
                .append(tableName)
                .append(" where ")
                .append(" 1 = 1 ");
        for (String key : wheres.keySet()) {
            select.append(" and ")
                    .append(key)
                    .append(" = '")
                    .append(wheres.get(key))
                    .append("'");
        }
        System.out.println("Select SQL : " + select.toString());
        return select.toString();
    }

    public static String delete(String tableName, Map<String, Object> wheres) {
        StringBuilder delete = new StringBuilder();
        delete.append("delete from ")
                .append(tableName)
                .append(" where ")
                .append(" 1 = 1");
        for (String key : wheres.keySet()) {
            delete.append(" and ")
                    .append(key)
                    .append(" = '")
                    .append(wheres.get(key))
                    .append("'");
        }
        System.out.println("Delete SQL : " + delete.toString());

        return delete.toString();
    }
}