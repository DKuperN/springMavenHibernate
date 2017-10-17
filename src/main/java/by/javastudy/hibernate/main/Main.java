package by.javastudy.hibernate.main;

import by.javastudy.hibernate.dao.ContactEntity;
import org.hibernate.Session;

import javax.persistence.PersistenceException;

import static by.javastudy.hibernate.utils.HibernateSessionFactory.getSessionFactory;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        out.println("Hibernate tutorial");

        Session session = getSessionFactory().openSession();
        try {
            session.beginTransaction();

            ContactEntity contactEntity = new ContactEntity();

            contactEntity.setBirthDate(new java.util.Date());
            contactEntity.setFirstName("Nick");
            contactEntity.setLastName("VN");
            session.save(contactEntity);
            session.getTransaction().commit();

        } catch (PersistenceException sqlErr) {
            out.println("Some exception. Transaction will be reverted: " + sqlErr);
            out.println("message: " + sqlErr.getCause().getCause().getMessage());
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

}