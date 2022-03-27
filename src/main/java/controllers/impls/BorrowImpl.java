package controllers.impls;

import controllers.Borrow;
import controllers.DateUtil;
import entities.Disk;
import entities.Person;
import entities.Rent;
import util.Date;

import javax.persistence.EntityManagerFactory;

public class BorrowImpl implements Borrow {
    private final EntityManagerFactory factory;

    public BorrowImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public Rent borrow(Person person,Disk disk , Date borrowDate) {
        return new Rent(person,disk, DateUtil.customDateToLocalDate(borrowDate));
    }

    @Override
    public Integer delivery(Person person, Disk disk, Date deliveryDate) {
        return null;
    }


    @Override
    public Disk getDisk(String diskName) {
        return null;
    }

    @Override
    public Boolean isLate(Date deliveryDate) {
        return null;
    }

    @Override
    public Date getDate() {
        return null;
    }
}
