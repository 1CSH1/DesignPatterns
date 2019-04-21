package com.liebrother.designpatterns.adapter;

public class AdapterTest {

    public static void main(String[] args) {
        Target target = new ChargerAdapter(new BritishCharger());
        target.chargeByChineseStandard();
    }

}

/**
 * 英式充电器
 */
class BritishCharger {

    public void chargeByBritishStandard(){
        System.out.println("用英式充电器充电");
    }

}

/**
 * 使用中式插座充电
 */
interface Target {

    void chargeByChineseStandard();

}

/**
 * 充电器适配器
 */
class ChargerAdapter implements Target {

    private BritishCharger britishCharger;

    public ChargerAdapter(BritishCharger britishCharger) {
        this.britishCharger = britishCharger;
    }

    @Override
    public void chargeByChineseStandard() {
        System.out.println("使用中英式插头转换器");
        britishCharger.chargeByBritishStandard();
    }
}

///**
// * 中国插座
// */
//class Adaptee {
//
//    public void chargeByChineseStandard(){
//        System.out.println("用中国插座充电");
//    }
//
//}
//
///**
// * 目标
// */
//interface Target {
//
//    void chargeByBritishStandard();
//
//}
//
///**
// * 转换器
// */
//class Adapter implements Target{
//
//    private Adaptee adaptee;
//
//    public Adapter(Adaptee adaptee) {
//        this.adaptee = adaptee;
//    }
//
//    @Override
//    public void chargeByBritishStandard() {
//        System.out.println("使用英标转中标转换器");
//        this.adaptee.chargeByChineseStandard();
//    }
//
//}



