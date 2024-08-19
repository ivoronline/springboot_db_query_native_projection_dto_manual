package com.ivoronline.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivoronline.dto.PersonDTO;
import com.ivoronline.repository.UtilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired UtilityRepository utilityRepository;

  //================================================================
  // GET PERSON DTO
  //================================================================
  @RequestMapping("GetPersonDTO")
  PersonDTO returnPersonDTO() throws JsonProcessingException {

    //GET RECORDS
    Object[] record = (Object[]) utilityRepository.getPerson(); //["Bill",30]

    //DISPLAY RECORDS
    String propertiesJSON = new ObjectMapper().writeValueAsString(record);
    System.out.println(propertiesJSON);

    //MAP RECORDS INTO DTO
    PersonDTO personDTO      = new PersonDTO();
              personDTO.name = (String ) record[0];
              personDTO.age  = (Integer) record[1];

    //RETURN DTO
    return personDTO;

  }

  //================================================================
  // GET PERSON DTO LIST
  //================================================================
  @RequestMapping("GetPersonDTOList")
  List<PersonDTO> returnPersonDTOList() throws JsonProcessingException {

    //GET RECORDS
    List<Object[]> records = utilityRepository.getPersonList();
 
    //DISPLAY RECORDS
    String recordsJSON = new ObjectMapper().writeValueAsString(records);
    System.out.println(recordsJSON);

    //MAP RECORDS INTO DTO LIST
    List<PersonDTO> personDTOList = new ArrayList<>();
    for (Object[] record : records) {
      PersonDTO personDTO      = new PersonDTO();
                personDTO.name = (String ) record[0];
                personDTO.age  = (Integer) record[1];
      personDTOList.add(personDTO);
    }

    //RETURN DTO LIST
    return personDTOList;

  }

}



