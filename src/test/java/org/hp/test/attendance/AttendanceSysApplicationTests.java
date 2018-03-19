package org.hp.test.attendance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttendanceSysApplicationTests {
	@Autowired
	private Environment env;
	@Test
	public void contextLoads() {

		System.out.println(env.getProperty("moi.delay"));
	}

}
