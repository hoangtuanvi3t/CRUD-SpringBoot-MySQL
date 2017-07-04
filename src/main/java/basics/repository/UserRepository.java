package basics.repository;

import basics.model.User;

import java.util.List;

/**
 * Created by Admin on 6/30/2017.
 */
public interface UserRepository {

    void save(User user);

    List<User> findAll();

    int update(User user, int id);

    void delete(int id);
}
