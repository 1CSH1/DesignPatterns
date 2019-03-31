package com.liebrother.designpatterns.memento;

/**
 * @author James
 * @date 2019/3/12
 */
public class MementoTest {

    public static void main(String[] args) {
        Deployer deployer = new Deployer();
        deployer.setApp(new App("apply-system", "1.0.0"));

        System.out.println("1. 暂停旧应用");
        deployer.stopApp();

        System.out.println("2. 备份旧应用");
        Space space = new Space();
        space.setAppBackup(deployer.createAppBackup());

        System.out.println("3. 拷贝新应用到服务器");
        deployer.setApp(new App("apply-system", "2.0.0"));
        deployer.showApp();

        System.out.println("4. 启动新应用");
        deployer.startApp();

        System.out.println("5. 有异常，暂停新应用");
        deployer.stopApp();

        System.out.println("6. 回滚旧应用，拷贝备份的旧应用到服务器");
        deployer.setAppBackup(space.getAppBackup());
        deployer.showApp();

        System.out.println("7. 启动备份的旧应用");
        deployer.startApp();
    }

}


/**
 * 应用实例
 */
class App {
    private String content;
    private String version;

    public App(String content, String version) {
        this.content = content;
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "App{" +
                "content='" + content + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}

/**
 * 应用备份（充当备忘录角色）
 */
class AppBackup {

    private App app;

    public AppBackup(App app) {
        this.app = app;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }
}

/**
 * 备份空间
 */
class Space {
    private AppBackup appBackup;

    public AppBackup getAppBackup() {
        return appBackup;
    }

    public void setAppBackup(AppBackup appBackup) {
        this.appBackup = appBackup;
    }
}

/**
 * 部署应用的同学
 */
class Deployer {

    // 要部署的应用
    private App app;

    public App getApp() {
        return app;
    }

    // 设置部署应用
    public void setApp(App app) {
        this.app = app;
    }

    // 创建应用的备份
    public AppBackup createAppBackup() {
        return new AppBackup(app);
    }

    // 从备忘录恢复应用
    public void setAppBackup(AppBackup appBackup) {
        this.app = appBackup.getApp();
    }

    // 显示应用的信息
    public void showApp() {
        System.out.println(this.app.toString());
    }

    // 暂停应用
    public void stopApp() {
        System.out.println("暂停应用：" + this.app.toString());
    }

    // 启动应用
    public void startApp() {
        System.out.println("启动应用：" + this.app.toString());
    }

}

