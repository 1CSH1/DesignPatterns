package com.liebrother.designpatterns.visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorTest {

    public static void main(String[] args) {
        AlibabaCompany alibabaCompany = new AlibabaCompany();
        TencentCompany tencentCompany = new TencentCompany();
        ProvincialLeaderVistor provincialLeaderVistor = new ProvincialLeaderVistor();
        NationalLeaderVistor nationalLeaderVistor = new NationalLeaderVistor();

        Hotel xilaideng = new Hotel();
        xilaideng.add(alibabaCompany);
        xilaideng.add(tencentCompany);

        xilaideng.entertain(provincialLeaderVistor);
        xilaideng.entertain(nationalLeaderVistor);
    }

}

/**
 * 访问者接口
 */
interface Vistor {
    void visit(AlibabaCompany alibabaCompany);
    void visit(TencentCompany tencentCompany);
}

/**
 * 省领导访问
 */
class ProvincialLeaderVistor implements Vistor {

    @Override
    public void visit(AlibabaCompany alibabaCompany) {
        System.out.println(alibabaCompany.entertainProvincialLeader());
    }

    @Override
    public void visit(TencentCompany tencentCompany) {
        System.out.println(tencentCompany.entertainProvincialLeader());
    }
}

/**
 * 郭嘉领导访问
 */
class NationalLeaderVistor implements Vistor {

    @Override
    public void visit(AlibabaCompany alibabaCompany) {
        System.out.println(alibabaCompany.entertainNationalLeader());
    }

    @Override
    public void visit(TencentCompany tencentCompany) {
        System.out.println(tencentCompany.entertainNationalLeader());
    }
}

/**
 * 企业
 */
abstract class Company {
    public abstract void accept(Vistor vistor);
}

/**
 * Alibaba 企业
 */
class AlibabaCompany extends Company {

    @Override
    public void accept(Vistor vistor) {
        vistor.visit(this);
    }

    public String entertainProvincialLeader() {
        return "Alibaba 接待省领导：十菜一汤";
    }

    public String entertainNationalLeader() {
        return "Alibaba 接待郭嘉领导：十四菜两汤";
    }

}

/**
 * Tencent 企业
 */
class TencentCompany extends Company {

    @Override
    public void accept(Vistor vistor) {
        vistor.visit(this);
    }

    public String entertainProvincialLeader() {
        return "Tencent 接待省领导：八菜一汤";
    }

    public String entertainNationalLeader() {
        return "Tencent 接待郭嘉领导：十六菜两汤";
    }
}

/**
 * 酒店
 */
class Hotel {
    private List<Company> companies = new ArrayList<>();

    public void entertain(Vistor vistor) {
        for (Company company : companies) {
            company.accept(vistor);
        }
    }

    public void add(Company company) {
        companies.add(company);
    }
}
