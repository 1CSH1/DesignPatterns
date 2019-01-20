package com.liebrother.designpatterns.abstractfactory;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        // 宝马员工安装轮胎和方向盘
        AbstractCarFactory bmwCarFacatory = new BMWCarFactory();
        bmwCarFacatory.installWheel();
        bmwCarFacatory.installSteeringWheel();

        // 奔驰员工安装轮胎和方向盘
        AbstractCarFactory mercedesCarFacatory = new MercedesCarFacatory();
        mercedesCarFacatory.installWheel();
        mercedesCarFacatory.installSteeringWheel();
    }

}

/**
 * 汽车抽象工厂
 */
interface AbstractCarFactory {

    void installWheel();

    void installSteeringWheel();

}

/**
 * 宝马工厂
 */
class BMWCarFactory implements AbstractCarFactory {

    @Override
    public void installWheel() {
        WheelFacatory wheelFacatory = new BMWWheelFacatory();
        String wheel = wheelFacatory.createWheel();
        System.out.println("安装轮胎：" + wheel);
    }

    @Override
    public void installSteeringWheel() {
        SteeringWheelFacatory steeringWheelFacatory = new BMWSteeringWheelFacatory();
        String steeringWheel = steeringWheelFacatory.createSteeringWheel();
        System.out.println("安装方向盘：" + steeringWheel);
    }
}

/**
 * 奔驰工厂
 */
class MercedesCarFacatory implements AbstractCarFactory {

    @Override
    public void installWheel() {
        WheelFacatory wheelFacatory = new MercedesWheelFacatory();
        String wheel = wheelFacatory.createWheel();
        System.out.println("安装轮胎：" + wheel);
    }

    @Override
    public void installSteeringWheel() {
        SteeringWheelFacatory steeringWheelFacatory = new MercedesSteeringWheelFacatory();
        String steeringWheel = steeringWheelFacatory.createSteeringWheel();
        System.out.println("安装方向盘：" + steeringWheel);
    }
}

/**
 * 轮胎工厂
 */
interface WheelFacatory {

    String createWheel();

}

/**
 * 宝马轮胎工厂
 */
class BMWWheelFacatory implements WheelFacatory {

    @Override
    public String createWheel() {
        System.out.println("宝马轮胎工厂生产轮胎");
        return "宝马轮胎";
    }
}

/**
 * 奔驰轮胎工厂
 */
class MercedesWheelFacatory implements WheelFacatory {

    @Override
    public String createWheel() {
        System.out.println("奔驰轮胎工厂生产轮胎");
        return "奔驰轮胎";
    }
}

/**
 * 方向盘工厂
 */
interface SteeringWheelFacatory {

    String createSteeringWheel();

}

/**
 * 宝马方向盘工厂
 */
class BMWSteeringWheelFacatory implements SteeringWheelFacatory {

    @Override
    public String createSteeringWheel() {
        System.out.println("宝马方向盘工厂生产方向盘");
        return "宝马方向盘";
    }
}

/**
 * 奔驰方向盘工厂
 */
class MercedesSteeringWheelFacatory implements SteeringWheelFacatory {

    @Override
    public String createSteeringWheel() {
        System.out.println("奔驰方向盘工厂生产方向盘");
        return "奔驰方向盘";
    }
}