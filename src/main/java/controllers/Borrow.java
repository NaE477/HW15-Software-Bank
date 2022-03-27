package controllers;

import entities.*;
import util.Date;

import java.time.LocalDate;

public interface Borrow {
    Rent borrow(Person person,Disk disk , Date borrowDate);
    Long delivery(Person person,Disk disk,Date deliveryDate);
    Disk getDisk(String diskName);
    Boolean isLate(LocalDate deliveryDate);
    LocalDate getDate(Date date);
}
