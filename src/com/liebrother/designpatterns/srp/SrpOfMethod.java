package com.liebrother.designpatterns.srp;

/**
 * @author LieBrother
 * @date 2018/12/26
 */
public class SrpOfMethod {

}


class User {
    private String id;
    private String name;
    private String password;
    private boolean gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}


/**
 * 错误的示范
 */

enum OprType {
    /**
     * 更新密码
     */
    UPDATE_PASSWORD,
    /**
     * 更新名字
     */
    UPDATE_NAME;
}

interface UserOpr {
    boolean updateUserInfo(User user, OprType oprType);
}

class UserOprImpl implements UserOpr {

    @Override
    public boolean updateUserInfo(User user, OprType oprType) {
        if (oprType == OprType.UPDATE_NAME) {
            // update name
        } else if (oprType == OprType.UPDATE_PASSWORD) {
            // update password
        }
        return true;
    }
}

// 通过 OprType 类型的不同来做不同的事情，把更新密码和更新名字耦合在一起，容易引起问题，只要稍不注意，传错枚举值就悲剧了，在代码中也没法很直接看到是做什么操作

/**
 * 正确的示范
 */

interface UserOpr2 {
    boolean updatePassword(User user, String password);
    boolean updateUserInfo(User user);
}

class UserOprImpl2 implements UserOpr2 {

    @Override
    public boolean updatePassword(User user, String password) {
        user.setPassword(password);
        // update password
        return true;
    }

    @Override
    public boolean updateUserInfo(User user) {
        // update user info
        return true;
    }
}

// 把更新密码和更新用户信息分开，这样子看到代码就很明显，这是在更新密码还是更新用户的其他信息。
