package com.itheima.bigevent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.itheima.bigevent.utils.AliOssUtil.ACCESS_KEY_ID;

@SpringBootTest
class BigEventApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(ACCESS_KEY_ID);
	}

}
