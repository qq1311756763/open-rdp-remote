package pers.zdy.openrdpremoteserver.task;

import cn.hutool.log.LogFactory;
import org.smartboot.socket.transport.AioQuickServer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import pers.zdy.openrdpremoteserver.code.IntegerProtocol;
import pers.zdy.openrdpremoteserver.share.SocketTools;

public class RemoteServer implements ApplicationRunner, Ordered {

    /**
    * 定义自启动顺序
    * boot order
    * */
    @Override
    public int getOrder() {
        return 0;
    }




    /**
     * 服务启动
     * service start
     * */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        LogFactory.get().info("task runner");
        AioQuickServer<Integer> server = new AioQuickServer<Integer>(8888, new IntegerProtocol(), new SocketTools());
        server.start();
    }
}
