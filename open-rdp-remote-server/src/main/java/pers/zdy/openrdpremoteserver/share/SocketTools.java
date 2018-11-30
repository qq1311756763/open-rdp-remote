package pers.zdy.openrdpremoteserver.share;

import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioSession;

import java.io.IOException;

/**
 * socket 工具类
 * socket class tools
 *
 * @author :zdy
 * @data :2018/11
 * */
public class SocketTools implements MessageProcessor<Integer> {

    @Override
    public void process(AioSession<Integer> session, Integer msg) {
        Integer respMsg = msg + 1;
        System.out.println("接受到客户端数据：" + msg + " ,响应数据:" + (respMsg));
        try {
            session.write(respMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stateEvent(AioSession<Integer> session, StateMachineEnum stateMachineEnum, Throwable throwable) {

    }

}
