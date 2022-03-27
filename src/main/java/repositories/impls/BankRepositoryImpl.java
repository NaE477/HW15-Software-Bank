package repositories.impls;

import controllers.Bank;
import repositories.impls.base.BaseRepositoryImpl;
import repositories.interfaces.BankRepository;

import javax.persistence.EntityManagerFactory;

public class BankRepositoryImpl extends BaseRepositoryImpl<Bank> implements BankRepository {
    public BankRepositoryImpl(EntityManagerFactory entityManagerFactory, Class<Bank> clazz) {
        super(entityManagerFactory, clazz);
    }
}
