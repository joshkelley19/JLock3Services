package kelley.josh.repository;

import kelley.josh.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by joshuakelley on 3/9/17.
 */
public interface UserRepository extends CrudRepository<User, Long>{
}
