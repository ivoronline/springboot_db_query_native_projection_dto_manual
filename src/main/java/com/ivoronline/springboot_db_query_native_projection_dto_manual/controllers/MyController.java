package com.ivoronline.springboot_db_query_native_projection_dto_manual.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivoronline.springboot_db_query_native_projection_dto_manual.dto.PersonDTO;
import com.ivoronline.springboot_db_query_native_projection_dto_manual.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @Autowired PersonRepository personRepository;

  //================================================================
  // RETURN PERSON DTO
  //================================================================
  @RequestMapping("ReturnPersonDTO")
  PersonDTO returnPersonDTO() throws JsonProcessingException {

    //GET COLUMNS
    Object[] columns = (Object[]) personRepository.returnPersonDTO();     //["John",20]

    //DISPLAY COLUMNS
    String columnsJSON = new ObjectMapper().writeValueAsString(columns);
    System.out.println(columnsJSON);

    //MAP COLUMNS INTO DTO
    PersonDTO personDTO      = new PersonDTO();
              personDTO.name = (String ) columns[0];
              personDTO.age  = (Integer) columns[1];

    //RETURN OBJECT ARRAY
    return personDTO;

  }

}


