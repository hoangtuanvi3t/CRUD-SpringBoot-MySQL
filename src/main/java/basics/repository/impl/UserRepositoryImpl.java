package basics.repository.impl;

import basics.repository.UserRepository;

import basics.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

//a repository = tầng làm việc với database
// specialized implementation of @Component for indicating the Data access object
//manage connection with data source: create query --> obtain & store data
//Hibernate as the default JPA provider


@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;   //hibernate-entitymanager

    @Override
    public void save(User user) {
        entityManager.persist(user);  //To insert an entity in the database
    }

    @Override
    public List<User> findAll() {
        String sqlStr = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(sqlStr, User.class);
        return query.getResultList();
    }


    public int update(User user, int id) {
        String sqlStr = "UPDATE User u SET u.name = :name, u.email = :email WHERE u.id = :id";
        Query query = entityManager.createQuery(sqlStr).setParameter("email", user.getEmail())
                .setParameter("name", user.getName()).setParameter("id", id);

        return query.executeUpdate();
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

}