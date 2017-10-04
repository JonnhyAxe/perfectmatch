package com.perfectmatch.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfectmatch.common.interfaces.ByNameSearchable;
import com.perfectmatch.persistence.model.Match;

public interface SampleMatchRepository extends JpaRepository<Match, Long>, ByNameSearchable<Match> {

}