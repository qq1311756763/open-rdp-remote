package pers.zdy.openrdpremoteserver.domain.pojo;

public class UserMassage {
    String usr;
    String pwd;
    String inherit;
    String ip;
    String port;
    String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String user) {
        this.usr = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getInherit() {
        return inherit;
    }

    public void setInherit(String inherit) {
        this.inherit = inherit;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
