package com.liebrother.designpatterns.strategy;

/**
 * @author James
 * @date 2019/2/21
 */
public class StrategyTest {

    public static void main(String[] args) {
        Strategy strategy = new AStrategy();
        Context context = new Context(strategy);
        context.doSomething();
    }

}


interface Strategy {

    void method();

}

class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doSomething() {
        this.strategy.method();
    }
}

class AStrategy implements Strategy {

    @Override
    public void method() {
        System.out.println("策略A");
    }
}

class BStrategy implements Strategy {

    @Override
    public void method() {
        System.out.println("策略B");
    }
}