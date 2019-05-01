package com.liebrother.designpatterns.facade;

public class FacadeTest {

    public static void main(String[] args) {
        Demander demander = new Demander();
        demander.demand("开发一个跟淘宝一样的系统");

        Demander2 demander2 = new Demander2();
        demander2.demand("开发一个跟微信一样的系统");
    }
}

/**
 * 需求方
 */
class Demander {

    private Developer developer = new Developer();
    private Tester tester = new Tester();

    public void demand(String name) {
        System.out.println("提需求：" + name);
        developer.develop(name);
        tester.test(name);
    }

}


/**
 * 需求方
 */
class Demander2 {

    public Leader leader = new Leader();
    public void demand(String name) {
        System.out.println("提需求：" + name);
        leader.processDemand(name);
    }

}

/**
 * 开发同学
 */
class Developer {

    public void develop(String name) {
        System.out.println("开发需求：" + name);
    }

}

/**
 * 测试同学
 */
class Tester {

    public void test(String name) {
        System.out.println("测试需求：" + name);
    }

}

/**
 * 技术组长
 */
class Leader {

    private Developer developer = new Developer();
    private Tester tester = new Tester();

    public void processDemand(String name) {
        developer.develop(name);
        tester.test(name);
    }

}