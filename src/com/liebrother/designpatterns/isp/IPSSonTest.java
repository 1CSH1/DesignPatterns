package com.liebrother.designpatterns.isp;

public class IPSSonTest {

    public static void main(String[] args) {
        LiAunt3 liAunt3 = new LiAunt3();
        WangMather3 wangMather3 = new WangMather3();
        ChenUncle chenUncle = new ChenUncle();
        HuangSister huangSister = new HuangSister();
        liAunt3.hairBraiding();
        wangMather3.getDressed();
        chenUncle.packingIntoTheBox();
        huangSister.makeTag();
    }

}

/**
 * 错误的示范
 */
class WangMather2 implements Work{

    @Override
    public void hairBraiding() {
    }

    @Override
    public void getDressed() {
        System.out.println("王大妈给布娃娃穿衣服");
    }

    @Override
    public void packingIntoTheBox() {
    }

    @Override
    public void makeTag() {
    }
}

class LiAunt2 implements Work {

    @Override
    public void hairBraiding() {
        System.out.println("李大姨给布娃娃扎辫子");
    }

    @Override
    public void getDressed() {
    }

    @Override
    public void packingIntoTheBox() {
    }

    @Override
    public void makeTag() {
    }
}

/**
 * 正确的示范
 */
interface Hair {
    void hairBraiding();
}

interface Dress {
    void getDressed();
}

interface Box {
    void packingIntoTheBox();
}

interface Tag {
    void makeTag();
}

/**
 * 李大姨给布娃娃扎辫子快
 */
class LiAunt3 implements Hair {

    @Override
    public void hairBraiding() {
        System.out.println("李大姨给布娃娃扎辫子");
    }
}

/**
 * 王大妈给布娃娃穿衣服快
 */
class WangMather3 implements Dress{

    @Override
    public void getDressed() {
        System.out.println("王大妈给布娃娃穿衣服");
    }

}

/**
 * 陈大叔包装快
 */
class ChenUncle implements Box {

    @Override
    public void packingIntoTheBox() {
        System.out.println("陈大叔给布娃娃装箱");
    }
}

/**
 * 黄大姐贴标签快
 */
class HuangSister implements Tag {

    @Override
    public void makeTag() {
        System.out.println("黄大姐给箱子打标签");
    }
}