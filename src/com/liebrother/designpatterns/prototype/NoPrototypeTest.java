package com.liebrother.designpatterns.prototype;

public class NoPrototypeTest {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i ++) {
            Book book = new Book("娱乐至死", "尼尔波兹曼", "社会科学", "XXXX");
            System.out.println("复印书籍：" + book.getName() + "，第 " + i + " 本");
        }
    }

}

class Book {
    private String name;
    private String author;
    private String type;
    private String content;

    public Book(String name, String author, String type, String content) {
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
}
