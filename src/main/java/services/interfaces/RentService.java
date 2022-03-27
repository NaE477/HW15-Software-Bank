package services.interfaces;

import entities.Disk;
import entities.Person;
import entities.Rent;
import services.interfaces.base.BaseService;

public interface RentService extends BaseService<Rent> {
    Rent findByPersonAndDisk(Person person, Disk disk);
}
