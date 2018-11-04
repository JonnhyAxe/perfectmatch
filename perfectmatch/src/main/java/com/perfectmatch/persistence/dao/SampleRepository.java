package com.perfectmatch.persistence.dao;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.perfectmatch.common.interfaces.ByNameSearchable;
import com.perfectmatch.persistence.model.Sample;


public interface SampleRepository extends MongoRepository<Sample, String>, ByNameSearchable<Sample> {

}
