package org.ss.jpa.intro;

import org.ss.jpa.intro.domain.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("digi-book-jpa");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Contact contact = new Contact();

        em.find(Contact.class,6L);
        System.out.println(contact.getEmail());


        contact.setEmail("azlkje@zae.fr");
        em.persist(contact);
        System.out.println(contact);

        em.getTransaction().commit();

/*
        List<Contact> list = (List<Contact>) em.createQuery("from Contact", Contact.class ).getResultList();
        for (Contact c :list){
            System.out.println(c);
        } */

        em.close();
        emf.close();

    }
}
