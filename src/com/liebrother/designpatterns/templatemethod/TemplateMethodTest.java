package com.liebrother.designpatterns.templatemethod;

public class TemplateMethodTest {

    public static void main(String[] args) {
        ShoeInstallTemplate adidasBoost = new AdidasBoostShoeInstall();
        adidasBoost.installShot();

        ShoeInstallTemplate nikeJordan = new NikeJordanShoeInstall();
        nikeJordan.installShot();
    }

}

/**
 * 定义鞋子制造的工序框架
 */
abstract class ShoeInstallTemplate {

    public abstract void installSole();
    public abstract void installInsole();
    public abstract void installVamp();
    public abstract void installShoelace();

    public void installShot(){
        System.out.println("组装一双鞋，步骤如下：");
        // 组装鞋底
        installSole();
        // 组装鞋垫
        installInsole();
        // 组装鞋面
        installVamp();
        // 组装鞋带
        installShoelace();
    }

}

/**
 * Adidas Boost 鞋制造
 */
class AdidasBoostShoeInstall extends ShoeInstallTemplate {
    @Override
    public void installSole() {
        System.out.println("组装白色 Boost 鞋底");
    }

    @Override
    public void installInsole() {
        System.out.println("组装黑色 Boost 鞋垫");
    }

    @Override
    public void installVamp() {
        System.out.println("组装黑色 Boost 鞋面");
    }

    @Override
    public void installShoelace() {
        System.out.println("组装黑色 Boost 鞋带");
    }
}

/**
 * Nike Jordan 鞋制造
 */
class NikeJordanShoeInstall extends ShoeInstallTemplate {

    @Override
    public void installSole() {
        System.out.println("组装黑色 Jordan 鞋底");
    }

    @Override
    public void installInsole() {
        System.out.println("组装黑色 Jordan 鞋垫");
    }

    @Override
    public void installVamp() {
        System.out.println("组装红色 Jordan 鞋面");
    }

    @Override
    public void installShoelace() {
        System.out.println("组装红色 Jordan 鞋带");
    }
}