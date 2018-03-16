package fi.hh.palvelinohjelmointi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.palvelinohjelmointi.Bookstore.domain.Category;
import fi.hh.palvelinohjelmointi.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository cRepository;
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = cRepository.findByName("Mixi");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Mixi");
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Testi kategoria");
		cRepository.save(category);
		assertThat(category.getId()).isNotNull();
		assertThat(category.getName()).isNotEmpty();
	}
	
	@Test
	public void deleteCategory() {
		List<Category> categories = cRepository.findByName("Mixi");
		cRepository.delete(categories);
		assertThat(categories.get(0).getId()).isNull();
	}

}
