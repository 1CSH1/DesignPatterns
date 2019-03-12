package com.liebrother.designpatterns.interpreter;

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
        /*Context ctx = new Context();
        ctx.add(new SimpleExpression());
        ctx.add(new AdvanceExpression());
        ctx.add(new SimpleExpression());

        for (Expression eps : ctx.getList()) {
            eps.interpret(ctx);
        }*/

    }

}

abstract class Language {
    abstract String translate(String content);
}

class EnglishLanguage extends Language {

    private Map<String, String> words;

    public EnglishLanguage() {
        this.words = new HashMap<>();
        this.words.put("你好", "hello");
        this.words.put("世界", "world");
    }

    @Override
    public String translate(String content) {
        String traslateWord = this.words.get(content);
        System.out.println("【" + content + "】翻译成英文是：" + traslateWord);
        return traslateWord;
    }
}

class JapaneseLanguage extends Language {

    private Map<String, String> words;

    public JapaneseLanguage() {
        this.words = new HashMap<>();
        this.words.put("你好", "こんにちは");
        this.words.put("世界", "世界");
    }

    @Override
    public String translate(String content) {
        String traslateWord = this.words.get(content);
        System.out.println("【" + content + "】翻译成日文是：" + traslateWord);
        return traslateWord;
    }
}

class TranslationSoftware {

    private List<Language> languageList = new ArrayList<>();

    public void addLanguage(Language language) {
        languageList.add(language);
    }

}




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