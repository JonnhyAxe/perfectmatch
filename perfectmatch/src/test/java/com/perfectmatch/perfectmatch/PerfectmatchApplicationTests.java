package com.perfectmatch.perfectmatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.perfectmatch.perfectmatch.spring.PerfectMatchWebConfig;
import com.perfectmatch.spring.PerfectMatchPersistenceJpaConfig;
import com.perfectmatch.spring.PerfectMatchServletConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { PerfectMatchPersistenceJpaConfig.class, PerfectMatchWebConfig.class,
        PerfectMatchServletConfig.class }, loader = AnnotationConfigContextLoader.class)

public class PerfectmatchApplicationTests {

	@Test
	public void contextLoads() {
	}

}
