package com.ivoronline.repository;

import com.ivoronline.entity.Utility;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UtilityRepository extends CrudRepository<Utility, Integer> {

  //========================================================================================
  // GET COLUMNS
  //=======================================================================================
  @Query(value = "SELECT NAME, AGE  FROM PERSON WHERE NAME = 'Bill'", nativeQuery = true)
  Object getColumns();

}
