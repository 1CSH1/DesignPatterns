package com.liebrother.designpatterns.lsp;

public class LSPTest {

    public static void main(String[] args) {
        Father1 father1 = new Father1();
        father1.braisedRibs();

        /** 错误示范 Son1 */
        Son1 son1 = new Son1();
        son1.braisedRibs();

        /** 正确示范 Son2 */
        Son2 son2 = new Son2();
        son2.braisedRibs();
        son2.braisedSweetAndSourPorkRibs();
    }

}


class Father1 {

    public void braisedRibs(){
        System.out.println("红烧排骨");
    }

}


class Son1 extends Father1 {

    public void braisedRibs(){
        System.out.println("红烧糖醋排骨");
    }

}

class Son2 extends Father1 {

    public void braisedSweetAndSourPorkRibs(){
        System.out.println("红烧糖醋排骨");
    }

}