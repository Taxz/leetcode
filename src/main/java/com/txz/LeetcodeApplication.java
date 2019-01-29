package com.txz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class LeetcodeApplication {

	public static void main(String[] args) {
		//SpringApplication.run(LeetcodeApplication.class, args);
		Random r = new Random();

		System.out.println(r.nextInt(300));
	}

}

