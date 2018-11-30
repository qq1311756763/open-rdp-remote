package pers.zdy.openrdpremoteserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pers.zdy.openrdpremoteserver.task.RemoteServer;

@SpringBootApplication
public class OpenRdpRemoteServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenRdpRemoteServerApplication.class, args);
	}

	@Bean
	public RemoteServer startupRunner(){
		return new RemoteServer();
	}

}
