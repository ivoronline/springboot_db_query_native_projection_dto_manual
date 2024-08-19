package com.ivoronline.repository;

import com.ivoronline.entity.Utility;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UtilityRepository extends CrudRepository<Utility, Integer> {

  //========================================================================================
  // GET PERSON
  //=======================================================================================
  // ["Bill", 30]
  @Query(value = "SELECT NAME, AGE FROM PERSON WHERE NAME = 'Bill'", nativeQuery = true)
  Object getPerson();

  //========================================================================================
  // GET PERSON LIST
  //=======================================================================================
  // ["Bill", 30]
  @Query(value = "SELECT NAME, AGE FROM PERSON WHERE NAME = 'John'", nativeQuery = true)
  List<Object[]> getPersonList();

}
