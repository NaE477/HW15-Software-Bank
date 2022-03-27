package controllers.impls;

import controllers.Borrow;
import repositories.impls.DiskRepositoryImpl;
import repositories.impls.RentRepositoryImpl;
import services.impls.DiskServiceImpl;
import services.impls.RentServiceImpl;
import services.interfaces.DiskService;
import services.interfaces.RentService;
import util.DateUtil;
import entities.Disk;
import entities.Person;
import entities.Rent;
import util.Date;

import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowImpl implements Borrow {
    private final EntityManagerFactory factory;
    private final RentService rentService;
    private final Long fine;

    public BorrowImpl(EntityManagerFactory factory,Long fine) {
        this.factory = factory;
        rentService = new RentServiceImpl(new RentRepositoryImpl(factory,Rent.class));
        this.fine = fine;
    }

    @Override
    public Rent borrow(Person person,Disk disk , Date borrowDate) {
        return rentService.insert(new Rent(person,disk, DateUtil.customDateToLocalDate(borrowDate)));
    }

    @Override
    public Long delivery(Person person, Disk disk, Date deliveryDate) {
        Rent toDeliver = rentService.findByPersonAndDisk(person,disk);
        if (isLate(toDeliver.getBorrowDate())){
            return ChronoUnit.DAYS.between(getDate(deliveryDate),LocalDate.now()) - 7 * fine;
        } else return 0L;
    }


    @Override
    public Disk getDisk(String diskName) {
        DiskService diskService = new DiskServiceImpl(new DiskRepositoryImpl(factory,Disk.class));
        return diskService.findByDiskName(diskName);
    }

    @Override
    public Boolean isLate(LocalDate deliveryDate) {
        return ChronoUnit.DAYS.between(deliveryDate,LocalDate.now()) <= 7;
    }

    @Override
    public LocalDate getDate(Date customDate) {
        return DateUtil.customDateToLocalDate(customDate);
    }
}
