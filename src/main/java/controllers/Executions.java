package controllers;


import javax.persistence.EntityManagerFactory;

public class Executions {
    public static void main(String[] args) {
        EntityManagerFactory emf = EntityManagerSingleton.getInstance();
        emf.createEntityManager();
    }
}
