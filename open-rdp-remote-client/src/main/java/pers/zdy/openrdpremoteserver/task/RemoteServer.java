package pers.zdy.openrdpremoteserver.task;

import cn.hutool.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import pers.zdy.openrdpremoteserver.service.Port2PortService;
import pers.zdy.openrdpremoteserver.share.PublicVariable;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务启动类
 * @author :zdy
 * @date :2018/12/5
 * */
public class RemoteServer implements ApplicationRunner, Ordered {

    /**
    * 定义自启动顺序
    * boot order
    * */
    @Override
    public int getOrder() {
        return 0;
    }

    @Autowired
    Port2PortService port2PortService;


    /**
     * 服务启动
     * service start
     * */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        LogFactory.get().info("task runner");

        ServerSocket serverSocket=new ServerSocket(8888);
        while (true) {
            PublicVariable.clientSocket = serverSocket.accept();
            PublicVariable.targetSocket=new Socket("172.30.200.50",3389);
            port2PortService.socket2socket(PublicVariable.targetSocket,PublicVariable.clientSocket,"targetSocket to clientSocket");
            port2PortService.socket2socket(PublicVariable.clientSocket,PublicVariable.targetSocket,"clientSocket to targetSocket");
            //port2PortService.sendTarget(PublicVariable.targetSocket,PublicVariable.clientSocket);
        }
        //port2PortService.server();
    }



}
