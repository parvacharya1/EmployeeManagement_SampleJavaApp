package com.employee.management;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {

	//logging
	static final Logger logger  = LogManager.getLogger(Application.class.getName());
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
