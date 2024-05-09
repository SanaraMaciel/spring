package br.com.sanara.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport //anotação para o spring pegar os parametros da url de paginação e mandar pro springdta
@EnableCaching //habilita o uso de cache na aplicação
@EnableSwagger2 //habilita o uso do swagger p/ documentacao da api
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

}
