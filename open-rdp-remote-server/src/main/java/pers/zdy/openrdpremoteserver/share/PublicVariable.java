package pers.zdy.openrdpremoteserver.share;

import java.net.Socket;

public class PublicVariable {
    public static Socket targetSocket = null;
    public static Socket clientSocket = null;

    public static final String loginSuccess = "success";
    public static final String userDoesNotExist= "用户不存在！";
    public static final String userPwdError= "用户密码错误！";
}
