package com.liebrother.designpatterns.state;

/**
 * @author James
 * @date 2019/3/6
 */
public class StateTest {

    public static void main(String[] args) {
        Context context = new Context();
        State state = new AState();
        context.setState(state);
        context.request();
    }

}

interface State {

    void handle();

}

class AState implements State {

    @Override
    public void handle() {
        System.out.println("AState");
    }

}

class BState implements State {

    @Override
    public void handle() {
        System.out.println("BState");
    }
}

class Context {

    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        this.state.handle();
    }
}
