package pers.zdy.openrdpremoteserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.zdy.openrdpremoteserver.domain.dao.LoginDao;
import pers.zdy.openrdpremoteserver.domain.pojo.UserMassage;
import pers.zdy.openrdpremoteserver.service.UserLoginService;

import java.util.List;

import static pers.zdy.openrdpremoteserver.share.PublicVariable.loginSuccess;
import static pers.zdy.openrdpremoteserver.share.PublicVariable.userDoesNotExist;
import static pers.zdy.openrdpremoteserver.share.PublicVariable.userPwdError;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    LoginDao loginDao;

    @Override
    public UserMassage login(UserMassage userMassage){
        List<UserMassage> rightMessage = loginDao.queryUserLoginMessage(userMassage);
        if (rightMessage.size()<=0){
            userMassage.setState(userDoesNotExist);
            return userMassage;
        }else {
            if (rightMessage.get(0).getPwd() .equals(userMassage.getPwd()) ){
                rightMessage.get(0).setState(loginSuccess);
                return rightMessage.get(0);
            }else {
                userMassage.setState(userPwdError);
                return userMassage;
            }
        }
    }
}
