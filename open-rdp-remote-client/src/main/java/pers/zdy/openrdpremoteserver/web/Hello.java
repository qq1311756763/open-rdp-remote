package pers.zdy.openrdpremoteserver.web;

import cn.hutool.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.zdy.openrdpremoteserver.service.AsyncService;

@RestController
public class Hello {


    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/")
    public String submit(){
        LogFactory.get().info("start submit");

        //调用service层的任务
        asyncService.executeAsync();

        LogFactory.get().info("end submit");

        return "success";
    }

}
