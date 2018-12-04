package pers.zdy.openrdpremoteserver.service.impl;

import cn.hutool.log.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pers.zdy.openrdpremoteserver.service.AsyncService;

@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        LogFactory.get().info("start executeAsync");
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        LogFactory.get().info("end executeAsync");
    }

}
