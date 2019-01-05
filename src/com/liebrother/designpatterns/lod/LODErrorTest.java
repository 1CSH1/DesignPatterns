package com.liebrother.designpatterns.lod;

/**
 * @author LieBrother
 * @date 2019/01/05
 */
public class LODErrorTest {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.readBook();
    }

}


/**
 * 错误的示范
 */
class Phone {
    App app = new App();
    Book book = new Book("设计模式");
    public void readBook() {
        app.read(book);
    }

}


class App {

    public void read(Book book) {
        System.out.println(book.getTitle());
    }

}

class Book {

    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
