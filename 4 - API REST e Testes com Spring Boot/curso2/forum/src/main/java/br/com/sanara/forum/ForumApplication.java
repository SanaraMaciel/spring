package br.com.sanara.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport //anotação para o spring pegar os parametros da url de paginação e mandar pro springdta
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

}
