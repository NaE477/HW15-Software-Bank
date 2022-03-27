package repositories.impls;

import entities.Disk;
import repositories.impls.base.BaseRepositoryImpl;
import repositories.interfaces.DiskRepository;

import javax.persistence.EntityManagerFactory;

public class DiskRepositoryImpl extends BaseRepositoryImpl<Disk> implements DiskRepository {
    public DiskRepositoryImpl(EntityManagerFactory entityManagerFactory, Class<Disk> clazz) {
        super(entityManagerFactory, clazz);
    }
}
