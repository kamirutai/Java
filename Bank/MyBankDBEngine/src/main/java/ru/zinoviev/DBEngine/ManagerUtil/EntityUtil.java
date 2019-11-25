package ru.zinoviev.DBEngine.ManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityUtil {

static {
   // entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
    entityManager = Persistence.createEntityManagerFactory("my-persistence-unit").createEntityManager();
}

   // private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        //entityManager = entityManagerFactory.createEntityManager();

        return entityManager;
    }

}
