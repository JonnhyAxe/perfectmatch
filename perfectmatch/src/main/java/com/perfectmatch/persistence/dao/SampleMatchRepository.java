package com.perfectmatch.persistence.dao;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.perfectmatch.persistence.model.Match;

public interface SampleMatchRepository extends MongoRepository<Match, String> {

	List<Match> musicNameThis(String musicNameThis);
	List<Match> musicNameThat(String musicNameThat);
	  
    @Query("{'$and' : [{'musicNameThis' : ?0}, {'musicNameThat' : ?1}]}")
	Match findMatchByMusics(String musicNameThis, String musicNameThat);
	
}