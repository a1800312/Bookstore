package fi.hh.palvelinohjelmointi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.palvelinohjelmointi.Bookstore.web.BookController;
import fi.hh.palvelinohjelmointi.Bookstore.web.UserDetailServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private BookController testBookControllers;
	
	@Autowired
	private UserDetailServiceImpl testUDSImplControllers;
	
	@Test
	public void contextOfBookControllerLoads() throws Exception {
		assertThat(testBookControllers).isNotNull();
	}
	
	@Test
	public void contextOfUserDetailServiceImplLoads() throws Exception {
		assertThat(testUDSImplControllers).isNotNull();
	}

}
