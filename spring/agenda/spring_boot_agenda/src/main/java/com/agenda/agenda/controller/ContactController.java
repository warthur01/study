package com.agenda.agenda.controller;

import com.agenda.agenda.entity.Contact;
import com.agenda.agenda.service.ContactService;
import com.agenda.agenda.validation.InvalidEmailException;
import com.agenda.agenda.validation.InvalidNumberException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<Contact> findAll() {
        return contactService.listAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Contact findById(@PathVariable Long id) {
        return contactService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Contact create(@RequestBody Contact contact)
            throws InvalidEmailException, InvalidNumberException {

        contactService.create(contact);
        return contact;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Contact update(
            @PathVariable Long id,
            @RequestBody Contact contact
    ) throws InvalidEmailException, InvalidNumberException {

        contact.setId(id);

        contactService.update(contact);

        return contact;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        contactService.delete(id);
    }
}
