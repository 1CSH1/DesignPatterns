package com.liebrother.designpatterns.interpreter;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 * @date 2019/3/11
 */
public class InterpreterTest {
    public static void main(String[] args) {
//        Context ctx = new Context();
//        ctx.add(new SimpleExpression());
//        ctx.add(new AdvanceExpression());
//        ctx.add(new SimpleExpression());
//
//        for (Expression eps : ctx.getList()) {
//            eps.interpret(ctx);
//        }

//        TranslationSoftware software = new TranslationSoftware();
//        software.addLanguage(new EnglishLanguage());
//        software.addLanguage(new JapaneseLanguage());

//        Context context = new Context();
//        context.setContent("你好，世界");
//        Language englishLanguage = new EnglishLanguage();
//        String translateContent = englishLanguage.translate(context);
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

/*
class Context {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


abstract class Language {
    abstract String translate(Context context);
}

class EnglishLanguage extends Language {

    @Override
    public String translate(Context context) {
        System.out.println("中文转英文解析器。。。");
        String content = context.getContent();
        String translateContent = null;
        // 中文转英文解释器
        if ("你好，世界".equals(content)) {
            translateContent = "hello world";
        }
        System.out.println("【" + content + "】翻译成英文是：" + translateContent);
        return translateContent;
    }

}

class JapaneseLanguage extends Language {

      @Override
    public String translate(Context context) {
          System.out.println("中文转日文解析器。。。");
          String content = context.getContent();
          String translateContent = null;
          // 中文转日文解释器
          if ("你好，世界".equals(content)) {
              translateContent = "こんにちは、世界";
          }
          System.out.println("【" + content + "】翻译成日文是：" + translateContent);
          return translateContent;
    }

}

class TranslationSoftware {

    private List<Language> languageList = new ArrayList<>();

    public void addLanguage(Language language) {
        languageList.add(language);
    }

}

*/


/*
abstract class Expression {

    abstract void interpret(Context ctx);
}

class AdvanceExpression extends Expression {

    @Override
    void interpret(Context ctx) {
        System.out.println("这是高级解析器!");
    }
}

class SimpleExpression extends Expression {

    @Override
    void interpret(Context ctx) {
        System.out.println("这是普通解析器!");
    }
}

class Context {

    private String content;

    private List<Expression> list = new ArrayList();

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void add(Expression eps) {
        list.add(eps);
    }

    public List<Expression> getList() {
        return list;
    }
}
*/