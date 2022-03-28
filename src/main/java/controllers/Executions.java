package controllers;


import controllers.impls.BorrowImpl;
import entities.Disk;
import entities.Person;
import entities.Rent;
import repositories.impls.DiskRepositoryImpl;
import repositories.impls.PersonRepositoryImpl;
import repositories.impls.RentRepositoryImpl;
import services.impls.DiskServiceImpl;
import services.impls.PersonServiceImpl;
import services.impls.RentServiceImpl;
import services.interfaces.DiskService;
import services.interfaces.PersonService;
import services.interfaces.RentService;
import util.Date;

import javax.persistence.EntityManagerFactory;
import java.util.*;

public class Executions {
    private static final Scanner sc = new Scanner(System.in);
    private static final EntityManagerFactory factory = EntityManagerSingleton.getInstance();

    public static void main(String[] args) {
        int occurrences;
        long fine;
        Borrow borrowUtil;
        List<String> diskNames = new ArrayList<>();
        Map<String, Long> personsAndFines = new HashMap<>();
        System.out.println("Enter [occurrence] [fine],e.g. 8 8500:");
        while (true) {
            String occAndFine = sc.nextLine();
            if (isOccurrencesAndFineCorrect(occAndFine)) {
                occurrences = Integer.parseInt(occAndFine.split(" ")[0]);
                fine = Long.parseLong(occAndFine.split(" ")[1]);
                borrowUtil = new BorrowImpl(factory, fine);
                break;
            } else System.out.println("Wrong occurrence and fine format.");
        }
        for (int i = 1; i <= occurrences; ) {
            System.out.print("Occurrence" + i + ": ");
            String occurrence = sc.nextLine();
            if (isOccurrenceCorrect(occurrence)) {
                int year = Integer.parseInt(occurrence.split(" ")[0]);
                int month = Integer.parseInt(occurrence.split(" ")[1]);
                int day = Integer.parseInt(occurrence.split(" ")[2]);
                String username = occurrence.split(" ")[3];
                String diskName = occurrence.split(" ")[4];
                Person person = initialPersonIfNot(username);
                Disk disk = initialDiskIfNot(diskName);
                Date date = new Date(year, month, day);
                if (!isBorrowed(diskNames, diskName)) {
                    Rent rent = borrowUtil.borrow(person, disk, date);
                    handleFiningPerson(personsAndFines,username,0L);
                    diskNames.add(diskName);
                    System.out.println(person.getUsername() + " rented " + disk.getDiskName());
                } else {
                    Long fineToSave = borrowUtil.delivery(person, disk, date);
                    handleFiningPerson(personsAndFines, username, fineToSave);
                    diskNames.remove(diskName);
                    System.out.println(person.getUsername() + " delivered " + disk.getDiskName() + ",fine: " + fineToSave);
                }
                i++;
            } else System.out.println("Wrong Occurrence format.");
        }
        System.out.println("Fines: ");
        personsAndFines.forEach((p, f) -> System.out.println(p + ": " + f));
        System.out.println("Borrowed Disks: ");
        diskNames.forEach(System.out::println);
        clearRent();
    }

    private static Boolean isOccurrencesAndFineCorrect(String userInput) {
        try {
            if (userInput.split(" ").length != 2) return false;
            Integer.parseInt(userInput.split(" ")[0]);
            Long.parseLong(userInput.split(" ")[1]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static Boolean isOccurrenceCorrect(String userInput) {
        try {
            if (userInput.length() == 0) return false;
            if (userInput.split(" ").length != 5) return false;
            int year = Integer.parseInt(userInput.split(" ")[0]);
            int month = Integer.parseInt(userInput.split(" ")[1]);
            int day = Integer.parseInt(userInput.split(" ")[2]);
            return isDateFormatCorrect(new Date(year, month, day));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static Boolean isDateFormatCorrect(Date date) {
        if (date.getYear() > 1401 || date.getYear() < 1390) return false;
        if (date.getMonth() > 12 || date.getMonth() <= 0) return false;
        if (date.getDay() > 31 || date.getDay() <= 0) return false;
        if (date.getMonth() <= 6) return date.getDay() <= 31;
        else return date.getDay() <= 30;
    }

    private static Person initialPersonIfNot(String username) {
        PersonService personService = new PersonServiceImpl(new PersonRepositoryImpl(factory, Person.class));
        Person toFind = personService.findByUsername(username);
        if (toFind == null) {
            Person person = new Person();
            person.setUsername(username);
            person.setPassword("1234");
            return personService.insert(person);
        } else return toFind;
    }

    private static Disk initialDiskIfNot(String diskName) {
        DiskService diskService = new DiskServiceImpl(new DiskRepositoryImpl(factory, Disk.class));
        Disk toFind = diskService.findByDiskName(diskName);
        if (toFind == null) {
            Disk disk = new Disk();
            disk.setDiskName(diskName);
            disk.setIsBorrowed(false);
            return diskService.insert(disk);
        } else return toFind;
    }

    private static Boolean isBorrowed(List<String> disks, String disk) {
        return disks.contains(disk);
    }

    private static void handleFiningPerson(Map<String, Long> fines, String name, Long fine) {
        if (fines.containsKey(name)) {
            Long previousFine = fines.get(name);
            fines.put(name, previousFine + fine);
        } else fines.put(name, fine);
    }

    private static void clearRent() {
        RentService rentService = new RentServiceImpl(new RentRepositoryImpl(factory,Rent.class));
        rentService.truncate("rent");
    }
}