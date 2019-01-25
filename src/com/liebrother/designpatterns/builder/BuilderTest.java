package com.liebrother.designpatterns.builder;

public class BuilderTest {

    public static void main(String[] args) {
        Director director = new Director();
        director.buildDongGuaPaiGuSoup();
        director.buildBanLiPaiGuSoup();
    }

}

interface SoupBuilder {
    void buildSoup();
    Soup getSoup();
}

/**
 * 冬瓜排骨汤建造者
 */
class DongGuaPaiGuSoupBuilder implements SoupBuilder {

    private DongGuaPaiGuSoup dongGuaPaiGuSoup = new DongGuaPaiGuSoup();

    @Override
    public void buildSoup() {
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
    }

    @Override
    public Soup getSoup() {
        return dongGuaPaiGuSoup;
    }
}

/**
 * 板栗排骨汤建造者
 */
class BanLiPaiGuSoupBuilder implements SoupBuilder {

    BanLiPaiGuSoup banLiPaiGuSoup = new BanLiPaiGuSoup();

    @Override
    public void buildSoup() {
        // 加排骨
        banLiPaiGuSoup.addMeat();
        // 加板栗
        banLiPaiGuSoup.addVegetables();
        // 熬制 40 分钟
        banLiPaiGuSoup.waitMinute(40);
        // 加盐
        banLiPaiGuSoup.addIngredients();
    }

    @Override
    public Soup getSoup() {
        return banLiPaiGuSoup;
    }
}

/**
 * 生产方
 */
class Director {
    private DongGuaPaiGuSoupBuilder dongGuaPaiGuSoupBuilder = new DongGuaPaiGuSoupBuilder();
    private BanLiPaiGuSoupBuilder banLiPaiGuSoupBuilder = new BanLiPaiGuSoupBuilder();

    /**
     * 熬制冬瓜排骨汤
     */
    public DongGuaPaiGuSoup buildDongGuaPaiGuSoup() {
        dongGuaPaiGuSoupBuilder.buildSoup();
        return (DongGuaPaiGuSoup) dongGuaPaiGuSoupBuilder.getSoup();
    }

    /**
     * 熬制板栗排骨汤
     */
    public BanLiPaiGuSoup buildBanLiPaiGuSoup() {
        banLiPaiGuSoupBuilder.buildSoup();
        return (BanLiPaiGuSoup) banLiPaiGuSoupBuilder.getSoup();
    }

}