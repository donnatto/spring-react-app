package me.donnatto.springreact.controller;

import java.net.URISyntaxException;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.donnatto.springreact.model.Contact;
import me.donnatto.springreact.model.ContactRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

  private ContactRepository repository;

  @Autowired
  public ContactController(ContactRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/contacts")
  Collection<Contact> contacts() {
    return (Collection<Contact>) repository.findAll();
  }

  @PostMapping("/contacts")
  ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) throws URISyntaxException {
    Contact result = repository.save(contact);
    return ResponseEntity.ok().body(result);
  }
}