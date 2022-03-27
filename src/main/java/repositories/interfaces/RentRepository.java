package repositories.interfaces;

import entities.Disk;
import entities.Person;
import entities.Rent;
import repositories.interfaces.base.BaseRepository;

public interface RentRepository extends BaseRepository<Rent> {
    Rent readByPersonAndDisk(Person person, Disk disk);
}
