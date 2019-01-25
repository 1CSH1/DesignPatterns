package com.liebrother.designpatterns.builder;

public class NoBuilderTest {

    public static void main(String[] args) {
        DongGuaPaiGuSoup dongGuaPaiGuSoup = new DongGuaPaiGuSoup();
        // 加排骨
        dongGuaPaiGuSoup.addMeat();
        // 熬制 30 分钟
        dongGuaPaiGuSoup.waitMinute(30);
        // 加冬瓜
        dongGuaPaiGuSoup.addVegetables();
        // 熬制 10 分钟
        dongGuaPaiGuSoup.waitMinute(10);
        // 加盐加香菜
        dongGuaPaiGuSoup.addIngredients();

        BanLiPaiGuSoup banLiPaiGuSoup = new BanLiPaiGuSoup();
        // 加排骨
        banLiPaiGuSoup.addMeat();
        // 加板栗
        banLiPaiGuSoup.addVegetables();
        // 熬制 40 分钟
        banLiPaiGuSoup.waitMinute(40);
        // 加盐
        banLiPaiGuSoup.addIngredients();
    }

}
interface Soup {

    /** 加肉 */
    void addMeat();
    /** 加菜 */
    void addVegetables();
    /** 熬制 */
    void waitMinute(int minute);
    /** 加配料 */
    void addIngredients();

}

class DongGuaPaiGuSoup implements Soup {

    @Override
    public void addMeat() {
        System.out.println("加排骨");
    }

    @Override
    public void addVegetables() {
        System.out.println("加冬瓜");
    }

    @Override
    public void waitMinute(int minute) {
        System.out.println("熬制 " + minute + " 分钟");
    }

    @Override
    public void addIngredients() {
        System.out.println("加盐、加香菜");
    }
}

class BanLiPaiGuSoup implements Soup {

    @Override
    public void addMeat() {
        System.out.println("加排骨");
    }

    @Override
    public void addVegetables() {
        System.out.println("加板栗");
    }

    @Override
    public void waitMinute(int minute) {
        System.out.println("熬制 " + minute + " 分钟");
    }

    @Override
    public void addIngredients() {
        System.out.println("加盐");
    }
}