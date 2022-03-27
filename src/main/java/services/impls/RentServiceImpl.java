package services.impls;

import entities.Disk;
import entities.Person;
import entities.Rent;
import repositories.interfaces.RentRepository;
import services.impls.base.BaseServiceImpl;
import services.interfaces.RentService;

public class RentServiceImpl extends BaseServiceImpl<Rent, RentRepository> implements RentService {
    public RentServiceImpl(RentRepository repository) {
        super(repository);
    }

    @Override
    public Rent findByPersonAndDisk(Person person, Disk disk) {
        return repository.readByPersonAndDisk(person,disk);
    }
}
