package com.crud.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TasksApplication/* extends SpringBootServletInitializer*/  {

/*	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TasksApplication.class);
	}*/


    public static void main(String[] args) {
        SpringApplication.run(TasksApplication.class, args);
    }


}