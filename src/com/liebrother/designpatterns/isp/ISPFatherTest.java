package com.liebrother.designpatterns.isp;

public class ISPFatherTest {

    public static void main(String[] args) {
        WangMather wangMather = new WangMather();
        wangMather.hairBraiding();
        wangMather.getDressed();
        wangMather.packingIntoTheBox();
        wangMather.makeTag();

        LiAunt liAunt = new LiAunt();
        liAunt.hairBraiding();
        liAunt.getDressed();
        liAunt.packingIntoTheBox();
        liAunt.makeTag();
    }

}

interface Work {

    void hairBraiding();
    void getDressed();
    void packingIntoTheBox();
    void makeTag();

}

class WangMather implements Work{

    @Override
    public void hairBraiding() {
        System.out.println("王大妈给布娃娃扎辫子");
    }

    @Override
    public void getDressed() {
        System.out.println("王大妈给布娃娃穿衣服");
    }

    @Override
    public void packingIntoTheBox() {
        System.out.println("王大妈把布娃娃装入箱子");
    }

    @Override
    public void makeTag() {
        System.out.println("王大妈给箱子打标签");
    }
}

class LiAunt implements Work {

    @Override
    public void hairBraiding() {
        System.out.println("李大姨给布娃娃扎辫子");
    }

    @Override
    public void getDressed() {
        System.out.println("李大姨给布娃娃穿衣服");
    }

    @Override
    public void packingIntoTheBox() {
        System.out.println("李大姨把布娃娃装入箱子");
    }

    @Override
    public void makeTag() {
        System.out.println("李大姨给箱子打标签");
    }
}