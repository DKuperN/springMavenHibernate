package by.javastudy.hibernate.service;

import by.javastudy.hibernate.dao.ContactDAO;
import by.javastudy.hibernate.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Transactional
    public Contact findById(Integer id) {
        return contactDAO.findById(id);
    }

    @Transactional
    public void save(Contact contact) {
        contactDAO.save(contact);
    }

    @Transactional
    public boolean remove(Integer contactId) {
        return contactDAO.removeById(contactId);
    }

    //TODO
    public Contact findContactByFirstName(String firstName){
        return contactDAO.findByFirstName(firstName);
    }

}
