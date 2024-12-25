package ir.maktabsharif.user.util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory entityManagerFactory = null;
    private JpaUtil(){}

    private static EntityManagerFactory getEntityManagerFactory(){
        if (entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        }
        return entityManagerFactory;
    }
    public static EntityManager getEntityManager(){
        return getEntityManagerFactory().createEntityManager();
    }
}
