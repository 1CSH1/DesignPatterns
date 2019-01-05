package com.liebrother.designpatterns.lod;

/**
 * @author LieBrother
 * @date 2019/01/05
 */
public class LODRightTest {

    public static void main(String[] args) {
        Phone2 phone2 = new Phone2();
        phone2.readBook();
    }

}

/**
 * 正确的示范
 */
class Phone2 {

    private App2 app2 = new App2();

    public void readBook() {
        app2.read();
    }

}


class App2 {
    private Book2 book2 = new Book2("设计模式");

    public void read() {
        System.out.println(book2.getTitle());
    }

}

class Book2 {

    private String title;

    public Book2(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}