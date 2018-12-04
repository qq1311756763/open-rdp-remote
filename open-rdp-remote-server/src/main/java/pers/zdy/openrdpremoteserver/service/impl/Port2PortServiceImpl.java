package pers.zdy.openrdpremoteserver.service.impl;

import cn.hutool.log.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pers.zdy.openrdpremoteserver.service.Port2PortService;
import pers.zdy.openrdpremoteserver.share.PublicVariable;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Service
public class Port2PortServiceImpl implements Port2PortService  {

    @Override
    public void test(){
        try {

                PublicVariable.targetSocket=new Socket("172.30.200.50",3389);
        }catch (Exception ex){
            LogFactory.get().error(ex);
        }
    }

    private void controller() throws Exception{
        //PublicVariable.clientSocket;

        sendTarget();
        listenTarget();
    }

    @Override
    @Async("asyncServiceExecutor")
    public void sendTarget(){
        try {
             //根据输入输出流和服务端连接//获取一个输出流，向服务端发送信息
             OutputStream outputStream=PublicVariable.targetSocket.getOutputStream();
             InputStream inputStream = PublicVariable.clientSocket.getInputStream();

             while (true){
                 byte[] temp = new byte[10240];
                 int ret = inputStream.read(temp);
                 outputStream.write(temp,0,ret);
                 outputStream.flush();
             }
         } catch (Exception e) {
            LogFactory.get().error(e,"sendTarget error");
/*            try {
                PublicVariable.clientSocket.close();
                PublicVariable.targetSocket.close();
            }catch (Exception ex){

            }*/
         }

    }

    @Override
    @Async("asyncServiceExecutor")
    public void listenTarget(){
        try {

            //根据输入输出流和服务端连接//获取一个输出流，向服务端发送信息
            OutputStream outputStream=PublicVariable.clientSocket.getOutputStream();
            InputStream inputStream = PublicVariable.targetSocket.getInputStream();

            while (true){
                byte[] temp = new byte[10240];
                int ret =inputStream.read(temp);
                outputStream.write(temp,0,ret);
                outputStream.flush();
            }
        } catch (Exception e) {
            LogFactory.get().error(e,"listenTarget error");
/*            try {
                PublicVariable.clientSocket.close();
                PublicVariable.targetSocket.close();
            }catch (Exception ex){

            }*/

        }

    }

    @Override
    public void server(){
        try{
            ServerSocket serverSocket=new ServerSocket(8888);
            LogFactory.get().info("服务端已启动，等待客户端连接..");

            while(true) {

                    //侦听并接受到此套接字的连接,返回一个Socket对象
                    Socket socket = serverSocket.accept();
                    //根据输入输出流和客户端连接//得到一个输入流，接收客户端传递的信息
                    InputStream inputStream = socket.getInputStream();
                    //提高效率，将自己字节流转为字符流
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    //加入缓冲区
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    byte[] bytes = new byte[1024];
                    int ret = inputStream.read(bytes);

                    String temp = null;
                    String info = "";
                    while ((temp = bufferedReader.readLine()) != null) {
                        info += temp;
                        LogFactory.get().info(("已接收到客户端连接"));
                        LogFactory.get().info(("服务端接收到客户端信息：" + info + ",当前客户端ip为：" + socket.getInetAddress().getHostAddress()));
                    }

                    //获取一个输出流，向服务端发送信息
                    OutputStream outputStream = socket.getOutputStream();
                    //将输出流包装成打印流
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.print("111");
                    printWriter.flush();

                    //关闭相对应的资源
                    printWriter.close();
                    outputStream.close();
                }catch (Exception ex){
                    socket.shutdownOutput();//关闭输出流
                    bufferedReader.close();
                    inputStream.close();
                    socket.close();
                }

            }



        }catch (Exception ex){
            LogFactory.get().error(ex);
        }
    }


}
