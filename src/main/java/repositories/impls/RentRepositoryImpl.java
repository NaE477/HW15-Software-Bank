package repositories.impls;

import entities.Rent;
import repositories.impls.base.BaseRepositoryImpl;
import repositories.interfaces.RentRepository;

import javax.persistence.EntityManagerFactory;

public class RentRepositoryImpl extends BaseRepositoryImpl<Rent> implements RentRepository {
    public RentRepositoryImpl(EntityManagerFactory entityManagerFactory, Class<Rent> clazz) {
        super(entityManagerFactory, clazz);
    }
}
