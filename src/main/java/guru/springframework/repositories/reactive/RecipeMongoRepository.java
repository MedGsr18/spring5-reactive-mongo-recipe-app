package guru.springframework.repositories.reactive;

import guru.springframework.domain.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RecipeMongoRepository extends ReactiveMongoRepository<Recipe,String> {

}
