package com.liebrother.designpatterns.prototype;

public class PrototypeTest {

    public static void main(String[] args) {
        Book2 book1 = new ConcreteBook("娱乐至死", "尼尔波兹曼", "社会科学", "XXXX");
        System.out.println("复印书籍：" + book1.getName() + "，第 " + 1 + " 本");
        for (int i = 2; i <= 10; i ++) {
            Book2 book2 = (Book2) book1.clone();
            System.out.println("复印书籍：" + book2.getName() + "，第 " + i + " 本");
        }


    }

}

/**
 * 抽象类
 */
abstract class Book2 implements Cloneable {

    private String name;
    private String author;
    private String type;
    private String content;

    public Book2(String name, String author, String type, String content) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.content = content;
        System.out.println("实例化书籍：" + this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

/**
 * 具体类
 */
class ConcreteBook extends Book2 {

    public ConcreteBook(String name, String author, String type, String content) {
        super(name, author, type, content);
    }
}