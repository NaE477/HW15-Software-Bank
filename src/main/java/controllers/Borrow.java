package controllers;

import entities.*;
import util.Date;

public interface Borrow {
    void borrow(Date borrowDate, Person person, Disk disk);
    Integer delivery(Date deliveryDate,Person person,Disk disk);
    Disk getDisk(String diskName);
    Boolean isLate(Date deliveryDate);
    Date getDate();
}
