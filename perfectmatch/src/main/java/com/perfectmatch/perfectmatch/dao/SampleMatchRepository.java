package com.perfectmatch.perfectmatch.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfectmatch.perfectmatch.persistence.model.Match;

public interface SampleMatchRepository extends JpaRepository<Match, String> {

}