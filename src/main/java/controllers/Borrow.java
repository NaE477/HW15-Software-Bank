package controllers;

import entities.*;
import util.Date;

public interface Borrow {
    Rent borrow(Person person,Disk disk , Date borrowDate);
    Integer delivery(Person person,Disk disk,Date deliveryDate);
    Disk getDisk(String diskName);
    Boolean isLate(Date deliveryDate);
    Date getDate();
}
