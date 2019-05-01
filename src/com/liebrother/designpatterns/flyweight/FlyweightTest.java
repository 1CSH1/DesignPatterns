package com.liebrother.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 * @date 2019/5/1
 */
public class FlyweightTest {

    public static void main(String[] args) {
        // 画熊猫
        ICrayon whiteCrayon = new Crayon("白色");
        whiteCrayon.draw();

        ICrayon blackCrayon = new Crayon("黑色");
        blackCrayon.draw();
        
    }

}

interface ICrayon {

    void draw();

}

class Crayon implements ICrayon {

    private String color;

    public Crayon(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("用" + this.color + "蜡笔画");
    }
}

class CrayonFactory {

    private Map<String, ICrayon> data = new HashMap<>();

    public ICrayon getCrayon(String color) {
        if (data.containsKey(color)) {
            return data.get(color);
        }
        ICrayon crayon = new Crayon(color);
        data.put(color, crayon);
        return crayon;
    }

}

