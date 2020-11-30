package agh.alleviation.persistence;

import agh.alleviation.model.user.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Repository of users.
 * @author Anna Nosek
 * @see User
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    /**
     * Find by login user.
     *
     * @param login the login
     * @return the user
     */
    User findByLogin(String login);

    List<User> findAll();


}
