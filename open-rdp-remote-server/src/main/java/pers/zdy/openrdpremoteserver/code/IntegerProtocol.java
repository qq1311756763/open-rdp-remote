package pers.zdy.openrdpremoteserver.code;

import org.smartboot.socket.Protocol;
import org.smartboot.socket.transport.AioSession;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 *协议编解码
 *@author :zdy
 *@date :2018/11/30
 */
public class IntegerProtocol implements Protocol<Integer> {

    /**
    * 数据长度
    * */
    private static final int INT_LENGTH = 4;

    @Override
    public Integer decode(ByteBuffer byteBuffer, AioSession<Integer> aioSession) {
        Charset charset = Charset.forName("utf-8");


        if (byteBuffer.remaining() < INT_LENGTH){
            return null;
        }
        return byteBuffer.getInt();
    }

    @Override
    public ByteBuffer encode(Integer s, AioSession<Integer> session) {
        ByteBuffer b = ByteBuffer.allocate(INT_LENGTH);
        b.putInt(s);
        b.flip();
        return b;
    }

}
