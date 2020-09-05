package test;

import java.io.Serializable;

/**
 * @program: User
 * @description:
 * @author: wangf-q
 * @date: 2020-01-14 15:58
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 2L;

    private String userId;
    private String userName;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
