package by.javastudy.hibernate.main;

import by.javastudy.hibernate.dao.ContactEntity;
import by.javastudy.hibernate.utils.HibernateSessionFactory;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setBirthDate(new java.util.Date());
        contactEntity.setFirstName("Nick");
        contactEntity.setLastName("VN");

        session.save(contactEntity);
        session.getTransaction().commit();

        session.close();

    }
}