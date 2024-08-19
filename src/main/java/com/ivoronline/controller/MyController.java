package com.ivoronline.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivoronline.dto.PersonDTO;
import com.ivoronline.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired UtilityRepository utilityRepository;

  //================================================================
  // GET PERSON DTO
  //================================================================
  @RequestMapping("GetPersonDTO")
  PersonDTO returnPersonDTO() throws JsonProcessingException {

    //GET COLUMNS
    Object[] columns = (Object[]) utilityRepository.getColumns(); //["Bill",30]

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



