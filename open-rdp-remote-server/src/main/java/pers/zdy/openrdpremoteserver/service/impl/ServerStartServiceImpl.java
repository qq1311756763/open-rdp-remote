package pers.zdy.openrdpremoteserver.service.impl;

import cn.hutool.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pers.zdy.openrdpremoteserver.service.Port2PortService;
import pers.zdy.openrdpremoteserver.service.ServerStartService;
import pers.zdy.openrdpremoteserver.share.PublicVariable;

import java.net.ServerSocket;
import java.net.Socket;

@Service
public class ServerStartServiceImpl implements ServerStartService {

    @Autowired
    Port2PortService port2PortService;

    @Override
    @Async("asyncServiceExecutor")
    public void start() throws Exception{
        LogFactory.get().info("task runner");

        ServerSocket serverSocket=new ServerSocket(8888);
        while (true) {
            PublicVariable.clientSocket = serverSocket.accept();
            PublicVariable.targetSocket=new Socket("172.30.200.50",3389);
            port2PortService.socket2socket(PublicVariable.targetSocket,PublicVariable.clientSocket,"targetSocket to clientSocket");
            port2PortService.socket2socket(PublicVariable.clientSocket, PublicVariable.targetSocket,"clientSocket to targetSocket");
            //port2PortService.sendTarget(PublicVariable.targetSocket,PublicVariable.clientSocket);
        }
    }
}
