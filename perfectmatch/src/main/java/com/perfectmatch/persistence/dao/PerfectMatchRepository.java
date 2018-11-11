package com.perfectmatch.persistence.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.perfectmatch.common.interfaces.ByNameSearchable;
import com.perfectmatch.persistence.model.PerfectMatch;

public interface PerfectMatchRepository extends MongoRepository<PerfectMatch, String>, ByNameSearchable<PerfectMatch> {

}