package com.liebrother.designpatterns.builder;

public class NoBuilderTest {

    public static void main(String[] args) {
        BMWCar bmwCar = new BMWCar();
        // 安装镜子
        bmwCar.installMirror();
        // 安装方向盘
        bmwCar.installSteeringWheel();
        // 安装轮胎
        bmwCar.installWheel();

        MercedesCar mercedesCar = new MercedesCar();
        // 安装轮胎
        mercedesCar.installWheel();
        // 安装方向盘
        mercedesCar.installSteeringWheel();
        // 安装镜子
        mercedesCar.installMirror();
    }

}

/**
 * 汽车
 */
abstract class Car {

    abstract void installWheel();

    abstract void installSteeringWheel();

    abstract void installMirror();

}

/**
 * 宝马汽车
 */
class BMWCar extends Car {

    @Override
    public void installWheel() {
        System.out.println("宝马车安装轮胎");
    }

    @Override
    public void installSteeringWheel() {
        System.out.println("宝马车安装反向盘");
    }

    @Override
    public void installMirror() {
        System.out.println("宝马车安装镜子");
    }
}

/**
 * 奔驰汽车
 */
class MercedesCar extends Car {
    @Override
    public void installWheel() {
        System.out.println("奔驰车安装轮胎");
    }

    @Override
    public void installSteeringWheel() {
        System.out.println("奔驰车安装反向盘");
    }

    @Override
    public void installMirror() {
        System.out.println("奔驰车安装镜子");
    }
}