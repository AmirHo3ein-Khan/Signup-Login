package ir.maktabsharif.user.repository;

import ir.maktabsharif.user.model.User;
import ir.maktabsharif.user.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        EntityManager em = JpaUtil.getEntityManager();
        return Optional.ofNullable(em.createQuery("FROM User u WHERE u.username = : username and u.password = : password", User.class)
                .setParameter("username", username)
                .setParameter("password", password).getSingleResult());
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        EntityManager em = JpaUtil.getEntityManager();
        return Optional.ofNullable(em.createQuery("FROM User u  WHERE u.username = : username", User.class)
                .setParameter("username", username).getSingleResult());
    }
}
