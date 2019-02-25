package com.liebrother.designpatterns.strategy;

/**
 * @author James
 * @date 2019/2/21
 */
public class StrategyTest {

    public static void main(String[] args) {
        WashingStrategy washingStrategy = new StandardWashingStrategy();
        WashingMachine washingMachine = new WashingMachine(washingStrategy);
        washingMachine.washingClothes();

        WashingStrategy washingStrategy2 = WashingFactory.getWashingStrategy("Soft");
        WashingMachine washingMachine2 = new WashingMachine(washingStrategy2);
        washingMachine2.washingClothes();
    }
}

/**
 * 洗衣类型
 */
interface WashingStrategy {
    void washing();
}

/**
 * 洗衣机
 */
class WashingMachine {
    private WashingStrategy washingStrategy;

    public WashingMachine(WashingStrategy washingStrategy) {
        this.washingStrategy = washingStrategy;
    }

    public void washingClothes() {
        this.washingStrategy.washing();
    }
}

/**
 * 标准
 */
class StandardWashingStrategy implements WashingStrategy{

    @Override
    public void washing() {
        System.out.println("标准流程：");
        System.out.println("[浸泡] 10 分钟");
        System.out.println("[洗涤] 2 次，每次 15 分钟");
        System.out.println("[漂洗] 1 次，每次 10 分钟");
        System.out.println("[脱水] 5 分钟");
        System.out.println("总共耗时：55 分钟");
    }
}

/**
 * 快洗
 */
class QuickWashingStrategy implements WashingStrategy {

    @Override
    public void washing() {
        System.out.println("快洗流程：");
        System.out.println("[洗涤] 1 次，每次 10 分钟");
        System.out.println("[漂洗] 1 次，每次 10 分钟");
        System.out.println("[脱水] 5 分钟");
        System.out.println("总共耗时：25 分钟");
    }
}

/**
 * 大物
 */
class BigClothesWashingStrategy implements WashingStrategy {

    @Override
    public void washing() {
        System.out.println("大物流程：");
        System.out.println("[浸泡] 30 分钟");
        System.out.println("[洗涤] 3 次，每次 15 分钟");
        System.out.println("[漂洗] 2 次，每次 10 分钟");
        System.out.println("[脱水] 5 分钟");
        System.out.println("总共耗时：100 分钟");
    }
}

/**
 * 轻柔
 */
class SoftWashingStrategy implements WashingStrategy {

    @Override
    public void washing() {
        System.out.println("轻柔流程：");
        System.out.println("[浸泡] 10 分钟");
        System.out.println("[漂洗] 2 次，每次 15 分钟");
        System.out.println("[脱水] 5 分钟");
        System.out.println("总共耗时：45 分钟");
    }
}

/**
 * 洗衣类型选择
 */
class WashingFactory {

    public static WashingStrategy getWashingStrategy(String type) {
        if ("Quick".equals(type)) {
            return new QuickWashingStrategy();
        }
        if ("BigClothes".equals(type)) {
            return new BigClothesWashingStrategy();
        }
        if ("Soft".equals(type)) {
            return new SoftWashingStrategy();
        }
        return new StandardWashingStrategy();
    }
}
/*
标准 快洗 大物 轻柔
浸泡 洗涤 漂洗 脱水
*/
