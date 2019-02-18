package com.liebrother.designpatterns.mediator;

import java.util.Arrays;
import java.util.List;

public class MediatorTest {

    public static void main(String[] args) {
        System.out.println("小明想要看小区房和农民房");
        Tenant2 xiaoMing = new Tenant2("小明", Arrays.asList("XiaoQuFang", "NongMinFang"));
        xiaoMing.lookAtHouse();
    }


}

/**
 * 租客
 */
class Tenant2 {
    private String name;
    private List<String> wantTypes;

    private RentingMediator rentingMediator = new RentingMediator();

    public Tenant2(String name, List<String> wantTypes) {
        this.name = name;
        this.wantTypes = wantTypes;
    }

    public void lookAtHouse() {
        rentingMediator.supplyHouse(wantTypes);
    }

}

/**
 * 中介抽象类
 */
abstract class Mediator {
    // 看房
    public abstract void supplyHouse(List<String> types);
}

/**
 * 租房中介
 */
class RentingMediator extends Mediator {

    private XiaoQuFangLandlord xiaoQuFangLandlord;
    private NongMinFangLandlord nongMinFangLandlord;

    public RentingMediator() {
        xiaoQuFangLandlord = new XiaoQuFangLandlord();
        nongMinFangLandlord = new NongMinFangLandlord();
    }

    @Override
    public void supplyHouse(List<String> types) {
        System.out.println("经纪人提供了如下房源");
        if (types.contains("XiaoQuFang")) {
            xiaoQuFangLandlord.supply();
        }
        if (types.contains("NongMinFang")) {
            nongMinFangLandlord.supply();
        }
    }
}

