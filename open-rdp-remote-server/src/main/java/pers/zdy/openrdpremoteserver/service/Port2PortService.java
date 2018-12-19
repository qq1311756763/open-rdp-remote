package pers.zdy.openrdpremoteserver.service;


import java.net.Socket;

public interface Port2PortService  {


    public void test();
    public void server();
    public void socket2socket(Socket targetSocket, Socket clientSocket,String type);

}
