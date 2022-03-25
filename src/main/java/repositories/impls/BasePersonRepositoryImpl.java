package repositories.impls;

import entities.Person;
import repositories.interfaces.BasePersonRepository;

import javax.persistence.EntityManagerFactory;

public abstract class BasePersonRepositoryImpl<T extends Person> extends BaseRepositoryImpl<T> implements BasePersonRepository<T> {
    public BasePersonRepositoryImpl(EntityManagerFactory entityManagerFactory, Class<T> clazz) {
        super(entityManagerFactory, clazz);
    }

    @Override
    public T readByUsername(String username) {
        try {
            return super
                    .getEntityManagerFactory()
                    .createEntityManager()
                    .createQuery("from " + super.getClazz().getSimpleName() + " u where u.username = :username", getClazz())
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
