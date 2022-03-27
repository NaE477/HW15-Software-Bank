package repositories.impls;

import entities.Disk;
import repositories.impls.base.BaseRepositoryImpl;
import repositories.interfaces.DiskRepository;

import javax.persistence.EntityManagerFactory;

public class DiskRepositoryImpl extends BaseRepositoryImpl<Disk> implements DiskRepository {
    public DiskRepositoryImpl(EntityManagerFactory entityManagerFactory, Class<Disk> clazz) {
        super(entityManagerFactory, clazz);
    }

    @Override
    public Disk readByDiskName(String diskName) {
        try {
            return super
                    .getEntityManagerFactory()
                    .createEntityManager()
                    .createQuery("select d from Disk d where d.diskName = :diskName", Disk.class)
                    .setParameter("diskName", diskName)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
