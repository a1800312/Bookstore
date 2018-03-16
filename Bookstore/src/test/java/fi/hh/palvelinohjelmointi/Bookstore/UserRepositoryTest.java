package fi.hh.palvelinohjelmointi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.palvelinohjelmointi.Bookstore.domain.User;
import fi.hh.palvelinohjelmointi.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository uRepository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User user1 = uRepository.findByUsername("user");
		assertThat(user1).isNotNull();
		assertThat(user1.getRole()).isEqualTo("USER");
	}
	
	@Test
	public void createNewBook() {
		User user2 = new User("user2", "$2a$06$zmBwssLAoceLGcleYf7oGedMAfAabHmWbwpRTtvueWNsQA4QinudW", "USER", "user2@palvelinohjelmointi.fi");
		uRepository.save(user2);
		assertThat(user2.getUsername()).isNotEmpty();
		assertThat(user2.getPassword()).isNotEmpty();
		assertThat(user2.getEmail()).isNotEmpty();
		assertThat(user2.getId()).isNotNull();
		assertThat(user2.getRole()).isNotEmpty();
	}
	
	@Test
	public void deleteBook() {
		User user3 = uRepository.findByUsername("user");
		uRepository.delete(user3);
		assertThat(uRepository.findByUsername("user")).isNull();
	}

}
