package pers.zdy.openrdpremoteserver;


import org.beetl.sql.core.SQLManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zdy.openrdpremoteserver.domain.dao.LoginDao;
import pers.zdy.openrdpremoteserver.domain.pojo.UserMassage;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenRdpRemoteServerApplicationTests {

	@Test
	public void contextLoads() {
	}

//	@Autowired
//	LoginDao loginDao;

	@Autowired
	LoginDao loginDao;


	@Test
	public void testLogin(){
		UserMassage userMassage = new UserMassage();
		userMassage.setUsr("zdy");
		List<UserMassage> userMassages = loginDao.queryUserLoginMessage(userMassage);
		int a=0;
	}

}
