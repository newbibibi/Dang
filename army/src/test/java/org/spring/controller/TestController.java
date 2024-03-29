package org.spring.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.mapper.UserMapper;
import org.spring.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
@Log4j
public class TestController {
	@Autowired
	private WebApplicationContext ctx;
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private UserServiceImp userServiceImp;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testModify(){
		int result=1;
		result=result&mapper.modifyUser("pw", "44", "a");
		log.info(result);
	}
}
