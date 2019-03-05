package com.liebrother.designpatterns.observer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author James
 * @date 2019/2/27
 */
public class ObserverTest {

    public static void main(String[] args) {
        User user = new User("小明");
        Friend friend1 = new Friend("小红");
        Friend friend2 = new Friend("小东");
        user.addObserver(friend1);
        user.addObserver(friend2);
        user.sendMessage("今天真开心");
        user.removeObserver(friend1);
        user.sendMessage("希望明天也像今天一样开心");

        User2 user2 = new User2("小明");
        User2 xiaoHong = new User2("小红");
        User2 xiaoDong = new User2("小东");

        user2.addObserver(xiaoHong);
        user2.addObserver(xiaoDong);

        user2.sendMessage("今天真开心");
    }

}



interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

interface Observer {
    void update(String name, String message);
}

class User implements Observable {

    private List<Observer> friends;
    private String name;

    public User(String name) {
        this.name = name;
        this.friends = new LinkedList<>();
    }

    public void sendMessage(String message) {
        this.notifyObservers(message);
    }

    @Override
    public void addObserver(Observer observer) {
        this.friends.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.friends.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        this.friends.forEach(friend -> {
            friend.update(this.name, message);
        });
    }
}

class Friend implements Observer {

    private String name;

    public Friend(String name) {
        this.name = name;
    }
    @Override
    public void update(String name, String message) {
        System.out.println("【" + this.name + "】看到【" + name + "】发的朋友圈：" + message);
    }
}


class User2 implements Observable, Observer {

    private List<Observer> friends;
    private String name;

    public User2(String name) {
        this.name = name;
        this.friends = new LinkedList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        this.friends.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.friends.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        this.friends.forEach(friend -> {
            friend.update(this.name, message);
        });
    }

    @Override
    public void update(String name, String message) {
        System.out.println("【" + this.name + "】看到【" + name + "】发的朋友圈：" + message);
    }

    public void sendMessage(String message) {
        this.notifyObservers(message);
    }
}