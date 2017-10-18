package by.javastudy.hibernate.dao;

import by.javastudy.hibernate.entity.Contact;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

@Transactional
@Repository
public class ContactDAO {

    protected static final Logger LOG = LoggerFactory.getLogger(ContactDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public Contact findById(Integer id) {
        return entityManager.find(Contact.class, id);
    }

    //TODO add query for search Contact by First Name
    public Contact findByFirstName (String name) {
        return entityManager.find(Contact.class, entityManager.createQuery(""));
    }

    public void save(Contact contact){
        entityManager.persist(contact);
    }

    public boolean remove(Contact contact) {
        try {
            entityManager.remove(contact);
            return true;
        } catch (IllegalArgumentException | TransactionRequiredException ex) {
            LOG.warn("Impossible to remove contact: " + ex);
            return false;
        }
    }

    public boolean removeById(Integer contactId) {
        try {
            entityManager.remove(findById(contactId));
            return true;
        } catch (IllegalArgumentException | TransactionRequiredException ex) {
            LOG.warn("Impossible to remove contact: " + ex);
            return false;
        }
    }

}
