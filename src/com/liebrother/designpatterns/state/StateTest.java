package com.liebrother.designpatterns.state;

/**
 * @author James
 * @date 2019/3/6
 */
public class StateTest {
/*
    public static void main(String[] args) {
        Context context = new Context();
        State state = new AState();
        context.setState(state);
        context.request();
    }
*/
    public static void main(String[] args) {
        User user = new User();
        user.setState(new RegisterState());
        user.apply();
        user.draw(1000);

        User1 user1 = new User1();
        user1.setState("register");
        user1.draw(1000);
    }

}


class User1 {
    /**
     * register
     * apply
     * draw
     */
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void apply() {
        if ("register".equals(state)) {
            System.out.println("注册用户，授信申请成功。");
        } else if ("apply".equals(state)) {
            System.out.println("授信用户，不需要再授信。");
        } else if ("draw".equals(state)) {
            System.out.println("借款用户，不需要再授信。");
        }
    }

    public void draw(double money) {
        if ("register".equals(state)) {
            System.out.println("注册用户，还没授信，不能借款。");
        } else if ("apply".equals(state)) {
            System.out.println("授信用户，借款申请成功。");
        } else if ("draw".equals(state)) {
            System.out.println("借款用户，可以再次借款，借款申请成功。");
        }
    }
}



interface State {

    void register();

    void apply();

    void draw();
}

class RegisterState implements State {

    @Override
    public void register() {
        System.out.println("已经注册，不需要注册了");
    }

    @Override
    public void apply() {
        System.out.println("申请授信中。。。");
    }

    @Override
    public void draw() {
        System.out.println("还没授信，不能借款");
    }
}

class ApplyState implements State {

    @Override
    public void register() {
        System.out.println("已经注册，不需要注册了");
    }

    @Override
    public void apply() {
        System.out.println("已经授信过，不需要再授信");
    }

    @Override
    public void draw() {
        System.out.println("申请借款中。。。");
    }
}

class DrawState implements State {

    @Override
    public void register() {
        System.out.println("已经注册，不需要注册了");
    }

    @Override
    public void apply() {
        System.out.println("已经授信过，不需要再授信");
    }

    @Override
    public void draw() {
        System.out.println("申请借款中。。。");
    }
}

class User {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void apply() {
        this.state.apply();
    }

    public void draw(double money) {
        this.state.draw();
    }
}

/**
 * 注册
 * 绑卡
 * 授信
 * 借款
 */
/*
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
*/