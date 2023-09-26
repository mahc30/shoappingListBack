package com.shoapping.list.ShOAPpingList;

import com.shoapping.list.ShOAPpingList.infrastructure.controller.Socket.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class ShOaPpingListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShOaPpingListApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		Server server = Server.getInstance();
	}
}

