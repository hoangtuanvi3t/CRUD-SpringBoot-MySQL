package basics.service;

import basics.model.User;
import basics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Admin on 6/29/2017.
 * a service class
 *
 */

@Service
public class UserService {

    //inject a DAO into a service
    @Autowired // This means to get the bean called userRepository
    private UserRepository userRepository;

    @Transactional
    public String addNewUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public String updateUser(User user, int id) {
        int affectedRows = userRepository.update(user, id);
        return "Updated " + affectedRows + " rows";
    }

    @Transactional
    public String deleteUser(int id) {
        userRepository.delete(id);
        return "Deleted";
    }
}
