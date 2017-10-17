package by.javastudy.hibernate.web;

import by.javastudy.hibernate.entity.Contact;
import by.javastudy.hibernate.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @ResponseBody
    @GetMapping("/contact/{id}")
    public Contact get(@PathVariable Integer id) {
        return contactService.findById(id);
    }
}
