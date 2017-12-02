package com.perfectmatch.perfectmatch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.perfectmatch.PerfectMatchApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PerfectMatchApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class PerfectmatchApplicationTests {

	@Test
	public void contextLoads() {
	}

}
