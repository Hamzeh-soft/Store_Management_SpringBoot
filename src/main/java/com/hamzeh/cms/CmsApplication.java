package com.hamzeh.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
    "com.hamzeh.cms.Model","com.hamzeh.cms.api","com.hamzeh.cms.services"
        ,"com.hamzeh.cms.config"
})
@EnableJpaRepositories
public class CmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

}
