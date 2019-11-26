package me.donnatto.springreact.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoLoader implements CommandLineRunner {

  private final ContactRepository repository;

  @Autowired
  public DemoLoader(ContactRepository repository) {
    this.repository = repository;
  }

  public void run(String... strings) throws Exception {
    repository.save(new Contact("Edwin", "Dominguez", "edwindominguez@hotmail.com"));
  }

}