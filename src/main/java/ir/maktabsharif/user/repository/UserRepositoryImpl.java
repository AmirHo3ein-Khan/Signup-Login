package ir.maktabsharif.user.repository;
import ir.maktabsharif.user.exception.UserNotFoundException;
import ir.maktabsharif.user.model.User;
import ir.maktabsharif.user.util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save(User user) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
    }

    @Override
    public Optional<User> findUserByUsernameAndPassword(String username , String password) {
        try {
        EntityManager em = JpaUtil.getEntityManager();
        return Optional.ofNullable(em.createQuery("FROM User u WHERE u.username = : username and u.password = : password", User.class)
                .setParameter("username", username)
                .setParameter("password", password).getSingleResult());
        } catch (NoResultException e ){
            throw new UserNotFoundException();
        }
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        try {
        EntityManager em = JpaUtil.getEntityManager();
        return Optional.ofNullable(em.createQuery("FROM User u  WHERE u.username = : username", User.class)
                .setParameter("username", username).getSingleResult());
        } catch (NoResultException e ){
            throw new UserNotFoundException();
        }
    }
}
