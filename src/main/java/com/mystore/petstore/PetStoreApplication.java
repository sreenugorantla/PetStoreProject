package com.mystore.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetStoreApplication {
	
	
	public static void main(String[] args) {
		
		PetStoreLog mylog=new PetStoreLog();
		mylog.createFile();
		
		SpringApplication.run(PetStoreApplication.class, args);
	}

}
