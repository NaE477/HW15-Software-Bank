package controllers.impls;

import controllers.Borrow;
import entities.Disk;
import entities.Person;
import util.Date;

public class BorrowImpl implements Borrow {
    @Override
    public void borrow(Date borrowDate, Person person, Disk disk) {

    }

    @Override
    public Integer delivery(Date deliveryDate, Person person, Disk disk) {
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
