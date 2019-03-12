package com.liebrother.designpatterns.state;

public class NoStateTest {

    public static void main(String[] args) {
        User user = new User();
        user.setState("register");
        user.draw(1000);
    }

}

class User {
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