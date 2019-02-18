package com.liebrother.designpatterns.mediator;

public class PersonalTest {

    public static void main(String[] args) {
        Tenant xiaoMing = new Tenant("小明");
        xiaoMing.lookAtHouse();
    }

}

class Tenant {
    private String name;
    private XiaoQuFangLandlord xiaoQuFangLandlord2 = new XiaoQuFangLandlord();
    private NongMinFangLandlord nongMinFangLandlord2 = new NongMinFangLandlord();

    public Tenant(String name) {
        this.name = name;
    }

    public void lookAtHouse() {
        System.out.println(this.name +"想看农民房");
        nongMinFangLandlord2.supply();
        System.out.println(this.name + "想看小区房");
        xiaoQuFangLandlord2.supply();
    }

}

/**
 * 房东
 */
abstract class Landlord {
    // 提供房子
    public abstract void supply();
}

class XiaoQuFangLandlord extends Landlord {

    @Override
    public void supply() {
        System.out.println("小区房的房东提供一间小区房");
    }
}

class NongMinFangLandlord extends Landlord {

    @Override
    public void supply() {
        System.out.println("农民房的房东提供一间小区房");
    }
}
