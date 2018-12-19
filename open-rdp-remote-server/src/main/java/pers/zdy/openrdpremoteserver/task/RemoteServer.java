package pers.zdy.openrdpremoteserver.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import pers.zdy.openrdpremoteserver.service.ServerStartService;


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
    ServerStartService serverStartService;


    /**
     * 服务启动
     * service start
     * */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        serverStartService.start();
    }

}
