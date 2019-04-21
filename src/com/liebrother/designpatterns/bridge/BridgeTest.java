package com.liebrother.designpatterns.bridge;

import com.liebrother.designpatterns.srp.SrcOfInterface;

public class BridgeTest {

    public static void main(String[] args) {
        Software chrome = new Chrome();
        Software firefox = new FireFox();

        Phone androidPhone = new AndroidPhone(chrome);
        androidPhone.openSoftware();

        androidPhone.setSoftware(firefox);
        androidPhone.openSoftware();

        Phone iosPhone = new IOSPhone(chrome);
        iosPhone.openSoftware();

        iosPhone.setSoftware(firefox);
        iosPhone.openSoftware();
    }

}

abstract class Phone {

    private String system;
    private Software software;

    public abstract void openSoftware();

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

}

class AndroidPhone extends Phone {

    public AndroidPhone(Software software){
        this.setSystem("Android");
        this.setSoftware(software);
    }

    @Override
    public void openSoftware() {
        this.getSoftware().open(this);
    }
}

class IOSPhone extends Phone {

    public IOSPhone(Software software) {
        this.setSystem("IOS");
        this.setSoftware(software);
    }

    @Override
    public void openSoftware() {
        this.getSoftware().open(this);
    }
}

interface Software {
    void open(Phone phone);
}

class Chrome implements Software {

    @Override
    public void open(Phone phone) {
        System.out.println("打开 " + phone.getSystem() + " 手机的 Chrome 浏览器");
    }

}

class FireFox implements Software {

    @Override
    public void open(Phone phone) {
        System.out.println("打开 " + phone.getSystem() + " 手机的 Firefox 浏览器");
    }
}
