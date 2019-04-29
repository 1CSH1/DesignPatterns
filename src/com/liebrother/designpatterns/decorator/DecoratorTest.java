package com.liebrother.designpatterns.decorator;

public class DecoratorTest {

    public static void main(String[] args) {
        CommonHerbalJelly commonHerbalJelly = new CommonHerbalJelly();
        HoneyHerbalJelly honeyHerbalJelly = new HoneyHerbalJelly(commonHerbalJelly);
        // 小明的蜂蜜龟苓膏
        honeyHerbalJelly.process();

        MilkHerbalJelly milkHerbalJelly = new MilkHerbalJelly(honeyHerbalJelly);
        // 小红的蜂蜜牛奶龟苓膏
        milkHerbalJelly.process();
    }

}

/**
 * 龟苓膏
 */
abstract class HerbalJelly {

    /**
     * 制作龟苓膏方法
     */
    public abstract void process();

}

/**
 * 普通龟苓膏
 */
class CommonHerbalJelly extends HerbalJelly {

    @Override
    public void process() {
        System.out.println("盛一碗龟苓膏");
    }

}

/**
 * 龟苓膏装饰器
 */
abstract class Decorator extends HerbalJelly {

    private HerbalJelly herbalJelly;

    public Decorator(HerbalJelly herbalJelly) {
        this.herbalJelly = herbalJelly;
    }

    @Override
    public void process() {
        this.herbalJelly.process();
    }
}

/**
 * 蜂蜜龟苓膏
 */
class HoneyHerbalJelly extends Decorator{

    public HoneyHerbalJelly(HerbalJelly herbalJelly) {
        super(herbalJelly);
    }

    @Override
    public void process() {
        super.process();
        System.out.println("加蜂蜜");
    }
}

/**
 * 牛奶龟苓膏
 */
class MilkHerbalJelly extends Decorator{

    public MilkHerbalJelly(HerbalJelly herbalJelly) {
        super(herbalJelly);
    }

    @Override
    public void process() {
        super.process();
        System.out.println("加牛奶");
    }
}