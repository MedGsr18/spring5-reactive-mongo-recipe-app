package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryMongoRepositoryTestIT {
    @Autowired
    CategoryMongoRepository categoryMongoRepository;
    private final Long NUMBER_OF_CATEGORIES=2L;




    @Before
    public void setUp() throws Exception {
       categoryMongoRepository.deleteAll().block();
        Category category1=new Category();
        category1.setId("id1");
        category1.setDescription("test1");
        categoryMongoRepository.save(category1).block();
        Category category2=new Category();
        category2.setId("id2");
        category2.setDescription("test2");
        categoryMongoRepository.save(category2).block();
    }

    @Test
    public void countCategories(){
        Mono<Long> categories=categoryMongoRepository.count();
        assertEquals(NUMBER_OF_CATEGORIES,categories.block());
    }

    @Test
    public void findBydescrition() {
        Mono<Category> expectedCatagorie=categoryMongoRepository.findByDescription("test1");
        assertNotNull(expectedCatagorie);
        assertEquals("id1", expectedCatagorie.block().getId());
    }
}