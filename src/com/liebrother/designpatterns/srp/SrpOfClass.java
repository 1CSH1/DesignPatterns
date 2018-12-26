package com.liebrother.designpatterns.srp;

/**
 * @author LieBrother
 * @date 2018/12/26
 */
public class SrpOfClass {
}

// 类实现单一职责这个需要看情况分析，比如用户的注册、登录、注销操作，从用户的角度，这些操作都是用户的行为，所以放在一个统一的类，UserBiz 如下所示

class UserBiz {

    public boolean register(User user){
        // 注册操作
        return true;
    }

    public boolean login(User user) {
        // 登录操作
        return true;
    }

    public boolean logout(User user) {
        // 注销操作
        return true;
    }

}

// 有人又说，不是说单一职责么？从业务操作考虑，需要把注册、登录、注销分开，如下所示

class UserRegisterBiz {

    public boolean register(User user){
        // 注册操作
        return true;
    }

}

class UserLoginBiz {

    public boolean login(User user) {
        // 登录操作
        return true;
    }

}

class UserLogoutBiz {

    public boolean logout(User user) {
        // 注销操作
        return true;
    }

}

// 感觉像是在抬杠，其实这个没有好坏之分，需要根据具体业务具体分析，在接口中按照单一职责原则可以防止因为修改部分接口，导致其它不相关的类需要修改，但是在类中并没有看到这个效果。