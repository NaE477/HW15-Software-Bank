package repositories.impls;

import entities.Disk;
import entities.Person;
import entities.Rent;
import repositories.impls.base.BaseRepositoryImpl;
import repositories.interfaces.RentRepository;

import javax.persistence.EntityManagerFactory;

public class RentRepositoryImpl extends BaseRepositoryImpl<Rent> implements RentRepository {
    public RentRepositoryImpl(EntityManagerFactory entityManagerFactory, Class<Rent> clazz) {
        super(entityManagerFactory, clazz);
    }

    @Override
    public Rent readByPersonAndDisk(Person person, Disk disk) {
        return super
                .getEntityManagerFactory()
                .createEntityManager()
                .createQuery("select r from Rent r where r.person.id = :personId and r.disk.id = :diskId",Rent.class)
                .setParameter("personId",person.getId())
                .setParameter("diskId",disk.getId())
                .getSingleResult();
    }
}
