package com.liebrother.designpatterns.builder;

public class BuilderTest {

    public static void main(String[] args) {
        Director director = new Director();
        director.buildBMWCar();
        director.buildMercedesCar();
    }

}

/**
 * 汽车建造者
 */
interface CarBuilder {

    void buildCar();

    Car getCar();

}

/**
 * 宝马汽车建造者
 */
class BMWCarBuilder implements CarBuilder {

    private BMWCar car = new BMWCar();

    @Override
    public void buildCar() {
        // 安装镜子
        car.installMirror();
        // 安装方向盘
        car.installSteeringWheel();
        // 安装轮胎
        car.installWheel();
    }

    @Override
    public Car getCar() {
        return car;
    }
}

/**
 * 奔驰汽车建造者
 */
class MercedesCarBuilder implements CarBuilder {

    private MercedesCar car = new MercedesCar();

    @Override
    public void buildCar() {
        // 安装轮胎
        car.installWheel();
        // 安装方向盘
        car.installSteeringWheel();
        // 安装镜子
        car.installMirror();
    }

    @Override
    public Car getCar() {
        return car;
    }
}

/**
 * 生产方
 */
class Director {
    private BMWCarBuilder bmwCarBuilder = new BMWCarBuilder();
    private MercedesCarBuilder mercedesCarBuilder = new MercedesCarBuilder();

    /**
     * 生产宝马
     */
    public BMWCar buildBMWCar() {
        bmwCarBuilder.buildCar();
        return (BMWCar) bmwCarBuilder.getCar();
    }

    /**
     * 生产奔驰
     */
    public MercedesCar buildMercedesCar() {
        mercedesCarBuilder.buildCar();   //
        return (MercedesCar) mercedesCarBuilder.getCar();
    }

}