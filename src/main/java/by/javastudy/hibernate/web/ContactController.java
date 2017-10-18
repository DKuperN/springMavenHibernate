package by.javastudy.hibernate.web;

import by.javastudy.hibernate.entity.Contact;
import by.javastudy.hibernate.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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

    @GetMapping("/removeContact")
    public String removeContact() {
        return "removeContact";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("contact") Contact contact, Model model){
        contactService.save(contact);
        model.addAttribute("message", contact.getFirstName() + " " + contact.getLastName());
        return "welcome";
    }

    @PostMapping(value = "/remove")
    public String remove(@RequestParam("contactId") Integer contactId,
                         @RequestParam("firstName") String firstName, Model model){
        String message;
        if(contactId != null) {
            if(contactService.remove(contactId)) {
                message = "Contact with Id - " + contactId + " was remowed!";
            } else {
                message = "Impossible to find Contact Id - " + contactId + "!";
            }
        } else if (firstName != null && !Objects.equals(firstName, "")){
            Contact contactByFirstName = contactService.findContactByFirstName(firstName);
            if(contactService.remove(contactByFirstName.getId())){
                message = "Contact with First Name - " + firstName  + " was remowed!";
            } else {
                message = "Impossible to find with First Name - " + firstName + "!";
            }
        } else {
            return "error";
        }

        model.addAttribute("message", message);
        return "welcome";
    }


}
