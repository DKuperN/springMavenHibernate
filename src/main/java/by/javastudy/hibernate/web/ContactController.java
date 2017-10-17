package by.javastudy.hibernate.web;

import by.javastudy.hibernate.entity.Contact;
import by.javastudy.hibernate.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @ResponseBody
    @GetMapping("/contact/{id}")
    public Contact get(@PathVariable Integer id) {
        return contactService.findById(id);
    }

    @GetMapping("/addContact")
    public String addContact() {
        return "addContact";
    }

//    @ResponseBody
    @PostMapping(value = "/save")
    public String save(@ModelAttribute("contact") Contact contact, Model model){
        contactService.save(contact);
        model.addAttribute("message", contact.getFirstName() + " " + contact.getLastName());
        return "welcome";
    }
}
