package com.liebrother.designpatterns.proxy;

import java.util.HashSet;
import java.util.Set;

public class ProxyTest {

    public static void main(String[] args) {
        WorldNetwork worldNetwork = new WorldNetwork();
        ChinnessNetwork chinnessNetwork = new ChinnessNetwork(worldNetwork);
        chinnessNetwork.access("www.google.com");
        chinnessNetwork.access("www.baidu.com");
    }

}

interface Internet {

    String access(String domain);

}

class WorldNetwork implements Internet {

    @Override
    public String access(String domain) {
        System.out.println("访问网站：" + domain);
        return domain + "网站内容";
    }

}

class ChinnessNetwork implements Internet {

    private Set<String> disable;

    private Internet internet;

    public ChinnessNetwork(Internet internet) {
        this.internet = internet;
        this.disable = new HashSet<>();
        this.disable.add("www.google.com");
        this.disable.add("www.facebook.com");
    }

    @Override
    public String access(String domain) {
        if (disable.contains(domain)) {
            System.out.println("禁止访问该网站：" + domain);
            return "禁止访问该网站：" + domain;
        }
        return internet.access(domain);
    }
}

