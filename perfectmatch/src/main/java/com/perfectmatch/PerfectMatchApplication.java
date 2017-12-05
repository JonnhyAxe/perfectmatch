package com.perfectmatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


//import com.perfectmatch.spring.PerfectMatchPersistenceJpaConfig;
import com.perfectmatch.spring.PerfectMatchWebConfig;



@SpringBootApplication
@Import({
//        PerfectMatchPersistenceJpaConfig.class,
        PerfectMatchWebConfig.class
})
public class PerfectMatchApplication {

	public static void main(String[] args) {

        SpringApplication.run(PerfectMatchApplication.class, args);
	}

}
