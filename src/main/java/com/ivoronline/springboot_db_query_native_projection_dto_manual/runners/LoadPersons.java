package com.ivoronline.springboot_db_query_native_projection_dto_manual.runners;

import com.ivoronline.springboot_db_query_native_projection_dto_manual.entities.Person;
import com.ivoronline.springboot_db_query_native_projection_dto_manual.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LoadPersons implements CommandLineRunner {

  @Autowired PersonRepository personRepository;

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    personRepository.save(new Person("John" , 20));
  }

}

