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
     * none
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

    public void register() {
        if ("none".equals(state)) {
            System.out.println("游客。注册中。。。");
        }else if ("register".equals(state)) {
            System.out.println("注册用户。不需要再注册。");
        } else if ("apply".equals(state)) {
            System.out.println("授信用户。不需要再注册。");
        } else if ("draw".equals(state)) {
            System.out.println("借款用户。不需要再注册。");
        }
    }

    public void apply() {
        if ("none".equals(state)) {
            System.out.println("游客。不能申请授信。");
        }else if ("register".equals(state)) {
            System.out.println("注册用户。授信申请中。。。");
        } else if ("apply".equals(state)) {
            System.out.println("授信用户。不需要再授信。");
        } else if ("draw".equals(state)) {
            System.out.println("借款用户。不需要再授信。");
        }
    }

    public void draw(double money) {
        if ("none".equals(state)) {
            System.out.println("游客。申请借款【" + money + "】元。不能申请借款。");
        } else if ("register".equals(state)) {
            System.out.println("注册用户。申请借款【" + money + "】元。还没授信，不能借款。");
        } else if ("apply".equals(state)) {
            System.out.println("授信用户。申请借款【" + money + "】元。申请借款中。。。");
        } else if ("draw".equals(state)) {
            System.out.println("授信用户。申请借款【" + money + "】元。申请借款中。。。");
        }
    }
}

interface State {

    void register();

    void apply();

    void draw(double money);
}

class NoneState implements State {

    @Override
    public void register() {
        System.out.println("游客。注册中。。。");
    }

    @Override
    public void apply() {
        System.out.println("游客。不能申请授信。");
    }

    @Override
    public void draw(double money) {
        System.out.println("游客。申请借款【" + money + "】元。不能申请借款。");
    }
}

class RegisterState implements State {

    @Override
    public void register() {
        System.out.println("注册用户。不需要再注册。");
    }

    @Override
    public void apply() {
        System.out.println("注册用户。授信申请中。。。");
    }

    @Override
    public void draw(double money) {
        System.out.println("注册用户。申请借款【" + money + "】元。还没授信，不能借款。");
    }
}

class ApplyState implements State {

    @Override
    public void register() {
        System.out.println("授信用户。不需要再注册。");
    }

    @Override
    public void apply() {
        System.out.println("授信用户。不需要再授信。");
    }

    @Override
    public void draw(double money) {
        System.out.println("授信用户。申请借款【" + money + "】元。申请借款中。。。");
    }
}

class DrawState implements State {

    @Override
    public void register() {
        System.out.println("借款用户。不需要再注册。");
    }

    @Override
    public void apply() {
        System.out.println("借款用户。不需要再授信。");
    }

    @Override
    public void draw(double money) {
        System.out.println("申请借款【" + money + "】元。申请借款中。。。");
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
        this.state.draw(money);
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