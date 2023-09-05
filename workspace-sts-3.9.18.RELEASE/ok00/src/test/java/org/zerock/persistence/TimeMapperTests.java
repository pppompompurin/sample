package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class TimeMapperTests {
	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testMapper() {
		log.info("현재 시간:" + timeMapper.getTime());
	}
	
	@Test
	public void testMapper1() {
		log.info("지금 시간:" + timeMapper.getTime1());
	}
	

}
