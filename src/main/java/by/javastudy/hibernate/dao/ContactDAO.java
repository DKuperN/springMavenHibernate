package by.javastudy.hibernate.dao;

import by.javastudy.hibernate.entity.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class ContactDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Contact findById(Integer id) {
        return entityManager.find(Contact.class, id);
    }

    public void save(Contact contact){
        entityManager.persist(contact);
    }
}
