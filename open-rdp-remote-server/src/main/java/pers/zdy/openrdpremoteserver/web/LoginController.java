package pers.zdy.openrdpremoteserver.web;

import cn.hutool.log.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.zdy.openrdpremoteserver.core.Result;
import pers.zdy.openrdpremoteserver.core.ResultGenerator;
import pers.zdy.openrdpremoteserver.domain.pojo.UserMassage;
import pers.zdy.openrdpremoteserver.service.UserLoginService;

import static pers.zdy.openrdpremoteserver.share.PublicVariable.loginSuccess;

@RestController
@RequestMapping("login")
public class LoginController {


    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/usrAndPwd")
    @CrossOrigin
    public Result login(@RequestBody UserMassage userMassage){
        LogFactory.get().info("start submit");

        UserMassage rt = userLoginService.login(userMassage);
        if (loginSuccess.equals(rt.getState())){
            return ResultGenerator.genSuccessResult(rt);
        }else {
            return ResultGenerator.genErrorResult(rt);
        }

    }

}
