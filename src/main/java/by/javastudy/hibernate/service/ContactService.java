package by.javastudy.hibernate.service;

import by.javastudy.hibernate.dao.ContactDAO;
import by.javastudy.hibernate.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactService {

    @Autowired
    private ContactDAO contactDAO;

    @Transactional
    public Contact findById(Integer id) {
        return contactDAO.findById(id);
    }
}
