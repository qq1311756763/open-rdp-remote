package pers.zdy.openrdpremoteserver.domain.dao;


import org.beetl.sql.core.annotatoin.SqlResource;
import pers.zdy.openrdpremoteserver.domain.pojo.UserMassage;

import java.util.List;

/**
 * 登录验证Dao
 * @author :zdy
 * @date :2018/12/7
 * */
@SqlResource("LoginDao")
public interface LoginDao {

    /**
     * 获取登录用户的信息
     * @param userMassage 登录信息
     * @return 获取的信息
     **/
    List<UserMassage> queryUserLoginMessage (UserMassage userMassage);
}
